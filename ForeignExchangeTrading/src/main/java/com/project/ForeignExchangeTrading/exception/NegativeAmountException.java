package com.project.ForeignExchangeTrading.exception;

public class NegativeAmountException extends RuntimeException {
	
	public NegativeAmountException(){
		super("Amount cannot be negative, It should be greater than zero.");
	}
}
