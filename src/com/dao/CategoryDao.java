package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.entities.Category;

public class CategoryDao {

	private Connection con;
	
	public CategoryDao(Connection con) {
		this.con = con;
	}
	
	public boolean saveData(Category category)
	{
		boolean f= false;
		
		try {
			String insertQuery = "INSERT INTO category(name, description)VALUES(?,?)";
			
			PreparedStatement prs = this.con.prepareStatement(insertQuery);
			prs.setString(1, category.getName());
			prs.setString(2, category.getDescription());
			prs.executeUpdate();
			
			f= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	
	
	public ArrayList<Category> getCategories()
	{
		ArrayList<Category> list=new ArrayList<>();
		
		try {
			String getCategoryString = "SELECT * FROM category";
			Statement prstmt = this.con.createStatement();
			ResultSet rs = prstmt.executeQuery(getCategoryString);
			while(rs.next())
			{	
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description"); 
				Category category = new Category(id, name, description);
				list.add(category);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
