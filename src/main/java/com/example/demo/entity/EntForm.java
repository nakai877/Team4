package com.example.demo.entity;

import java.sql.Date;

public class EntForm {
	private int id;
	private String name;
	private String list;
	
	private Date date;

	public EntForm() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getList() {
		return list;
	}
	
	public void setList(String list) {
		this.list = list;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}