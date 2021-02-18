package com.dao;

import java.sql.*;

import com.entities.Post;

public class PostDao {

private Connection con;
	
	public PostDao(Connection con)
	{
		this.con = con;
		
	}
	
	public boolean savePost(Post post)
	{
		boolean status =false;
		
		try {
			
			String insertPoString = "INSERT INTO post(title, content, code, cat_id, user_id, pic) values (?,?,?,?,?,?)";
			
			PreparedStatement prstm = this.con.prepareStatement(insertPoString);
			prstm.setString(1, post.getTitle());
			prstm.setString(2, post.getContent());
			prstm.setString(3, post.getCode());
			prstm.setInt(4, post.getCat_id());
			prstm.setInt(5, post.getUser_id());
			prstm.setString(6, post.getPic());
			prstm.executeUpdate();
			
			status = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
}
