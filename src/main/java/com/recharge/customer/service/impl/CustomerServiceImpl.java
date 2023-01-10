package com.recharge.customer.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recharge.customer.exception.ResourceNotFoundException;
import com.recharge.customer.feignClient.AdminClient;
import com.recharge.customer.entity.RechargePlan;
import com.recharge.customer.entity.Subscription;
import com.recharge.customer.repository.RechargePlanRepository;
import com.recharge.customer.repository.SubscriptionRepository;
import com.recharge.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private RechargePlanRepository rechargePlanRepository;
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	AdminClient client;

//	public CustomerServiceImpl(RechargePlanRepository rechargePlanRepository,
//			SubscriptionRepository subscriptionRepository) {
//		this.rechargePlanRepository = rechargePlanRepository;
//		this.subscriptionRepository = subscriptionRepository;
//	}

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

	// Perform Recharge Succesfully
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

// ReachrgePlan get from admin table of planid and save it in customer.
	public void gplans(int planid, String userName) {
		RechargePlan recharge = (client.getAllPlans().getBody().stream().filter((n) -> n.getPlan_id() == planid)
				.findAny().get());

		Subscription sub = new Subscription();
		sub.setPlanid(planid);
		sub.setRechargeStatus("Active");
		sub.setSubscriptiondate(new Date());
		sub.setUsername(userName);
		sub.setValidity(planid);
		sub.setNetworkProvider(userName);
		Subscription createdsub = subscriptionRepository.save(sub);
	}
}
