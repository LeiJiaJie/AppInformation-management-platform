package com.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.dao.user.userMapper;
import com.pojo.DevUser;
import com.service.UserService;
@Service("UserService")
public class UserServiceimpl implements UserService {

	private Logger logger = Logger.getLogger(UserServiceimpl.class);
	@Resource
	private userMapper userMapper;
	@Override
	public DevUser login(String devCode, String devPassword) {
		DevUser devUser = null;
		try {
			devUser = userMapper.login(devCode, devPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return devUser;
	}
}
