package com.demo.service.Impl;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

import com.demo.connection.JDBCConnection;
import com.demo.dao.UserAuthDao;
import com.demo.dao.UserDao;
import com.demo.dao.Impl.UserAuthDaoImpl;
import com.demo.dao.Impl.UserDaoImpl;
import com.demo.domain.User;
import com.demo.domain.UserCrential;
import com.demo.exceptions.DemoExceptions;
import com.demo.exceptions.UserAlreadyExistsException;
import com.demo.service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao userDao ;
	UserAuthDao authDao ;
	
	public UserServiceImpl() {
		this.userDao = new UserDaoImpl();
		this.authDao = new UserAuthDaoImpl();
	}
	
	public UserAuthDao getAuthDao() {
		return authDao;
	}

	public void setAuthDao(UserAuthDao authDao) {
		this.authDao = authDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public void insertUser(User user)  {//throws DemoExceptions
		
		Connection conn = null;
		try {
			conn = JDBCConnection.getConnection();
			if (conn != null) {
				conn.setAutoCommit(false);
				
				UserCrential existsUser =  getAuthDao().getUserCrential(conn, user.getUserCrential().getUserName());
				
				if(existsUser != null ) {
					throw new UserAlreadyExistsException("User_Name" + user.getUserCrential().getUserName() +  " already exists");
				}
				
						
				
				getUserDao().insertUser(conn, user);
				if ( user.getId() > 0 ) {
					getAuthDao().insertUserCrential(conn, user.getUserCrential() , user.getId());
					conn.commit();
				}else {
					throw new SQLException();
				} 
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}	
	}	
	@Override
	public List<User> retriveUsers()  {
		return null;
	}

	@Override
	public User retriveUser( long id)  {
		return null;
	}

}
