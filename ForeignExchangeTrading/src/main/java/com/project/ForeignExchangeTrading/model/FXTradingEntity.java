package com.project.ForeignExchangeTrading.model;

public class FXTradingEntity {

	// Instance Variable
	private static int tradeCount = 0;
	private int customerID;
	private String customerName;
	private String currencyPair;
	private double amount;
	private double rate = 66.00;

	// Default Constructor
	public FXTradingEntity() {

	}

	// Parameterized Constructor for creating a new trade
	public FXTradingEntity(String customerName, String currencyPair, double amount) {
		super();
		tradeCount++;
		this.customerID = tradeCount;
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.amount = amount;
	}

	// Getter-Setter Method for retrieving & updating field values
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

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	// to-String Method
	@Override
	public String toString() {
		return "FXTradingEntity [customerID=" + customerID + ", customerName=" + customerName + ", currencyPair="
				+ currencyPair + ", amount=" + amount + ", rate=" + rate + "]";
	}

}
