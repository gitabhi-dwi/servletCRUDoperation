package com.servlet_session_management.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/loginUser")
public class UserLoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession  httpSession = req.getSession();
		
		
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(userName.equals("Abhishek")&&password.equals("1234abhi")) {
			    
			httpSession.setAttribute("user", userName);
			
			httpSession.setMaxInactiveInterval(30);
			
			req.getRequestDispatcher("Home.jsp").forward(req, resp);
			
		}else {
			req.setAttribute("msg", "username or password is incorrect "+userName);
			
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}
}
