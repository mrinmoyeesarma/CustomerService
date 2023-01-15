package com.recharge.customer.payload;

public class LoginDto {

	private String username;
	private String password;
	private boolean isAdmin;

	public LoginDto(String username, String password, boolean isAdmin) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public LoginDto() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "LoginDto [username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}

}
