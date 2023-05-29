package com.example.demo.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Input2 {
	@Size(min=1, max=10, message="名前は1～10文字以内にしてください")
	private String name;
	
	@NotEmpty(message="コメントを入力してください。")
	private String comment;
	
	@NotEmpty(message="役職を入力してください。")
	private String yakusyoku;
	@NotEmpty(message="部署を入力してください。")
	private String busyo;
	@NotEmpty(message="趣味を入力してください。")
	private String syumi;
	public Input2() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getYakusyoku() {
		return yakusyoku;
	}
	public void setYakusyoku(String yakusyoku) {
		this.yakusyoku = yakusyoku;
	}
	public String getBusyo() {
		return busyo;
	}
	public void setBusyo(String busyo) {
		this.busyo = busyo;
		
	}public String getSyumi() {
		return syumi;
	}
	public void setSyumi(String syumi) {
		this.syumi = syumi;
	}

}
