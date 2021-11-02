package com.crudo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudo.bo.User;
import com.crudo.dao.TodoDao;
import com.crudo.dao.UserDao;
import com.crudo.factory.DaoFactory;

public class UserAccountDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//session
		HttpSession httpSession = request.getSession();
		if(httpSession==null || (httpSession!=null && httpSession.getAttribute("user")==null)) {
			response.sendRedirect("index.jsp?msg=Login Required");
			return;
		}
		User user = (User)httpSession.getAttribute("user");
		
		String userpassword = request.getParameter("pwd");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(!userpassword.equals(user.getPassword())) {
			out.print("<h3 class='h3'>Invalid Password..</h3>");
			return;
		}
		
		
		//deleting todos realated with user
		TodoDao todoDao = DaoFactory.getTodoDao();
		String sql = "delete from todolist where userid='"+user.getId()+"'";
		todoDao.deleteTodo(sql);
	
		//deleting user
		UserDao userDao = DaoFactory.getUserDao();
		boolean isUserDeleted = userDao.deleteUser(user.getId());
	
		if(isUserDeleted) {
			out.print("<h3 style='color: red' class='h3'>Account Deleted, Logout Now..</h3>");
		} else {
			out.print("<h3 style='color: red' class='h3'>Problem In Deleting Try later..</h3>");
		}
	}

}
