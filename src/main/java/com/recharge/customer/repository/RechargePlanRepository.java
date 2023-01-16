package com.recharge.customer.repository;

import com.recharge.customer.entity.RechargePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargePlanRepository extends JpaRepository<RechargePlan, Long> {

}
