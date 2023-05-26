package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Input {
	@Size(min=1, max=20, message="1～20文字以内にしてください")
	private String name;
	
	//@Size(min=1, max=200, message="文字を入力してください")
	@NotBlank(message="文字を入力してください")
	private String list;
		
	public Input() {
	}

	public String getName() {
		return name;
	}

	public String getList() {
		return list;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setList(String list) {
		this.list = list;
	}
}