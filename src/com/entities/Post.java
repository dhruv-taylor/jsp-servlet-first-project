package com.entities;

import java.sql.*;

public class Post {
	private int id;
	private String title;
	private String content;
	private String code;
	private Timestamp created_date;
	private int cat_id;
	private int user_id;
	private String pic;
	
	public Post() {
		super();
	}

	public Post(int id, String title, String content, String code, Timestamp created_date, int cat_id) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.code = code;
		this.created_date = created_date;
		this.cat_id = cat_id;
	}

	public Post(String title, String content, String code, Timestamp created_date, int cat_id) {
		super();
		this.title = title;
		this.content = content;
		this.code = code;
		this.created_date = created_date;
		this.cat_id = cat_id;
	}	
	
	public Post(int id, String title, String content, String code, Timestamp created_date, int cat_id, int user_id, String pic) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.code = code;
		this.created_date = created_date;
		this.cat_id = cat_id;
		this.user_id = user_id;
		this.pic = pic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
}
