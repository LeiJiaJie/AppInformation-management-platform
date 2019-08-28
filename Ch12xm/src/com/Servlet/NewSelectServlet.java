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
import com.entity.Page;
import com.entity.topic;
import com.servic.impl.NewSelectServicimpl;

/**
 * Servlet implementation class NewSelectServlet
 */
public class NewSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String org = request.getParameter("org");
		if (org != null) {
			org = new String(org.getBytes("ISO-8859-1"), "UTF-8");
		}
		switch (org) {
		case "showNews":
			this.showNews(request, response);
			break;
		case "showcomment":
			this.selectComment(request, response);
			break;
		default:
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	private void showNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewSelectServicimpl servlet = new NewSelectServicimpl();
		Page page = new Page();
		if(Integer.parseInt(request.getParameter("comment"))==0) {
			page.setCurrPageNo(Integer.parseInt(request.getParameter("currPageNo")));
			page = servlet.list(page);
		}else {
			page.setCurrPageNo(Integer.parseInt(request.getParameter("currPageNo")));
			page = servlet.iDList(page,Integer.parseInt(request.getParameter("comment")));
			page.setTotalPageCount(1);
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss"));
		out.flush();
		out.close();
	}
	
	private void selectComment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewSelectServicimpl servlet = new NewSelectServicimpl();
		List<topic> list = new ArrayList<topic>();
		list = servlet.SelectComment();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(list));
		out.flush();
		out.close();
	}
}
