package com.crudo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudo.bo.Admin;
import com.crudo.dao.AdminDao;
import com.crudo.factory.DaoFactory;

public class AdminInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session
		HttpSession httpSession = request.getSession();
		if(httpSession==null || (httpSession!=null && httpSession.getAttribute("admin")==null)) {
			response.sendRedirect("index.jsp?msg=Login Required");
			return;
		}
		Admin admin = (Admin)httpSession.getAttribute("admin");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<form method='POST' action='admininfoupdate'>");
		out.print("<div class='form-group'>");
		out.print("<label for='exampleInputEmail1'>First Name</label>");
		out.print("<input type='text' name='fname' value='"+admin.getFirstname()+"' maxlength='20' required class='form-control'");
		out.print("id='exampleInputEmail1' aria-describedby='emailHelp' placeholder='First Name'>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='exampleInputEmail1'>Last Name</label>");
		out.print("<input type='text' name='lname' maxlength='20' value='"+admin.getLastname()+"' required class='form-control' id='exampleInputEmail1' aria-describedby='emailHelp' placeholder='Last Name'>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='exampleInputEmail1'>E-mail</label>");
		out.print("<input type='email' name='email' value='"+admin.getEmail()+"' maxlength='45' required class='form-control' id='exampleInputEmail1' aria-describedby='emailHelp' placeholder='E-mail'>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='exampleInputEmail1'>Username</label>");
		out.print("<input type='text' name='username' value='"+admin.getUsername()+"' minlength='8' maxlength='30' required class='form-control' id='exampleInputEmail1' aria-describedby='emailHelp' placeholder='Username'>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='exampleInputEmail1'>Password</label>");
		out.print("<input type='text' name='password' value='"+admin.getPassword()+"' maxlength='20' required class='form-control' id='exampleInputEmail1' aria-describedby='emailHelp' placeholder='Password'>");
		out.print("</div>");
		out.print("<div class='form-group form-check'>");
		out.print("<input type='checkbox' class='form-check-input' required id='exampleCheck1'>");
		out.print("<label class='form-check-label' for='exampleCheck1'>I accept the terms and Conditions.</label>");
		out.print("</div>");
		out.print("<button type='submit' class='btn btn-primary btn-block'>Update</button>");
		out.print("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session
		HttpSession httpSession = request.getSession();
		if(httpSession==null || (httpSession!=null && httpSession.getAttribute("admin")==null)) {
			response.sendRedirect("index.jsp?msg=Login Required");
			return;
		}
		Admin admin = (Admin)httpSession.getAttribute("admin");
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminDao adminDao = DaoFactory.getAdminDao();
		int adminId = Integer.parseInt(admin.getId());
		boolean isUpdated = adminDao.updateAdmin(adminId, fname, lname, email, username, password);
		
		if(isUpdated) {
			response.sendRedirect("adminloggedin.jsp?msg=Details Updated Successfully..");
		} else {
			response.sendRedirect("adminloggedin.jsp?msg=Update Failed try later..");
		}
		
	}

}
