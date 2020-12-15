package com.example.demo.model;

import javax.validation.constraints.NotEmpty;

public class UserBean {
	@NotEmpty(message="Id must not be empty!")
	private String id;
	@NotEmpty(message="Name must not be empty!")
	private String name;
	@NotEmpty(message="Password must not be empty!")
	private String password;
	@NotEmpty(message="ConfirmPassword must not be empty!")
	private String confirm;
	
	public UserBean() {
		super();
	}
		
	public UserBean(@NotEmpty String id,@NotEmpty String name,@NotEmpty String password,@NotEmpty String confirm) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.confirm = confirm;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
}
