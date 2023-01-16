package com.recharge.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "subscription", uniqueConstraints = { @UniqueConstraint(columnNames = { "recharge_id" }) })
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long recharge_id;
	@Column(name = "planid", nullable = false)
	private long planid;
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "subscriptiondate", nullable = false)
	private Date subscriptiondate;
	@Column(name = "validity", nullable = false)
	private int validity;
	@Column(name = "rechargeStatus", nullable = false)
	private String rechargeStatus;
	@Column(name = "networkProvider", nullable = false)
	private String networkProvider;

	public long getRecharge_id() {
		return recharge_id;
	}

	public void setRecharge_id(long recharge_id) {
		this.recharge_id = recharge_id;
	}

	public long getPlanid() {
		return planid;
	}

	public void setPlanid(long planid) {
		this.planid = planid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getSubscriptiondate() {
		return subscriptiondate;
	}

	public void setSubscriptiondate(Date subscriptiondate) {
		this.subscriptiondate = subscriptiondate;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public String getRechargeStatus() {
		return rechargeStatus;
	}

	public void setRechargeStatus(String rechargeStatus) {
		this.rechargeStatus = rechargeStatus;
	}

	public String getNetworkProvider() {
		return networkProvider;
	}

	public void setNetworkProvider(String networkProvider) {
		this.networkProvider = networkProvider;
	}

}
