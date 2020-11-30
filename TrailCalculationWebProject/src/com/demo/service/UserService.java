package com.demo.service;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import com.demo.domain.User;
import com.demo.exceptions.DemoExceptions;


public interface UserService {	
	void insertUser(User p) ;
	List<User> retriveUsers() ;
	User retriveUser(long id) ;
}
