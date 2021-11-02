package com.crudo.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

public class UserUpdateTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session
		HttpSession httpSession = request.getSession();
		if(httpSession==null || (httpSession!=null && httpSession.getAttribute("user")==null)) {
			response.sendRedirect("index.jsp?msg=Login Required");
			return;
		}
		String id = request.getParameter("id");
		int todoId = Integer.parseInt(id);
		
		TodoDao todoDao = DaoFactory.getTodoDao();
		String sql="select * from todolist where id='"+todoId+"'";
		Todo todo = todoDao.getTodo(sql);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<form method='post' action='updatetodo'>");
		out.print("<input type='hidden' name='id' value='"+todo.getId()+"' />");
		out.print("<div class='form-group'>");
		out.print("<label for='exampleInputEmail1'>Title</label>");
		out.print("<input type='text' name='title' value='"+todo.getTitle()+"' maxlength='20' required class='form-control' id='exampleInputEmail1' aria-describedby='emailHelp' placeholder='Title'>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='exampleInputEmail1'>Details</label>");
		out.print("<textarea type='text' name='details' value='"+todo.getDetails()+"' maxlength='200' required class='form-control' id='exampleInputEmail1' aria-describedby='emailHelp' placeholder='Details'></textarea>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='exampleInputEmail1'>Priority</label>");
		out.print("<select class='form-control' name='priority' value='"+todo.getPriority()+"' id=''>");
		out.print("<option value='high'>High</option>");
		out.print("<option value='mid'>Medium</option>");
		out.print("<option value='low'>Low</option>");
		out.print("</select>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='exampleInputEmail1'>Status</label>");
		out.print("<select class='form-control' name='status' value='"+todo.getStatus()+"' id=''>");
		out.print("<option value='pending'>Pending</option>");
		out.print("<option value='done'>Done</option>");
		out.print("<option value='progress'>Progress</option>");
		out.print("</select>");
		out.print("</div>");
		out.print("<button type='submit' class='btn btn-success btn-block'>Update Todo</button>");
		out.print("</form>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session
		HttpSession httpSession = request.getSession();
		if(httpSession==null || (httpSession!=null && httpSession.getAttribute("user")==null)) {
			response.sendRedirect("index.jsp?msg=Login Required");
			return;
		}
		User user = (User)httpSession.getAttribute("user");
		
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String details = request.getParameter("details");
		String priority = request.getParameter("priority");
		String status = request.getParameter("status");
		
		int todoId = Integer.parseInt(id);
		
		TodoDao todoDao = DaoFactory.getTodoDao();
		boolean isUpdated = todoDao.updateTodo(todoId, title, details, priority, status);
		if(isUpdated) {
			String sql="select * from todolist where userid='"+user.getId()+"'";
			ArrayList<Todo> todoList = todoDao.getTodoList(sql);
			httpSession.setAttribute("todoList", todoList);
			response.sendRedirect("usertodolist.jsp?msg=Successfully Updated");
		} else {
			response.sendRedirect("usertodolist.jsp?msg=Problem in updating try later.");
		}
		
	}

}
