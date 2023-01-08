package com.recharge.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recharge.customer.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
