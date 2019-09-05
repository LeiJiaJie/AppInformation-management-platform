package com.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.pojo.AppCategory;
import com.pojo.AppInfo;
import com.pojo.AppVersion;
import com.pojo.DataDictionary;
import com.pojo.DevUser;
import com.pojo.PageSupport;
import com.service.dictionaryservice;

@Controller
@RequestMapping("/dictionary")
public class dictionaryController {
	
	private Logger logger = Logger.getLogger(Usercontroller.class);
	
	@Autowired
	private dictionaryservice dictionaryservice;
	/**
	 * 页面初始化
	 * @param model
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryFlatformId
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping("list")
	public String SelectList(Model model,
			@RequestParam(value="querySoftwareName",required=false)String querySoftwareName,
			@RequestParam(value="queryStatus",required=false)Integer queryStatus,
			@RequestParam(value="queryFlatformId",required=false)Integer queryFlatformId,
			@RequestParam(value="queryCategoryLevel1",required=false)Integer queryCategoryLevel1,
			@RequestParam(value="queryCategoryLevel2",required=false)Integer queryCategoryLevel2,
			@RequestParam(value="queryCategoryLevel3",required=false)Integer queryCategoryLevel3,
			@RequestParam(value="pageIndex",required=false)Integer pageIndex) {
		List<DataDictionary> list1 = dictionaryservice.selectDictionary("APP_STATUS");
		List<DataDictionary> list2 = dictionaryservice.selectDictionary("APP_FLATFORM");
		List<AppCategory> list3 = dictionaryservice.selectCategory(0);
		int pageSize = 5;
		//当前页码
		int currentpageNo = 1;
		
		if(querySoftwareName == null) {
			querySoftwareName = "";
		}
		if(queryStatus == null) {
			queryStatus = 0;
		}
		if(queryFlatformId == null) {
			queryFlatformId = 0;
		}
		if(queryCategoryLevel1 == null) {
			queryCategoryLevel1 = 0;
		}
		if(queryCategoryLevel2 == null) {
			queryCategoryLevel2 = 0;
		}
		if(queryCategoryLevel3 == null) {
			queryCategoryLevel3 = 0;
		}
		if(pageIndex != null){
			try {
				currentpageNo = pageIndex;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//总数量
		int totalCount = dictionaryservice.AppInfocount(querySoftwareName, queryStatus, queryFlatformId, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3);
				
		//总页数
		PageSupport page = new PageSupport();
		page.setCurrentPageNo(currentpageNo);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		int totalPageCount = page.getTotalPageCount();
		//控制首页和尾页
		if(currentpageNo < 1){
			currentpageNo = 1;
		} else if(currentpageNo > totalPageCount){
			currentpageNo = totalPageCount;
		}
	
		List<AppInfo> list4 = dictionaryservice.selectList(querySoftwareName, queryStatus, queryFlatformId, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, currentpageNo, pageSize);
		model.addAttribute("pages", page);
		model.addAttribute("statusList", list1);
		model.addAttribute("flatFormList", list2);
		model.addAttribute("categoryLevel1List", list3);
		model.addAttribute("appInfoList", list4);
		
		model.addAttribute("querySoftwareName", querySoftwareName);
		model.addAttribute("queryStatus", queryStatus);
		model.addAttribute("queryFlatformId", queryFlatformId);
		model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
		model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
		model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
		return "developer/appinfolist";
	}
	/**
	 * 加载三级菜单
	 * @param pid
	 * @return
	 */
	@RequestMapping("categorylevellist.json")
	@ResponseBody
	public Object categorylevellist(@RequestParam int pid) {
		 
		List<AppCategory> list3 = dictionaryservice.selectCategory(pid);
		return JSON.toJSONString(list3);
	}
	/**
	 * 进入添加页面
	 * @return
	 */
	@RequestMapping("add")
	public String Add() {
		return "developer/appinfoadd";
	}
	/**
	 * 初始化App状态页面
	 * @param tcode
	 * @return
	 */
	@RequestMapping("datadictionarylist.json")
	@ResponseBody
	public Object DataDictionarylist(@RequestParam String tcode) {
		logger.debug("------------------------------->"+tcode);
		List<DataDictionary> list2 = dictionaryservice.selectDictionary(tcode);
		return JSON.toJSONString(list2);
	}
	/**
	 * 判断APK是否重复
	 * @param APKName
	 * @return
	 */
	@RequestMapping("apkexist.json")
	@ResponseBody
	public Object apkexist(String APKName) {
		Map<String, String> map = new HashMap<String, String>();
		if(APKName == null) {
			map.put("APKName", "empty");
		}else if(dictionaryservice.selectAPK(APKName)>0) {
			map.put("APKName", "exist");
		}else {
			map.put("APKName", "noexist");
		}
		return map;
	}
	/**
	 * 添加的方法
	 * @param Info
	 * @param attach
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="appinfoaddsave",method=RequestMethod.POST)
	public String appinfoadd(AppInfo Info,@RequestParam(value="a_logoPicPath",required=false)MultipartFile attach,
			HttpSession session,
			HttpServletRequest request) {
		String idPicPath = null;		//照片的路径
		//判断文件是否为空
		if(!attach.isEmpty()){
			//设置你要保存的路径
			String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
			String oldFileName = attach.getOriginalFilename();		//原文件名
			String prefix = FilenameUtils.getExtension(oldFileName);	//源文件后缀
			
			int filesize = 500000;
			if(attach.getSize() > filesize){
				request.setAttribute("uploadFileError", "上传大小不能超过500KB");
				return "useradd";
			} else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") ||
					prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {
				//文件的新名称
				String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Personal.jpg";
				File targetFile = new File(path,fileName);
				if(!targetFile.exists()){
					targetFile.mkdirs();
				}
				//保存
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("uploadFileError", "文件上传失败！");
					return "useradd";
				}
				//这是要保存到数据库的
				idPicPath = path+File.separator + fileName;
			} else {
				request.setAttribute("uploadFileError", "文件格式不正确！");
				return "useradd";
			}
		}
		//调用保存的方法，实现保存
		Info.setCreationDate(new Date());
		Info.setLogoLocPath(idPicPath);
		String str = idPicPath;
        String logoPicPath = str.substring(str.lastIndexOf("/")+73,str.length());
        Info.setLogoPicPath(logoPicPath.replace("\\", "/"));
		if(dictionaryservice.insertAPP(Info)>0) {
			return "redirect:/dictionary/list";
		}
		return "redirect:/dictionary/add";
	}
	/**
	 * 更新加载时的数据
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("appinfomodify/{id}")
	public String appinfomodifyeves(@PathVariable int id,Model model) {
		AppInfo appInfo = dictionaryservice.selectAppId(id);
		try {
			appInfo.setLogoLocPath(URLDecoder.decode(appInfo.getLogoLocPath(), "UTF-8"));
			appInfo.setLogoPicPath(URLDecoder.decode(appInfo.getLogoPicPath(), "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("appInfo", appInfo);
		return "developer/appinfomodify";
	}
	/**
	 * 执行更新操作
	 * @param appInfo
	 * @return
	 */
	@RequestMapping("appinfomodifysave")
	public String appinfomodifysave(AppInfo appInfo) {
		if(dictionaryservice.UpdateApp(appInfo)>0) {
			return "redirect:/dictionary/list";
		}
		return "developer/appinfomodify";
	}
	/**
	 * 执行删除操作
	 * @param id
	 * @return
	 */
	@RequestMapping("delapp.json")
	@ResponseBody
	public Object delect(int id) {
		Map<String, String> map = new HashMap<String, String>();
		if(dictionaryservice.delectApp(id)>0) {
			map.put("delResult", "true");
		}else if(dictionaryservice.delectApp(id)==0){
			map.put("delResult", "false");
		}else {
			map.put("delResult", "notexist");
		} 
		return map;
	}
	/**
	 * 执行上下架操作
	 * @param id
	 * @return
	 */
	@RequestMapping("sale.json")
	@ResponseBody
	public Object sale(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		AppInfo appInfo = dictionaryservice.selectAppId(id);
		if(appInfo == null) {
			map.put("errorCode", "param000001");
			return map; 
		}
		int i = appInfo.getStatus()==4?dictionaryservice.Update(id, 5):dictionaryservice.Update(id, 4);
		if(i>0) {
			map.put("errorCode","0");
			map.put("resultMsg", "success");
		}else {
			map.put("resultMsg", "failed");
		}
		return map;
	}
	/**
	 * 查看App信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("appview/{id}")
	public String appview(@PathVariable int id,Model model) {
		model.addAttribute("appInfo", dictionaryservice.selectAppId(id));
		List<AppVersion> appVersionList = dictionaryservice.SelectAppVersion(id);
		for (AppVersion appVersion : appVersionList) {
			try {
				appVersion.setDownloadLink(URLDecoder.decode(appVersion.getDownloadLink(), "UTF-8"));
				appVersion.setApkFileName(URLDecoder.decode(appVersion.getApkFileName(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("appVersionList",appVersionList);
		return "developer/appinfoview";
	}
	/**
	 * 新增App版本信息赋初值
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("appversionadd/{id}")
	public String appversionadd(@PathVariable int id,Model model) {
		model.addAttribute("appVersionList", dictionaryservice.SelectAppVersion(id));
		model.addAttribute("appId", id);
		return "developer/appversionadd";
	}
	/**
	 * 新增App版本信息
	 * @param version
	 * @return
	 */
	@RequestMapping("/addversionsave")
	public String addversionsave(AppVersion version,@RequestParam(value="a_downloadLink",required=false)MultipartFile attach,
			HttpSession session,
			HttpServletRequest request) {
		String idPicPath = null;		//文件的路径
		 String logoPicPath = null;
		 String downloadLink = null;
		//判断文件是否为空
		if(!attach.isEmpty()){
			//设置你要保存的路径
			String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
			String oldFileName = attach.getOriginalFilename();		//原文件名
			String prefix = FilenameUtils.getExtension(oldFileName);	//源文件后缀
			
			int filesize = 5120000;
			if(attach.getSize() > filesize){
				request.setAttribute("uploadFileError", "上传大小不能超过500Mb");
				logger.debug("上传大小不能超过500Mb");
				return "appversionadd";
			} else if(prefix.equalsIgnoreCase("apk")) {
				//文件的新名称
				String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Personal.apk";
				File targetFile = new File(path,fileName);
				if(!targetFile.exists()){
					targetFile.mkdirs();
				}
				//保存
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("uploadFileError", "文件上传失败！");
					logger.debug("文件上传失败！");
					return "appversionadd";
				}
				//这是要保存到数据库的
				idPicPath = path+File.separator + fileName;
				logoPicPath = oldFileName;
				downloadLink =idPicPath.substring(idPicPath.indexOf("APPInformation management platform")-1); 
			} else {
				request.setAttribute("uploadFileError", "文件格式不正确！");
				logger.debug("文件格式不正确！");
				return "appversionadd";
			}
		}
				//调用保存的方法，实现保存
		        version.setCreatedBy(((DevUser)session.getAttribute("devUserSession")).getId());
		        version.setModifyDate(new Date());
				version.setCreationDate(new Date());
				version.setApkLocPath(idPicPath);
				version.setDownloadLink(downloadLink);
		        version.setApkFileName(logoPicPath);
		        int i = dictionaryservice.insertAppVersion(version);
		        AppVersion appVersion = dictionaryservice.SelectVersion(version.getAppId());
				if(i>0&&dictionaryservice.updateApp(appVersion.getId().toString(), version.getAppId())>0) {
					return "redirect:/dictionary/list";
				}
				return "appversionadd";
	}
	/**
	 * 更新版本信息页面初始化
	 * @param model
	 * @param vid
	 * @param aid
	 * @return
	 */
	@RequestMapping("appversionmodify/{vid}/{aid}")
	public String appversionmodify(Model model,@PathVariable int vid,@PathVariable int aid) {
		model.addAttribute("appVersionList", dictionaryservice.SelectAppVersion(aid));
		model.addAttribute("appVersion",dictionaryservice.SelectVersion(aid));
		return "developer/appversionmodify";
	}
	/**
	 * 更新版本内容
	 */
	@RequestMapping("appversionmodifysave")
	public String appversionmodifysave(AppVersion appVersion) {
		if(dictionaryservice.UpdateVersion(appVersion)>0) {
			return "redirect:/dictionary/list";
		}
		return "developer/appversionmodify";
	}
}
