package com.service;

import org.apache.ibatis.annotations.Param;

import com.pojo.BackendUser;
import com.pojo.DevUser;

public interface UserService {
	/**
	 * 登录	
	 * @return
	 */
	public DevUser login(String devCode,String devPassword);
	/**
	 * 后台登录
	 */
	public BackendUser logins(@Param("userCode")String devCode,@Param("userPassword")String devPassword);

}
