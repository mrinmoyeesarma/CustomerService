package com.recharge.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recharge.customer.entity.RechargePlan;



public interface RechargePlanRepository extends JpaRepository<RechargePlan, Long> {

}
