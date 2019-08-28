package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DL
 */
public class DL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		int returs = 0;
		boolean valid = false;
		if(name!=null&&pwd!=null){
			if(name.equals("admin")&&name.equals("admin")){
				returs = 1; 
			}
		}
		
		if(returs>0){
			response.sendRedirect("glht.jsp");
		}
		else
		{
			response.sendRedirect("ydxw.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
