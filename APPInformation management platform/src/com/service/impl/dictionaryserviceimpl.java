package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.dao.dictionary.dictionaryMapper;
import com.pojo.AppCategory;
import com.pojo.AppInfo;
import com.pojo.DataDictionary;
import com.service.dictionaryservice;
@Service("dictionaryservice")
public class dictionaryserviceimpl implements dictionaryservice{

	private Logger logger = Logger.getLogger(UserServiceimpl.class);
	@Resource
	private dictionaryMapper dictionaryMapper;
	
	public List<DataDictionary> selectDictionary(String typeName) {
		List<DataDictionary> list = null;
		try {
			list = dictionaryMapper.selectDictionary(typeName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AppCategory> selectCategory(int id) {
		List<AppCategory> list = null;
		try {
			list = dictionaryMapper.selectCategory(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AppInfo> selectList(String querySoftwareName,
			Integer queryStatus,
			Integer queryFlatformId,
			Integer queryCategoryLevel1,
			Integer queryCategoryLevel2,
			Integer queryCategoryLevel3,
			int currentpageNo,
			int pageSize) {
		List<AppInfo> list = null;
		try {
			int currentPageNo = (currentpageNo - 1) * pageSize;
			logger.debug(currentPageNo+""+pageSize);
			list = dictionaryMapper.selectList(querySoftwareName, queryStatus, queryFlatformId, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, currentPageNo, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int AppInfocount(String querySoftwareName, Integer queryStatus, Integer queryFlatformId,
			Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3) {
		int mun = 0;
		try {
			mun = dictionaryMapper.AppInfocount(querySoftwareName, queryStatus, queryFlatformId, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mun;
	}

	@Override
	public int selectAPK(String APKName) {
		int mun = 0;
		try {
			mun = dictionaryMapper.selectAPK(APKName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mun;
	}

	@Override
	public int insertAPP(AppInfo appInfo) {
		int mun = 0;
		try {
			mun = dictionaryMapper.insertAPP(appInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mun;
	}
	
}
