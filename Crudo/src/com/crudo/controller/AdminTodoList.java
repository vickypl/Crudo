package com.crudo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudo.bo.Todo;
import com.crudo.dao.TodoDao;
import com.crudo.factory.DaoFactory;

public class AdminTodoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//session
		HttpSession httpSession = request.getSession();
		if(httpSession==null || (httpSession!=null && httpSession.getAttribute("admin")==null)) {
			response.sendRedirect("index.jsp?msg=Login Required");
			return;
		}
		
		TodoDao todoDao = DaoFactory.getTodoDao();
		String sql="select * from todolist";
		ArrayList<Todo> todoList = todoDao.getTodoList(sql);
		request.setAttribute("todoList", todoList);
		RequestDispatcher rd = request.getRequestDispatcher("admintodolist.jsp");
		rd.forward(request, response);
	}

}
