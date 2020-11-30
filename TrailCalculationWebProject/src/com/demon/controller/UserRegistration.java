package com.demon.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.domain.User;
import com.demo.domain.UserCrential;
import com.demo.exceptions.DemoExceptions;
import com.demo.service.UserService;
import com.demo.service.Impl.UserServiceImpl;


@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService service ;
	
    public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	@Override
	public void init() throws ServletException {
		super.init();
		service = new UserServiceImpl();
		
	} 
    
    public UserRegistration() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/registration.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = null ;
		
		User user = new User() ;
		UserCrential  crential = new UserCrential();
		
		if(request.getParameter("RegisterForm") != null) {
			if(request.getParameter("FName") != null || request.getParameter("FName") != "" ) {
				user.setfName(request.getParameter("FName"));
			} 
			
			if(request.getParameter("LName") != null || request.getParameter("LName") != "" ) {
				user.setlName(request.getParameter("LName"));
			} 
			
			if(request.getParameter("Email") != null || request.getParameter("Email") != "" ) {
				user.setEmail(request.getParameter("Email"));
			} 
			
			if(request.getParameter("BirthDay") != null || request.getParameter("BirthDay") != "" ) {
				
			    SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd"); 
			    try {
					user.setDob( df.parse(request.getParameter("BirthDay")) );	
				} catch (ParseException e) {
					e.printStackTrace();
				}  
					
			} 
			
			if(request.getParameter("UserName") != null || request.getParameter("UserName") != "" ) {
				crential.setUserName(request.getParameter("UserName"));
			} 
			
			if(request.getParameter("Password") != null || request.getParameter("Password") != "" ) {
				crential.setPassword(request.getParameter("Password"));
			}else {
				error = "Password must be filled out " ; 				
			} 
			
			user.setUserType("user");
			user.setUserCrential(crential);
			
			try {
				getService().insertUser( user );
			} catch (DemoExceptions e) {
				error = e.getMessage() ;
			}
			

			if(error != null) {
				///PrintWriter out = response.getWriter();
				//out.print(error); 
				request.setAttribute("error", error);
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
			}
			
		}
	}

}
