package com.dao;
import java.sql.*;

import com.entities.User;

public class UserDao {

	private Connection con;
	
	public UserDao(Connection con)
	{
		this.con = con;
		
	}
	
	
	public boolean saveUser(User user)
	{
		boolean f = false;
		
		try {
			
			String INSERT_QUERY = "INSERT into user (name, email, password, about, gender) values (?,?,?,?,?)";	
			PreparedStatement pstm = this.con.prepareStatement(INSERT_QUERY);
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getEmail());
		 	pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getAbout());
			pstm.setString(5, user.getGender());			
			pstm.executeUpdate();
		  
			f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	
	
}
