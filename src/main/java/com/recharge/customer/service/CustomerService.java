package com.recharge.customer.service;

import java.util.List;

import com.recharge.customer.entity.RechargePlan;
import com.recharge.customer.entity.Subscription;

public interface CustomerService {
	List<RechargePlan> getAvailablePlans();

	Subscription getAvailablePlansById(long id);

	Subscription updateSubscriptionStatus(long id, String status);
}
