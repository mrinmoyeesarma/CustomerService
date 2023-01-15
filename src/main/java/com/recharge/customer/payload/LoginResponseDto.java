package com.recharge.customer.payload;

import lombok.Data;

@Data
public class LoginResponseDto {
	String loginMessage;
	boolean isAdmin;

	public LoginResponseDto() {
	}

	public LoginResponseDto(String loginMessage, boolean isAdmin) {
		super();
		this.loginMessage = loginMessage;
		this.isAdmin = isAdmin;
	}

	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
