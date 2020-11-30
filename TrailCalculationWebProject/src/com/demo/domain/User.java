package com.demo.domain;

import java.util.Date;

public class User {
	private long  id;
	private String fName ;
	private String lName ;
	private String email ;
	private Date dob;
	private String NIC_No;
	private String userType ;
	
	private UserCrential userCrential;
	private Loan loan;
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getNIC_No() {
		return NIC_No;
	}
	public void setNIC_No(String nIC_No) {
		NIC_No = nIC_No;
	}	
	public UserCrential getUserCrential() {
		return getUserCrential();
	}
	public void setUserCrential(UserCrential userCrential) {
		this.userCrential = userCrential;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

}
