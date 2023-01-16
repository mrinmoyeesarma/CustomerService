package com.recharge.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "recharge_plan", uniqueConstraints = { @UniqueConstraint(columnNames = { "plan_id" }) })
public class RechargePlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long plan_id;
	@Column(name = "networkProvider", nullable = false)
	private String networkProvider;
	@Column(name = "amount", nullable = false)
	private double amount;
	@Column(name = "planName", nullable = false)
	private String planName;
	@Column(name = "validity", nullable = false)
	private int validity;
	@Column(name = "isAvailable", nullable = false)
	private boolean isAvailable;

	public long getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(long plan_id) {
		this.plan_id = plan_id;
	}

	public String getNetworkProvider() {
		return networkProvider;
	}

	@Override
	public String toString() {
		return "RechargePlan [plan_id=" + plan_id + ", networkProvider=" + networkProvider + ", amount=" + amount
				+ ", planName=" + planName + ", validity=" + validity + ", isAvailable=" + isAvailable + "]";
	}

	public void setNetworkProvider(String networkProvider) {
		this.networkProvider = networkProvider;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
