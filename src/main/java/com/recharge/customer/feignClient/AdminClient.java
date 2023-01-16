package com.recharge.customer.feignClient;

import com.recharge.customer.entity.RechargePlan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name="AdminService" ,url ="http://localhost:8006")
public interface AdminClient {
// By using feign client get all services from admin microservice .
	@GetMapping("api/posts")
	public ResponseEntity<List<RechargePlan>> getAllPlans() ;
}
