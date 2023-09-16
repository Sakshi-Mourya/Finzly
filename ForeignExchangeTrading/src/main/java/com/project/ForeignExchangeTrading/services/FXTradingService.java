package com.project.ForeignExchangeTrading.services;

import java.util.List;

import com.project.ForeignExchangeTrading.dao.FXCurrencyPairDao;
import com.project.ForeignExchangeTrading.dao.FXTradingDao;
import com.project.ForeignExchangeTrading.exception.CustomException;
import com.project.ForeignExchangeTrading.model.FXCurrencyPair;
import com.project.ForeignExchangeTrading.model.FXTradingEntity;
import com.project.ForeignExchangeTrading.utility.FXTradingValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FXTradingService {

	@Autowired
	FXTradingDao FxTradeDao;

	@Autowired
	FXCurrencyPairDao currencypairdao;

	/**
	 * Method to book a new trade.
	 */

	public String bookTrade(FXTradingEntity Fxtrade) throws RuntimeException {

		List<FXCurrencyPair> currencypairlist = currencypairdao.getAllCurrencyPair();

		FXCurrencyPair currencypair = null;
		for (FXCurrencyPair pair : currencypairlist) {

			if (pair.getCurrencyPair().equalsIgnoreCase(Fxtrade.getCurrencyPair())) {
				currencypair = pair;
				break;
			}
		}

		if (currencypair == null) {
			CustomException.CurrencyPairNotFoundException();
		}

		if (Fxtrade.getAmount() <= 0) {
			CustomException.NegativeAmountException();
		}

		String response = FXTradingValidation.isValid(Fxtrade);
		try {
			if ((response.isEmpty()) || response == null) {

				double CurrencyRate = currencypair.getCurrencyRate();
				double Amount = Fxtrade.getAmount();

				double ConvertedAmount = Amount * CurrencyRate;
				Fxtrade.setAmount(ConvertedAmount);
				return FxTradeDao.bookTrade(Fxtrade);

			}

		} catch (Exception e) {
			// Handle unexpected exceptions and return an error message.
			return "Trade not booked due to an unexpected error.";
		}

		return "Trade not booked.";
	}

	/**
	 * Method to get a list of trades
	 **/
	public Object getAllTrades() {

		List<FXTradingEntity> tradelist = FxTradeDao.getAllTrades();

		if (tradelist.isEmpty()) {
			return "your trade list is Empty";
		} else {
			return tradelist;
		}
	}
}
