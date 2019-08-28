package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.entity.News;
import com.entity.topic;
import com.servic.impl.NewSelectServicimpl;
import com.servic.impl.glhtServicimpl;

/**
 * Servlet implementation class glhtSelectSerlet
 */
public class glhtSelectSerlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String org = request.getParameter("org");
		switch (org) {
		case "showNews":
			this.selectList(request, response);
			break;
		case "selectTopic":
			this.selectTopic(request, response);
			break;
		case "xgzt":
			this.UpdateTopic(request, response);
			break;
		case "sczt":
			this.DeleteTopic(request, response);
			break;
		case "insertTopic":
			this.insertTopic(request, response);
			break;
		default:
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
	protected void selectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		glhtServicimpl serlet = new glhtServicimpl();
		List<News> list = new ArrayList<News>();
		list = serlet.list();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(list));
		out.flush();
		out.close();
	}
	
	protected void selectTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewSelectServicimpl serlet = new NewSelectServicimpl();
		List<topic> list = new ArrayList<topic>();
		list = serlet.SelectComment();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(list));
		out.flush();
		out.close();
	}
	
	protected void UpdateTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		glhtServicimpl serlet = new glhtServicimpl();
		topic topic = new topic(Integer.parseInt(request.getParameter("id")), request.getParameter("name"));
		String pd = serlet.UpdataTopic(topic);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(pd);
		out.flush();
		out.close();
	}
	
	protected void DeleteTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		glhtServicimpl topic = new glhtServicimpl();
		String id = request.getParameter("id");
		String pd = topic.DeleteTopic(Integer.parseInt(id));
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(pd);
		out.flush();
		out.close();
	}
	
	protected void insertTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		glhtServicimpl topic = new glhtServicimpl();
		String name = request.getParameter("name");
		String pd = topic.insertTopic(name);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(pd);
		out.flush();
		out.close();
	}
}
