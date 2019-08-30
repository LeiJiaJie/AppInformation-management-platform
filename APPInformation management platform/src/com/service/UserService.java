package com.service;

import com.pojo.DevUser;

public interface UserService {
	/**
	 * 登录	
	 * @return
	 */
	public DevUser login(String devCode,String devPassword);
}
