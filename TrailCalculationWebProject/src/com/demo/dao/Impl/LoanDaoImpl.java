package com.demo.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.dao.LoanDao;
import com.demo.domain.Loan;
import com.demo.domain.User;

public class LoanDaoImpl implements LoanDao {
	private final String INSERT_SQL_QUERY = "INSERT INTO loan(Loan_amount,interest_rate,repayment_period,NIC_No) VALUES(?,?,?,?)";
	private final String SELECT_SQL_QUERY = "SELECT user.Full_Name, trialcalculation.Date, trialcalculation.Loan_amount, trialcalculation.interest_rate, trialcalculation.repayment_period, trialcalculation.rental_value FROM user, loan WHERE user.NICNO=loan.NICNO and user.NICNO=?;" ;
	LocalDate date = LocalDate.now();
	

	@Override
	public Loan insertLoan(Connection conn, Loan loan) throws SQLException {
		PreparedStatement ps =null;
		ps=conn.prepareStatement(INSERT_SQL_QUERY, Statement.RETURN_GENERATED_KEYS);
		ps.setDouble(1, loan.getLoan_amount());
		ps.setDouble(2, loan.getInterest_rate());
		ps.setInt(3, loan.getRepayment_period());
		ps.setString(4, loan.getDate());
		ps.setString(5, loan.getNIC_No());
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if(rs.next()) {
			loan.setLoan_id(rs.getLong(1));
		}
		System.out.println("insertLoan => " + ps.toString());
		return loan;		
	}

	@Override
	public Loan retriveLoan(Connection conn, String NIC_No) throws SQLException {
		
		return null;
	}

	@Override
	public List<Loan> retriveLoan(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Loan> details = new ArrayList<Loan>();
		
		ps = conn.prepareStatement(SELECT_SQL_QUERY);
		rs=ps.executeQuery();
		System.out.println("retriveLoan => " + ps.toString());
		while(rs.next()) {
			Loan loan = new Loan();
			loan.setLoan_id(rs.getLong("Loan_id"));
			loan.setLoan_amount(rs.getDouble("Loan_amount"));
			loan.setInterest_rate(rs.getDouble("interest_rate"));
			loan.setRepayment_period(rs.getInt("repayment_period"));
			loan.setRental_value(rs.getDouble("Rental_value"));
			loan.setNIC_No(rs.getString("NIC_No"));
			loan.setDate(date.toString());			
		}
		return details;


	}

}
