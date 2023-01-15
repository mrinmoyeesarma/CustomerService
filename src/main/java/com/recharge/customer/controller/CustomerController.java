package com.recharge.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recharge.customer.entity.RechargePlan;
import com.recharge.customer.entity.Subscription;
import com.recharge.customer.feignClient.AdminClient;
import com.recharge.customer.feignClient.LoginClient;
import com.recharge.customer.payload.LoginDto;
import com.recharge.customer.payload.UserDto;
import com.recharge.customer.service.impl.CustomerServiceImpl;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerService;

	@Autowired
	private AdminClient adminClient;

	@Autowired
	private LoginClient loginCLient;

//	public CustomerController(CustomerService customerService) {
//		this.customerService = customerService;
//	}

	// get all the plans
	@GetMapping("/availablePlans")
	public ResponseEntity<List<RechargePlan>> getAllPlans() {
		List<RechargePlan> rlist = customerService.getAvailablePlans();
		return new ResponseEntity<>(rlist, HttpStatus.OK);

	}

	// View the recharge made using rechargeId display detailed plan information
	// along with
	// recharge status
	@GetMapping("/{id}")
	public ResponseEntity<Subscription> getRechargeById(@PathVariable(name = "id") long id) {
		return new ResponseEntity<>(customerService.getAvailablePlansById(id), HttpStatus.OK);

	}

	// cancel recharge using recharge id i.e update the id
	@PutMapping("/{id}/{status}")
	public ResponseEntity<Subscription> updatePost(@PathVariable(name = "id") long id,
			@PathVariable(name = "status") String status) {
		Subscription sub = customerService.updateSubscriptionStatus(id, status);
		return new ResponseEntity<>(sub, HttpStatus.OK);
	}

	// Perform recharge successfully by using plan id and username
	@PostMapping("/recharge/{planId}/{username}")
	public ResponseEntity<Subscription> createRecharge(@PathVariable(name = "planId") int planId,
			@PathVariable(name = "username") String username) {
		Subscription sub = customerService.createRecharge(planId, username);
		return new ResponseEntity<>(sub, HttpStatus.OK);
	}

// By using Feign Client
	@GetMapping("/showplans")
	public ResponseEntity<List<RechargePlan>> showAllplans() {
		return adminClient.getAllPlans();
	}

	@PostMapping("/customer-login")
	public ResponseEntity login(@RequestBody LoginDto loginDto) {
		return loginCLient.login(loginDto);
	}

	@PostMapping("/customer-register")
	public ResponseEntity register(@RequestBody UserDto userDto) {
		userDto.setAdmin(false);
		return loginCLient.register(userDto);
	}

}