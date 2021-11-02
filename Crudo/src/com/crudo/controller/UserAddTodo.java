package com.crudo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudo.bo.Todo;
import com.crudo.bo.User;
import com.crudo.dao.TodoDao;
import com.crudo.factory.DaoFactory;

public class UserAddTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session
		HttpSession httpSession = request.getSession();
		if(httpSession==null || (httpSession!=null && httpSession.getAttribute("user")==null)) {
			response.sendRedirect("index.jsp?msg=Login Required");
			return;
		}
		User user = (User)httpSession.getAttribute("user");
		int userId = Integer.parseInt(user.getId());
		String title = request.getParameter("title");
		String details = request.getParameter("details");
		String priority = request.getParameter("priority");
		String status = request.getParameter("status");
		
		TodoDao todoDao = DaoFactory.getTodoDao();
		boolean isAdded = todoDao.addTodo(userId, title, details, priority, status);
		
		if(isAdded) {
			String sql="select * from todolist where userid='"+user.getId()+"'";
			ArrayList<Todo> todoList = todoDao.getTodoList(sql);
			httpSession.setAttribute("todoList", todoList);
			response.sendRedirect("usertodolist.jsp?msg=Successfully Added");
		} else {
			response.sendRedirect("usertodolist.jsp?msg=Problem in Adding try later.");
		}
		
	}

}
