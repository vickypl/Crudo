package com.crudo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudo.bo.Admin;
import com.crudo.dao.AdminDao;
import com.crudo.factory.DaoFactory;

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetching params
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminDao adminDao = DaoFactory.getAdminDao();
		Admin admin = null;
					admin = adminDao.validateAdmin(username, password);
		if(admin!=null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("admin", admin);
			adminDao.updateLastLogin(Integer.parseInt(admin.getId()));
			request.setAttribute("msg", "Welcome Admin");
			RequestDispatcher rd = request.getRequestDispatcher("adminloggedin.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "Username or Password Invalid");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	}

}
