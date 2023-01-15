package com.recharge.customer.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.recharge.customer.entity.User;
import com.recharge.customer.payload.LoginDto;
import com.recharge.customer.payload.LoginResponseDto;
import com.recharge.customer.payload.UserDto;

@FeignClient(name = "LoginService", url = "http://localhost:8100")
public interface LoginClient {

	// For Login using feign client
	@PostMapping("api/user/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto);

	// For Register using feign client
	@PostMapping("api/user/register")
	public ResponseEntity<User> register(@RequestBody UserDto userDto);

}
