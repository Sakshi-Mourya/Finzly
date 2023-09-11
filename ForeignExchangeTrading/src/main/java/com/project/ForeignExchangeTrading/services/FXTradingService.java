package com.project.ForeignExchangeTrading.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.project.ForeignExchangeTrading.Utility.FXTradingValidation;
import com.project.ForeignExchangeTrading.model.FXTradingEntity;
import org.springframework.stereotype.Service;

@Service
public class FXTradingService implements FXTradingInterface {

	// List to store trade objects
	private static List<FXTradingEntity> trades = new ArrayList<>();

	/**
	 * Method to book a new trade.
	 */

	@Override
	public Map<String, String> bookTrade(FXTradingEntity Fxtrade) {

		// Method to validate trade object fields
		Map<String, String> response = FXTradingValidation.isValid(Fxtrade);

		try {
			if ((response.isEmpty()) || response == null) {

				double amount = Fxtrade.getAmount();

				double finalAmount = amount * Fxtrade.getRate();

				Fxtrade.setAmount(finalAmount);

				Fxtrade.setCurrencyPair(Fxtrade.getCurrencyPair().toUpperCase());

				FXTradingEntity bookTrade = new FXTradingEntity(Fxtrade.getCustomerName(), Fxtrade.getCurrencyPair(),
						Fxtrade.getAmount());
				response.put("Message",
						"Trade for " + Fxtrade.getCurrencyPair() + " has been booked with rate " + Fxtrade.getRate()
								+ ". The amount of Rs " + Fxtrade.getAmount()
								+ " will be transferred in 2 working days to " + Fxtrade.getCustomerName());

				trades.add(bookTrade);
				return response;

			}
		} catch (Exception e) {
			// Handle unexpected exceptions and return an error response
			response.put("Message", "Trade not booked due to an unexpected error.");
			return response;
		}

		response.put("Message", "Trade not booked.");
		return response;
	}

	/**
	 * Method to get a list of trades
	 **/
	@Override
	public List<FXTradingEntity> getTradeList() {
		return trades;
	}
}
