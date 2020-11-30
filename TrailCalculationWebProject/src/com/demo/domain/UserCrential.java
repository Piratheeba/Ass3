package com.demo.domain;

public class UserCrential {
	private long  	crentialId ;
	private long   	userId ;
	private String 	userName ;
	private String 	password ;
	
	public UserCrential() {
		super();
	}

	public UserCrential(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserCrential [userName=" + userName + ", password=" + password + "]";
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCrentialId() {
		return crentialId;
	}

	public void setCrentialId(long crentialId) {
		this.crentialId = crentialId;
	}

}
