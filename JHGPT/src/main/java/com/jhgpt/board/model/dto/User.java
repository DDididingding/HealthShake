package com.jhgpt.board.model.dto;

public class User {
	private String user_id;
	private String name;
	private String password;
	private String email;
	private String role;
	public String getId() {
		return user_id;
	}
	public void setId(String id) {
		this.user_id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + user_id + ", name=" + name + ", password=" + password + ", email=" + email + ", role=" + role
				+ "]";
	}
	
	

}
