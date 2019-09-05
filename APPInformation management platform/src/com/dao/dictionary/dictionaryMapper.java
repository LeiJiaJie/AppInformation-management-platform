package com.dao.dictionary;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.AppCategory;
import com.pojo.AppInfo;
import com.pojo.AppVersion;
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
	
	/**
	 *  查询APKName是否重复
	 */
	public int selectAPK(@Param("APKName")String APKName);
	
	/**
	 * 新增APP基础信息
	 */
	public int insertAPP(AppInfo appInfo);
	/**
	 * 更新最新版本
	 */
	public int updateApp(@Param("versionId")String versionId,@Param("id") int id);
	/**
	 * 通过ID查询APP基础信息
	 */
	public AppInfo selectAppId(@Param("id")int id);
	
	/**
	 * 更新App基础信息
	 */
	public int updateAPP(AppInfo appInfo);
	/**
	 * 删除App基础信息
	 */
	public int delectApp(@Param("id")int id);
	/**
	 * 上下架App操作
	 */
	public int Update(@Param("id")int id,@Param("status")int status);
	/**
	 * 通过AppId查询App版本信息
	 */
	public List<AppVersion> SelectAppVersion(@Param("AppId")int AppId);
	/**
	 * 新增App版本信息
	 */
	public int insertAppVersion(AppVersion appVersion);
	/**
	 * 查询最新版本信息
	 */
	public AppVersion SelectVersion(@Param("AppId")int AppId);
	/**
	 * 更新最新版本信息
	 */
	public int UpdateVersion(AppVersion appVersion);
}
