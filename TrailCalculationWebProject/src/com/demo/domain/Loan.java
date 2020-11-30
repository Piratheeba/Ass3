package com.demo.domain;

public class Loan {
	private long Loan_id;
	private String Date;
	private double Loan_amount;
	private double interest_rate;
	private int repayment_period;
	private double Rental_value;
	private String NIC_No;
		
	
	public Loan() {
		super();
	}
	
	public Loan(int loan_id, String date, double loan_amount, double interest_rate, int repayment_period,
			double rental_value, String nIC_No) {
		super();
		Loan_id = loan_id;
		Date = date;
		Loan_amount = loan_amount;
		this.interest_rate = interest_rate;
		this.repayment_period = repayment_period;
		Rental_value = rental_value;
		NIC_No = nIC_No;
	}

	public long getLoan_id() {
		return Loan_id;
	}
	public void setLoan_id(long l) {
		Loan_id = l;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public double getLoan_amount() {
		return Loan_amount;
	}
	public void setLoan_amount(double loan_amount) {
		Loan_amount = loan_amount;
	}
	public double getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	public int getRepayment_period() {
		return repayment_period;
	}
	public void setRepayment_period(int d) {
		this.repayment_period = d;
	}
	public double getRental_value() {
		return Rental_value;
	}
	public void setRental_value(double rental_value) {
		Rental_value = rental_value;
	}
	public String getNIC_No() {
		return NIC_No;
	}
	public void setNIC_No(String nIC_No) {
		NIC_No = nIC_No;
	}
	

}
