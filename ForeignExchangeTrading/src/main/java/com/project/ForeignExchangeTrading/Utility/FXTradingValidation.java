package com.project.ForeignExchangeTrading.Utility;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.project.ForeignExchangeTrading.model.FXTradingEntity;

public class FXTradingValidation {

	public static Map<String, String> isValid(FXTradingEntity Fxtrade) {

		Map<String, String> res = new HashMap<>();

		try {
			// Handle the case where Trade is NULL
			if (Fxtrade == null) {
				return Collections.singletonMap("Error", "Trade is NUll");
			}

			// Validation check for customer name
			if (Fxtrade.getCustomerName().isEmpty() || Fxtrade.getCustomerName() == null) {
				res.put("Customer_Name", "Customer Name can't be empty");
			} else {
				for (char c : Fxtrade.getCustomerName().toCharArray()) {
					if (!Character.isLetter(c) && c != ' ') {
						res.put("Customer_Name", "Customer Name can't be other than characters");
					}
				}
			}

			// Validation check for currency pair
			if (Fxtrade.getCurrencyPair().isEmpty()) {
				res.put("Currency_Pair", "Currency pair can't be empty");
			} else if (!Fxtrade.getCurrencyPair().equalsIgnoreCase("USDINR")) {
				res.put("Currency_Pair", "Currency pair can't be other than USDINR");
			}

			// Validation check for amount
			if (Fxtrade.getAmount() <= 0) {
				res.put("Amount", "Amount can't be less than or equals to Zero");
			} else {
				String amountInt = String.format("%.2f", Fxtrade.getAmount());
				if ((amountInt.trim()).matches("[0-9]+")) {
					res.put("Amount", "Amount can't be other than digits");
				}
			}
		}

		catch (Exception e) {
			return Collections.singletonMap("Error", "Kindly check request body");
		}

		return res;
	}
}
