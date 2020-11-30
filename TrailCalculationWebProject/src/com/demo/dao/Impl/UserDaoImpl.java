package com.demo.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.dao.UserDao;
import com.demo.domain.User;

public class UserDaoImpl implements UserDao {
	public static final String INSERT_SQL_QUERY = "INSERT INTO user(First_Name,Last_Name,Email,Date_Of_Birth,NIC_No,User_Type) VALUES(?,?,?,?,?)";
	public static final String UPDATE_SQL_QUERY = "UPDATE user SET First_Name=? WHERE ID=?";
	public static final String SELECT_SQL_QUERY = "SELECT ID,First_Name,Last_Name,Email,Date_Of_Birth,NIC_No,User_Type FROM user WHERE ID=?";
	public static final String SELECT_ALL_SQL_QUERY = "SELECT ID,First_Name,Last_Name,Email,Date_Of_Birth,NIC_No,User_Type FROM user";
	public static final String DELETE_SQL_QUERY = "DELETE FROM user WHERE ID=?";
	public static final String DELETE_ALL_SQL_QUERY = "DELETE FROM user";

	
	@Override
	public User insertUser(Connection conn,User user) throws SQLException {
		PreparedStatement ps = null;
		ps = conn.prepareStatement(INSERT_SQL_QUERY, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, user.getfName());
		ps.setString(2, user.getlName());
		ps.setString(3, user.getEmail());
		ps.setDate(4,  (java.sql.Date) new Date( user.getDob().getTime() )   );
		ps.setString(5,user.getNIC_No());
		ps.setString(6, user.getUserType());
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			user.setId(rs.getLong(1));
		}
		
		System.out.println("insertUser => " + ps.toString());
		
		return user ;
		
	}
	
	@Override
	public List<User> retriveUsers(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> Users = new ArrayList<User>();
	
		ps = conn.prepareStatement(SELECT_ALL_SQL_QUERY);
		rs = ps.executeQuery();
		System.out.println("retriveUsers => " + ps.toString());
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getLong("ID"));
			user.setfName(rs.getString("First_Name"));
			user.setlName(rs.getString("Last_Name"));
			user.setEmail(rs.getString("Email")); 
			user.setDob(rs.getDate("Date_Of_Birth"));
			user.setNIC_No(rs.getString("NIC_No"));
			user.setEmail(rs.getString("User_Type")); 
			Users.add(user);
		}

		return Users;
	}
	
	@Override
	public User retriveUser(Connection conn , long id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		User User = new User();
			ps = conn.prepareStatement(SELECT_SQL_QUERY);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			System.out.println("retriveUser => " + ps.toString());
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("ID"));
				user.setfName(rs.getString("First_Name"));
				user.setlName(rs.getString("Last_Name"));
				user.setEmail(rs.getString("Email")); 
				user.setDob(rs.getDate("Date_Of_Birth"));
				user.setNIC_No(rs.getString("NIC_No"));
				user.setEmail(rs.getString("User_Type")); 
			}
		return User;
	}

	@Override
	public void updateUserFirstName(Connection conn, User User) throws SQLException {
		// TODO Auto-generated method stub
		
	}	
	@Override
	public void deleteAllRecords(Connection conn) throws SQLException {
			
	}	
	@Override
	public void deleteUser(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
