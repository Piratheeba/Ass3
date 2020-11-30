package com.demon.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.domain.Loan;
import com.demo.domain.User;
import com.demo.exceptions.DemoExceptions;

/**
 * Servlet implementation class Trailcalculation
 */
@WebServlet("/Trailcalculation")
public class Trailcalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Trailcalculation() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/trailcalculation.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String error = null ;
		
		Loan loan = new Loan() ;
		User user = new User() ;

		
		if(request.getParameter("calculationform") != null) {
			if(request.getParameter("lAmount") != null || request.getParameter("lAmount") != "" ) {
				loan.setLoan_amount(Double.parseDouble(request.getParameter("lAmount")));
			} 
			
			if(request.getParameter("iRate") != null || request.getParameter("iRate") != "" ) {
				loan.setInterest_rate(Double.parseDouble(request.getParameter("iRate")));
			} 
			
			if(request.getParameter("rpayment") != null || request.getParameter("rpayment") != "" ) {
				loan.setRepayment_period(Integer.parseInt(request.getParameter("rpayment")));
			} 
			
					
			if(request.getParameter("nicno") != null || request.getParameter("nicno") != "" ) {
				loan.setNIC_No(request.getParameter("nicno"));
			} 		
			
			/*if(error != null) {
				request.setAttribute("error", error);
				request.getRequestDispatcher("/trailcalculation.jsp").forward(request, response);
			}*/
			
			
			
			
		}
		 
	}

}
