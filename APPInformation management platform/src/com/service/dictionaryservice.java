package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.AppCategory;
import com.pojo.AppInfo;
import com.pojo.AppVersion;
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
	
	/**
	 *  查询APKName是否重复
	 */
	public int selectAPK(String APKName);
	
	/**
	 * 新增APP基础信息
	 */
	public int insertAPP(AppInfo appInfo);
	
	/**
	 * 通过ID查询APP基础信息
	 */
	public AppInfo selectAppId(int id);
	/**
	 * 更新App版本信息
	 */
	public int UpdateApp(AppInfo appInfo);
	/**
	 * 删除App基础信息
	 */
	public int delectApp(int id);
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
	/**
	 * 更新最新版本
	 */
	public int updateApp(@Param("versionId")String versionId,@Param("id") int id);
}
