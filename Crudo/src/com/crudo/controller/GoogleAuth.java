package com.crudo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudo.bo.User;
import com.crudo.dao.UserDao;
import com.crudo.factory.DaoFactory;

public class GoogleAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		
		UserDao userDao = DaoFactory.getUserDao();
		
		User user = null;
			String sql = "select * from users where email='"+email+"'";
			user = userDao.getUser(sql);
			
			if(user!=null) {
				if(user.getBlocking().equals("unblocked")) {
					HttpSession session = request.getSession(true);
					session.setAttribute("user", user);
					userDao.updateUserLastLogin(user.getUsername());
					request.setAttribute("msg", "Welcome "+user.getUsername());
					RequestDispatcher rd = request.getRequestDispatcher("userloggedin.jsp");
					rd.forward(request, response);
				}
			} else {
				response.sendRedirect("index.jsp?msg=SignUp Required..");
			}
	}

}
