package com.dao;
import java.lang.invoke.StringConcatFactory;
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
	
	public User getUserByEmailAndPassword(String email, String password)
	{
		User user = null;
		
		try {
		String getUserDetailString = "SELECT * FROM user where email=? AND password=?";		
		PreparedStatement prstm = this.con.prepareStatement(getUserDetailString);
		prstm.setString(1, email);
		prstm.setString(2, password);
		
		ResultSet rs = prstm.executeQuery();
		System.out.println(rs);
		
		if(rs.next())
		{
			user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setAbout(rs.getString("about"));
			
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user; 
		
	} 
	
	
}
