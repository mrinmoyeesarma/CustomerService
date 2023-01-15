package com.recharge.customer.payload;

import lombok.Data;

@Data
public class UserDto {
	private String name;
	private String username;
	private String password;
	private boolean isAdmin;

	public UserDto() {

	}

	public UserDto(String name, String username, String password, boolean isAdmin) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
