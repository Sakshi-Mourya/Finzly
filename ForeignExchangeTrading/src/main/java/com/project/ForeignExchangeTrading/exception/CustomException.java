package com.project.ForeignExchangeTrading.exception;

public class CustomException {

	public static void CurrencyPairNotFoundException() {
		throw new CurrencyPairNotFoundException();
	}
	
	public static void NegativeAmountException() {
		throw new NegativeAmountException();
	}
	
	public static void CurrencyPairListEmptyException() {
		throw new CurrencyPairListEmptyException();
	}
	
	public static void CurrencyPairAlreadyExist() {
		throw new CurrencyPairListEmptyException();
	}
}