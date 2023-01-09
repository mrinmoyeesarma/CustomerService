package com.recharge.customer.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.recharge.customer.exception.ResourceNotFoundException;
import com.recharge.customer.entity.RechargePlan;
import com.recharge.customer.entity.Subscription;
import com.recharge.customer.repository.RechargePlanRepository;
import com.recharge.customer.repository.SubscriptionRepository;
import com.recharge.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	private RechargePlanRepository rechargePlanRepository;
	private SubscriptionRepository subscriptionRepository;

	public CustomerServiceImpl(RechargePlanRepository rechargePlanRepository,
			SubscriptionRepository subscriptionRepository) {
		this.rechargePlanRepository = rechargePlanRepository;
		this.subscriptionRepository = subscriptionRepository;
	}

	@Override
	public List<RechargePlan> getAvailablePlans() {
		List<RechargePlan> rechargePlans = rechargePlanRepository.findAll();
		List<RechargePlan> availablePlans = rechargePlans.stream().filter(plan -> plan.isAvailable())
				.collect(Collectors.toList());
		return availablePlans;
	}

	@Override
	public Subscription updateSubscriptionStatus(long id, String status) {
		Subscription sub = subscriptionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Subscription", "id", id));
		sub.setRechargeStatus(status);
		Subscription updatedSubscription = subscriptionRepository.save(sub);
		return updatedSubscription;

	}

	@Override
	public Subscription getAvailablePlansById(long id) {
		Subscription sub = subscriptionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Subscription", "id", id));
		return sub;
	}

	@Override
	public Subscription createRecharge(long planid, String username) {
		RechargePlan recharge = rechargePlanRepository.findById(planid)
				.orElseThrow(() -> new ResourceNotFoundException("RechargePlan", "id", planid));
		Subscription sub = new Subscription();
		sub.setPlanid(recharge.getPlan_id());
		sub.setRechargeStatus("Active");
		sub.setSubscriptiondate(new Date());
		sub.setUsername(username);
		sub.setValidity(recharge.getValidity());
		sub.setNetworkProvider(recharge.getNetworkProvider());
		Subscription createdsub = subscriptionRepository.save(sub);
		return createdsub;
	}

}
