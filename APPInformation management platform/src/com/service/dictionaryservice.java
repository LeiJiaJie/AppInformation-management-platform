package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.AppCategory;
import com.pojo.AppInfo;
import com.pojo.DataDictionary;

public interface dictionaryservice {
	/**
	 * 查询所有App状态和平台
	 */
	public List<DataDictionary> selectDictionary(String typeName);
	
	/**
	 * 查询一二三级菜单
	 */
	public List<AppCategory> selectCategory(int id);
	/**
	 * 查询所有的软件信息
	 */
	public List<AppInfo> selectList(String querySoftwareName,
			Integer queryStatus,
			Integer queryFlatformId,
			Integer queryCategoryLevel1,
			Integer queryCategoryLevel2,
			Integer queryCategoryLevel3,
			int currentpageNo,
			int pageSize);
	/**
	 * 查询总页数
	 */
	public int AppInfocount(String querySoftwareName,
			Integer queryStatus,
			Integer queryFlatformId,
			Integer queryCategoryLevel1,
			Integer queryCategoryLevel2,
			Integer queryCategoryLevel3);
	
}
