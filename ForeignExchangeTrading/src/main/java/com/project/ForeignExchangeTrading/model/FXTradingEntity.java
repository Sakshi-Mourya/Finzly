package com.project.ForeignExchangeTrading.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FXTradingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerID;
	private String customerName;
	private String currencyPair;
	private double amount;

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "FXTradingEntity [customerID=" + customerID + ", customerName=" + customerName + ", currencyPair="
				+ currencyPair + ", amount=" + amount + "]";
	}

}
