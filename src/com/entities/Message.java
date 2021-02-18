package com.entities;

public class Message {
	private String data;
	private String type;
	private String className;
	
	public Message(String data, String type, String className) {
		super();
		this.data = data;
		this.type = type;
		this.className = className;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
	
}
