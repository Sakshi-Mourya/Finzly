package com.project.ForeignExchangeTrading.exception;

public class CurrencyPairNotFoundException extends RuntimeException{
	

	public CurrencyPairNotFoundException() {
		super("This Currency Pair is Not Found !!");
	}
}

