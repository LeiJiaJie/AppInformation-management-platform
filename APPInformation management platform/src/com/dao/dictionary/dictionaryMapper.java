package com.dao.dictionary;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.AppCategory;
import com.pojo.AppInfo;
import com.pojo.DataDictionary;

public interface dictionaryMapper {
	/**
	 * 查询所有App状态和平台
	 */
	public List<DataDictionary> selectDictionary(@Param("typeName")String typeName);
	
	/**
	 * 查询一二三级菜单
	 */
	public List<AppCategory> selectCategory(@Param("id")int id);
	
	/**
	 * 查询所有的软件信息
	 */
	public List<AppInfo> selectList(@Param("querySoftwareName")String querySoftwareName,
			@Param("queryStatus")Integer queryStatus,
			@Param("queryFlatformId")Integer queryFlatformId,
			@Param("queryCategoryLevel1")Integer queryCategoryLevel1,
			@Param("queryCategoryLevel2")Integer queryCategoryLevel2,
			@Param("queryCategoryLevel3")Integer queryCategoryLevel3,
			@Param("currentpageNo")int currentpageNo,
			@Param("pageSize")int pageSize);
	
	/**
	 * 查询总页数
	 */
	public int AppInfocount(@Param("querySoftwareName")String querySoftwareName,
			@Param("queryStatus")Integer queryStatus,
			@Param("queryFlatformId")Integer queryFlatformId,
			@Param("queryCategoryLevel1")Integer queryCategoryLevel1,
			@Param("queryCategoryLevel2")Integer queryCategoryLevel2,
			@Param("queryCategoryLevel3")Integer queryCategoryLevel3);
}
