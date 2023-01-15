package com.recharge.customer.service.impl;

import com.recharge.customer.entity.RechargePlan;
import com.recharge.customer.entity.Subscription;
import com.recharge.customer.feignClient.AdminClient;
import com.recharge.customer.repository.RechargePlanRepository;
import com.recharge.customer.repository.SubscriptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceImplTest {
    private AdminClient adminClient;
    private CustomerServiceImpl customerService;
    private RechargePlanRepository rechargePlanRepository;
    private SubscriptionRepository subscriptionRepository;

    @BeforeEach
    void setup() {
        // Initialize
        customerService = new CustomerServiceImpl();

        // Mockito
        adminClient = Mockito.mock(AdminClient.class);
        rechargePlanRepository = Mockito.mock(RechargePlanRepository.class);
        subscriptionRepository = Mockito.mock(SubscriptionRepository.class);

        // Reflection Test Utils
        ReflectionTestUtils.setField(customerService, "rechargePlanRepository", rechargePlanRepository);
        ReflectionTestUtils.setField(customerService, "subscriptionRepository", subscriptionRepository);
    }

    @Test
    void testGetAvailablePlans() {
        // Fake Data
        RechargePlan rechargePlan = new RechargePlan();
        rechargePlan.setPlan_id(1);
        rechargePlan.setNetworkProvider("Hello");
        rechargePlan.setAmount(120);
        rechargePlan.setValidity(90);
        rechargePlan.setAvailable(true);

        List<RechargePlan> data = new ArrayList<>();
        data.add(rechargePlan);

        // Mockito
        Mockito.when(rechargePlanRepository.findAll()).thenReturn(data);

        // Testing
        List<RechargePlan> plans = customerService.getAvailablePlans();

        // Assertions
        assertEquals(plans, data);
    }

    @Test
    void testGetAvailablePlans2() {
        // Fake Data
        RechargePlan rechargePlan = new RechargePlan();
        rechargePlan.setPlan_id(1);
        rechargePlan.setNetworkProvider("Hello");
        rechargePlan.setAmount(120);
        rechargePlan.setValidity(90);
        rechargePlan.setAvailable(true);
        RechargePlan rechargePlan1 = new RechargePlan();
        rechargePlan1.setPlan_id(2);
        rechargePlan1.setNetworkProvider("Hi");
        rechargePlan1.setAmount(120);
        rechargePlan1.setValidity(90);
        rechargePlan1.setAvailable(false);

        List<RechargePlan> data = new ArrayList<>();
        data.add(rechargePlan);
        data.add(rechargePlan1);

        // Mockito
        Mockito.when(rechargePlanRepository.findAll()).thenReturn(data);

        // Testing
        List<RechargePlan> plans = customerService.getAvailablePlans();

        // Assertions checking 
        assertEquals(1, plans.size());
    }

    @Test
    void testUpdateSubscriptionStatus() {
        Subscription subscription = new Subscription();
        subscription.setRecharge_id(1);

        Mockito.when(subscriptionRepository.findById(Mockito.any())).thenReturn(Optional.of(subscription));
        Mockito.when(subscriptionRepository.save(Mockito.any())).thenReturn(subscription);

        Subscription sub = customerService.updateSubscriptionStatus(1, "Cancel");
        assertEquals(sub, subscription);
    }

    @Test
    void testGetAvailablePlansById() {
        Subscription subscription = new Subscription();
        subscription.setRecharge_id(1);

        Mockito.when(subscriptionRepository.findById(Mockito.any())).thenReturn(Optional.of(subscription));

        Subscription sub = customerService.getAvailablePlansById(1);
        assertEquals(sub, subscription);
    }

    @Test
    void testCreateRecharge() {
        RechargePlan rechargePlan = new RechargePlan();
        rechargePlan.setPlan_id(1);
        rechargePlan.setNetworkProvider("Hello");
        rechargePlan.setAmount(120);
        rechargePlan.setValidity(90);
        rechargePlan.setAvailable(true);
        Mockito.when(rechargePlanRepository.findById(Mockito.any())).thenReturn(Optional.of(rechargePlan));

        Subscription subscription = new Subscription();
        subscription.setRecharge_id(1);
        Mockito.when(subscriptionRepository.save(Mockito.any())).thenReturn(subscription);

        Subscription sub = customerService.createRecharge(1, "Hello");
        assertEquals(sub, subscription);
    }
}
