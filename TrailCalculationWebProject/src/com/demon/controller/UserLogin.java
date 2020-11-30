package com.demon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.domain.UserCrential;
import com.demo.service.UserAuthService;
import com.demo.service.Impl.UserAuthServiceImpl;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserAuthService authService ;
		
	@Override
	public void init() throws ServletException {
		super.init();
		authService = new UserAuthServiceImpl();
	}

	public UserAuthService getAuthService() {
		return authService;
	}

	public void setAuthService(UserAuthService authService) {
		this.authService = authService;
	}
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			super.service(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login Servlet");
		
		String error = null ;	
		
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		
		if(userName != null  && password != null) {
			
			UserCrential crential = new UserCrential(userName, password);
			
			
			if(authService.userAuthentication(crential) ) {
				
				System.out.println(crential);
				
				HttpSession  session = request.getSession();
				
				session.setAttribute("user_name", crential.getUserName() );
				
				response.sendRedirect("home");
				
				//request.getRequestDispatcher("/Home.jsp").forward(request, response);
				
			}else {
				error = "UserName or Password incorrect";
			}
		}else {
			error = "invalid UserName or Password";
		}
		
		if(error != null) {
			request.setAttribute("error", error);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
