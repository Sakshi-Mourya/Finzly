package com.project.ForeignExchangeTrading.utility;

import com.project.ForeignExchangeTrading.model.FXTradingEntity;

public class FXTradingValidation {

	public static String isValid(FXTradingEntity Fxtrade) {

		try {
			// Handle the case where Trade is NULL
			if (Fxtrade == null) {
				return "Trade is NUll";
			}

			// Validation check for customer name
			if (Fxtrade.getCustomerName().isEmpty() || Fxtrade.getCustomerName() == null) {
				return "Customer Name can't be empty";
			} else {
				for (char c : Fxtrade.getCustomerName().toCharArray()) {
					if (!Character.isLetter(c) && c != ' ') {
						return "Customer Name can't be other than characters";
					}
				}
			}

			// Validation check for currency pair
			if (Fxtrade.getCurrencyPair().isEmpty()) {
				return "Currency pair can't be empty";
			}

			// Validation check for amount
			if (Fxtrade.getAmount() <= 0) {
				return "Amount can't be less than or equals to Zero";
			} else {
				String amountInt = String.format("%.2f", Fxtrade.getAmount());
				if ((amountInt.trim()).matches("[0-9]+")) {
					return "Amount can't be other than digits";
				}
			}
		}

		catch (Exception e) {
			return "Kindly check request body";
		}

		return "Invalid Input";
	}
}
