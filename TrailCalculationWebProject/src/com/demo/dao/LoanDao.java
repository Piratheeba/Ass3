package com.demo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.demo.domain.Loan;
import com.demo.domain.User;
import com.demo.domain.UserCrential;

public interface LoanDao {
	
	Loan insertLoan(Connection conn, Loan loan) throws SQLException;
	Loan retriveLoan(Connection conn, String NIC_No) throws SQLException;
	List<Loan> retriveLoan(Connection conn) throws SQLException;

	 

}
