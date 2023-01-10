package com.recharge.customer.service.impl;

import com.recharge.customer.entity.RechargePlan;
import com.recharge.customer.repository.RechargePlanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceImplTest {
    private CustomerServiceImpl customerService;
    private RechargePlanRepository rechargePlanRepository;

    @BeforeEach
    void setup() {
        // Initialize
        customerService = new CustomerServiceImpl();

        // Mockito
        rechargePlanRepository = Mockito.mock(RechargePlanRepository.class);

        // Reflection Test Utils
        ReflectionTestUtils.setField(customerService, "rechargePlanRepository", rechargePlanRepository);
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

        // Assertions
        assertEquals(1, plans.size());
    }
}
