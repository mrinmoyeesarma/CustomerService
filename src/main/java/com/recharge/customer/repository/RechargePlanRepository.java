package com.recharge.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recharge.customer.entity.RechargePlan;

@Repository
public interface RechargePlanRepository extends JpaRepository<RechargePlan, Long> {

}
