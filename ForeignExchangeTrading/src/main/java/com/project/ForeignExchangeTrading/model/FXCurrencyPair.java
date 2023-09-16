package com.project.ForeignExchangeTrading.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FXCurrencyPair {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ccyId;
	private String currencyPair;
	private double currencyRate;

	public int getCcyId() {
		return ccyId;
	}

	public void setCcyId(int ccyId) {
		this.ccyId = ccyId;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(double currencyRate) {
		this.currencyRate = currencyRate;
	}

	@Override
	public String toString() {
		return "FXCurrencyPair [currencyPair=" + currencyPair + ", currencyRate=" + currencyRate + "]";
	}

}
