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

public class DeleteUserTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session
		HttpSession httpSession = request.getSession();
		if(httpSession==null || (httpSession!=null && httpSession.getAttribute("user")==null)) {
			response.sendRedirect("index.jsp?msg=Login Required");
			return;
		}
		User user = (User)httpSession.getAttribute("user");
		
		String id = request.getParameter("id");
		int todoId = Integer.parseInt(id);
		
		TodoDao todoDao = DaoFactory.getTodoDao();
		String sql="delete from todolist where id='"+todoId+"'";
		boolean isDeleted = todoDao.deleteTodo(sql);
		if(isDeleted) {
			sql="select * from todolist where userid='"+user.getId()+"'";
			ArrayList<Todo> todoList = todoDao.getTodoList(sql);
			httpSession.setAttribute("todoList", todoList);
			response.sendRedirect("usertodolist.jsp?msg=todo Deleted");
		} else {
			response.sendRedirect("usertodolist.jsp?msg=Unable to Deleted try later");			
		}
	}

}
