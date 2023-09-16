package com.project.ForeignExchangeTrading.exception;

public class CurrencyPairAlreadyExist extends RuntimeException {

	public CurrencyPairAlreadyExist() {
		super("The Currency Pair Already Exists in the list!!");
	}
}
