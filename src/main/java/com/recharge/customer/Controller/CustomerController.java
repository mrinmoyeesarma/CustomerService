package com.recharge.customer.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recharge.customer.entity.RechargePlan;
import com.recharge.customer.entity.Subscription;
import com.recharge.customer.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	// get all the plans
	@GetMapping("/availablePlans")
	public ResponseEntity<List<RechargePlan>> getAllPlans() {
		List<RechargePlan> rlist = customerService.getAvailablePlans();
		return new ResponseEntity<>(rlist, HttpStatus.OK);

	}

	// get all plans by id
	@GetMapping("/{id}")
	public ResponseEntity<Subscription> getReachargeById(@PathVariable(name = "id") long id) {
		return new ResponseEntity<>(customerService.getAvailablePlansById(id), HttpStatus.OK);

	}

	// cancel i.e update the id
	@PutMapping("/{id}/{status}")
	public ResponseEntity<Subscription> updatePost(@PathVariable(name = "id") long id,
			@PathVariable(name = "status") String status) {
		Subscription sub = customerService.updateSubscriptionStatus(id, status);
		return new ResponseEntity<>(sub, HttpStatus.OK);
	}
}