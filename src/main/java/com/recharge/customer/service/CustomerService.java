package com.recharge.customer.service;

import com.recharge.customer.entity.RechargePlan;
import com.recharge.customer.entity.Subscription;

import java.util.List;

public interface CustomerService {
	List<RechargePlan> getAvailablePlans();

	Subscription getAvailablePlansById(long id);

	Subscription updateSubscriptionStatus(long id, String status);
	
	Subscription createRecharge(long planid,String username);
}
