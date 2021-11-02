package com.crudo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudo.bo.User;
import com.crudo.dao.TodoDao;
import com.crudo.dao.UserDao;
import com.crudo.factory.DaoFactory;

public class DeleteUserService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session
		HttpSession httpSession = request.getSession();
		if(httpSession==null || (httpSession!=null && httpSession.getAttribute("admin")==null)) {
			response.sendRedirect("index.jsp?msg=Login Required");
			return;
		}
		
		
		String id = request.getParameter("id");
		
		//deleting todos realated with user
		TodoDao todoDao = DaoFactory.getTodoDao();
		String sql = "delete from todolist where userid='"+id+"'";
		todoDao.deleteTodo(sql);
	
		//deleting user
		UserDao userDao = DaoFactory.getUserDao();
		boolean isUserDeleted = userDao.deleteUser(id);
	
		if(isUserDeleted) {
			sql="select * from users";
			ArrayList<User> userList = userDao.getUserList(sql);
			httpSession.setAttribute("userList", userList);
			response.sendRedirect("adminuserlist.jsp?msg=User Successfully Deleted");
		} else {
			response.sendRedirect("adminuserlist.jsp?msg=Problem in Deleting... try later");
		}
	}

}
