package com.crudo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.Email;

import com.crudo.bo.User;
import com.crudo.dao.UserDao;
import com.crudo.factory.DaoFactory;

public class SendOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		String email = request.getParameter("email");
		
		UserDao userDao = DaoFactory.getUserDao();
		User user = null;
		String sql = "select * from users where email='"+email+"'";
			user = userDao.getUser(sql);
			
		if(user!=null) {
			String otp = genrateOtp();
			session.setAttribute("genratedOtp", otp);
			session.setAttribute("setEmail", email);
			
			Email mail = new Email("academicaliv@gmail.com", "4xxxxxxx0");
			mail.setRecipient(email);
			mail.setSubject("Your Crudo OTP");
			mail.setMessage("Your Otp Is: "+otp);
			mail.sendMail();
		} else {
			response.sendRedirect("passwordrecovery.jsp?msg=E-mail Not Registered.");
		}
	
	}

	public String genrateOtp() {
		String otpstr=null;
		String base="ABCDEF01234GHIJKLPQRSTUVWXYZ56789";
		java.util.Random rand = new java.util.Random();
		String temp="";
		for(int i=1; i<=6; i++) {
			int index=rand.nextInt(base.length());
			temp=temp+base.charAt(index);
		}
		otpstr=temp;
		return otpstr;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String otpRecived = request.getParameter("otp");
		
		HttpSession httpSession = request.getSession(false);
		String genOtp = (String)httpSession.getAttribute("genratedOtp");
		
		if(genOtp.equals(otpRecived)) {
			request.setAttribute("smsg", "confirmed");
			RequestDispatcher rd = request.getRequestDispatcher("passwordrecovery.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("passwordrecovery.jsp?msg=Please Enter a valid OTP ! Try Again");
		}
		
	}

}
