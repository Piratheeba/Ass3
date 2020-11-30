package com.demo.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.demo.domain.UserCrential;

public interface UserAuthService {public void insertUserCredentials(UserCrential credentials); 
	UserCrential getUserCredentials(UserCrential userAuth);
	boolean userAuthentication(UserCrential userAuth);
	UserCrential getUserCredentials(Connection c, UserCrential userAuth) throws SQLException;
	UserCrential getUserCrential(Connection c, UserCrential userAuth);
	

}
