package com.crudo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudo.bo.User;
import com.crudo.dao.UserDao;
import com.crudo.factory.DaoFactory;

public class BlockUserService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session
		HttpSession httpSession = request.getSession();
		if(httpSession==null || (httpSession!=null && httpSession.getAttribute("admin")==null)) {
			response.sendRedirect("index.jsp?msg=Login Required");
			return;
		}
		
		String userId = request.getParameter("id");
		String blockStatus = request.getParameter("value");
		
		UserDao userDao = DaoFactory.getUserDao();
		
		if(blockStatus.equals("blocked")) {
			userDao.unblockUser(userId);
			String sql="select * from users";
			ArrayList<User> userList = userDao.getUserList(sql);
			httpSession.setAttribute("userList", userList);
			response.sendRedirect("adminuserlist.jsp?msg=User Unblocked");
		} else if(blockStatus.equals("unblocked")) {
			userDao.blockUser(userId);
			String sql="select * from users";
			ArrayList<User> userList = userDao.getUserList(sql);
			httpSession.setAttribute("userList", userList);
			response.sendRedirect("adminuserlist.jsp?msg=User Blocked");
		}
	
	}

}
