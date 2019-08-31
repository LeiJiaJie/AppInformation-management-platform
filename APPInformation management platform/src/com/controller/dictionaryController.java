package com.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
