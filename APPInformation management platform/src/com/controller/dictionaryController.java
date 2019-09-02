package com.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.pojo.AppCategory;
import com.pojo.AppInfo;
import com.pojo.DataDictionary;
import com.pojo.PageSupport;
import com.service.dictionaryservice;

@Controller
@RequestMapping("/dictionary")
public class dictionaryController {
	
	private Logger logger = Logger.getLogger(Usercontroller.class);
	
	@Autowired
	private dictionaryservice dictionaryservice;
	
	@RequestMapping("list")
	public String SelectList(Model model,
			@RequestParam(value="querySoftwareName",required=false)String querySoftwareName,
			@RequestParam(value="queryStatus",required=false)Integer queryStatus,
			@RequestParam(value="queryFlatformId",required=false)Integer queryFlatformId,
			@RequestParam(value="queryCategoryLevel1",required=false)Integer queryCategoryLevel1,
			@RequestParam(value="queryCategoryLevel2",required=false)Integer queryCategoryLevel2,
			@RequestParam(value="queryCategoryLevel3",required=false)Integer queryCategoryLevel3,
			@RequestParam(value="pageIndex",required=false)Integer pageIndex) {
		List<DataDictionary> list1 = dictionaryservice.selectDictionary("APP状态");
		List<DataDictionary> list2 = dictionaryservice.selectDictionary("所属平台");
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
	
	@RequestMapping("categorylevellist.json")
	@ResponseBody
	public Object categorylevellist(int pid) {
		List<AppCategory> list3 = dictionaryservice.selectCategory(pid);
		return JSON.toJSONString(list3);
	}
	
	@RequestMapping("add")
	public String Add() {
		return "developer/appinfoadd";
	}
	
	@RequestMapping("datadictionarylist.json")
	@ResponseBody
	public Object categorylevellist(String tcode) {
		List<DataDictionary> list2 = dictionaryservice.selectDictionary("所属平台");
		return JSON.toJSONString(list2);
	}
	
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
	
	@RequestMapping(value="appinfoaddsave",method=RequestMethod.POST)
	public String appinfoadd(AppInfo Info,@RequestParam(value="a_logoPicPath",required=false)MultipartFile attach,
			HttpSession session,
			HttpServletRequest request) {
		String idPicPath = null;		//照片的路径
		//判断文件是否为空
		if(!attach.isEmpty()){
			//设置你要保存的路径
			String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
			logger.debug("path========>" + path);
			String oldFileName = attach.getOriginalFilename();		//原文件名
			logger.debug("oldFileName========>" + oldFileName);
			String prefix = FilenameUtils.getExtension(oldFileName);	//源文件后缀
			
			int filesize = 500000;
			logger.debug("oldFileName========>" + attach.getSize());
			if(attach.getSize() > filesize){
				request.setAttribute("uploadFileError", "上传大小不能超过500KB");
				return "useradd";
			} else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") ||
					prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {
				//文件的新名称
				String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Personal.jpg";
				logger.debug("fileName========>" + fileName);
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
        Info.setLogoPicPath(logoPicPath);
		if(dictionaryservice.insertAPP(Info)>0) {
			return "redirect:/dictionary/list";
		}
		return "redirect:/dictionary/add";
	}
	
}
