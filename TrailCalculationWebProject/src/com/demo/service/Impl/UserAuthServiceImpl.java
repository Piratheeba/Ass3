package com.demo.service.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import com.demo.connection.JDBCConnection;
import com.demo.dao.UserAuthDao;
import com.demo.dao.Impl.UserAuthDaoImpl;
import com.demo.domain.UserCrential;
import com.demo.service.UserAuthService;

public class UserAuthServiceImpl implements UserAuthService {
private UserAuthDao userAuthDao ;
	
	public UserAuthDao getUserAuthDao() {
		return userAuthDao;
	}

	public void setUserAuthDao(UserAuthDao userAuthDao) {
		this.userAuthDao = userAuthDao;
	}
	
	public UserAuthServiceImpl() {
		userAuthDao = new UserAuthDaoImpl() ;
	}
	
	
	@Override
	public void insertUserCredentials(UserCrential crential) {
		
	}	
	
	@Override
	public UserCrential getUserCrential(Connection conn,  UserCrential userAuth){
		
		Connection c = null;
		try {
			conn = JDBCConnection.getConnection();
			if (conn != null) {
				conn.setAutoCommit(false);
				UserCrential crential = getUserAuthDao().getUserCrential(conn , userAuth.getUserName());
				conn.commit();
				return crential ;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean userAuthentication(UserCrential userAuth) {
		UserCrential crential = getUserCrential(null, userAuth);
		if( crential != null && crential.getUserName().equals(userAuth.getUserName()) && crential.getPassword().equals(userAuth.getPassword()) ) {
			return true ;	
		}
		return false ;
	}

	@Override
	public UserCrential getUserCredentials(UserCrential userAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserCrential getUserCredentials(Connection c, UserCrential userAuth) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
