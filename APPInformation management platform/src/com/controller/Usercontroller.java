package com.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.BackendUser;
import com.pojo.DevUser;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class Usercontroller {
	private Logger logger = Logger.getLogger(Usercontroller.class);
	
	@Autowired
	private UserService userService;
	/**
	 * 登录的方法
	 * @param devCode
	 * @param devPassword
	 * @param session
	 * @return
	 */
	@RequestMapping("/openlogin")
	public String openlogin() {
	   return "devlogin";
	}
	
	@RequestMapping(value="/dologin")
	public String login(String devCode,String devPassword,HttpSession session) {
		DevUser devUser = userService.login(devCode, devPassword);
		if(devUser!=null) {
			session.setAttribute("devUserSession", devUser);
			return "developer/main";
		}
		return "devlogin";
	}
	/**
	 * 注销的方法
	 * @param session
	 * @return
	 */
	@RequestMapping(value="logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("devUserSession")!=null||session.getAttribute("userSession")!=null) {
			session.removeAttribute("devUserSession");
			session.removeAttribute("userSession");
		}
		return "login";
	}
	
	//--------------------------------------------->后台的方法
	/**
	 * 后台进入登录页面的方法
	 * @return
	 */
	@RequestMapping("backlogin")
	public String backlogin() {
		return "backendlogin";
	}
	/**
	 * 后台登录方法
	 * @param devCode
	 * @param devPassword
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login")
	public String dologin(String userCode,String userPassword,HttpSession session) {
		BackendUser devUser = userService.logins(userCode, userPassword);
		if(devUser!=null) {
			session.setAttribute("userSession", devUser);
			return "backend/main";
		}
		return "backendlogin";
	}
	
	
	
}