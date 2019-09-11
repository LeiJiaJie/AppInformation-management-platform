package com.dao.user;

import org.apache.ibatis.annotations.Param;

import com.pojo.BackendUser;
import com.pojo.DevUser;

public interface userMapper {
	/**
	 * 登录	
	 * @return
	 */
	public DevUser login(@Param("devCode")String devCode,@Param("devPassword")String devPassword);
	/**
	 * 后台登录
	 */
	public BackendUser logins(@Param("userCode")String userCode,@Param("userPassword")String userPassword);
}
