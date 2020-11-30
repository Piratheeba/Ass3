package com.demo.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.demo.domain.UserCrential;

public interface UserAuthDao {

	void insertUserCrential(Connection conn, UserCrential crential, long userId) throws SQLException;

	UserCrential getUserCrential(Connection conn, String userName) throws SQLException;


}
