package com.demo.dao.Impl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.dao.UserAuthDao;
import com.demo.domain.User;
import com.demo.domain.UserCrential;

public class UserAuthDaoImpl implements UserAuthDao {
	private final String USER_CREDENTIALS_INSERT_SQL_QUERY = "INSERT INTO usercrential(User_Id,User_Name,Password) VALUES(?,?,?)"; 
	private final String USER_CREDENTIALS_SELECT_SQL = "SELECT UCID,User_Id,User_Name,Password FROM usercrential WHERE User_Name = ?" ;
	
	
	@Override
	public void insertUserCrential(Connection conn , UserCrential crential , long userId ) throws SQLException {
		PreparedStatement ps = null;
		ps = conn.prepareStatement(USER_CREDENTIALS_INSERT_SQL_QUERY);
		ps.setLong(1, userId);
		ps.setString(2, crential.getUserName());
		ps.setString(3, crential.getPassword());
		ps.execute();
		System.out.println("insertUser => " + ps.toString());
	}

	
	@Override
	public UserCrential getUserCrential(Connection conn , String userName) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
	
		ps = conn.prepareStatement(USER_CREDENTIALS_SELECT_SQL);
		ps.setString(1,userName);
		rs = ps.executeQuery();
		System.out.println("retriveUsers => " + ps.toString());
		
		UserCrential crential = null ;
		
		while (rs.next()) {
			crential = new UserCrential();
			crential.setCrentialId(rs.getLong("UCID") );
			crential.setUserId(rs.getLong("User_Id"));
			crential.setPassword(rs.getString("Password"));
			crential.setUserName(rs.getString("User_Name"));
		}

		return crential;
	}

}
