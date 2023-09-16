package com.project.ForeignExchangeTrading.exception;

public class CurrencyPairListEmptyException extends RuntimeException{
	
	public CurrencyPairListEmptyException() {
		super("The Currency Pair List is Empty !!");
	}
}
