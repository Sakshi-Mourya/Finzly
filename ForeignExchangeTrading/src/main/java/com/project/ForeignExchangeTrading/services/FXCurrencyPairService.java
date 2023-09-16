package com.project.ForeignExchangeTrading.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ForeignExchangeTrading.dao.FXCurrencyPairDao;
import com.project.ForeignExchangeTrading.exception.CustomException;
import com.project.ForeignExchangeTrading.model.FXCurrencyPair;
import com.project.ForeignExchangeTrading.model.FXTradingEntity;

@Service
public class FXCurrencyPairService {

	@Autowired
	private FXCurrencyPairDao currencypairdao;

	/**
	 * Method to add a currency pair.
	 */
	public String addCurrencyPair(FXCurrencyPair fxcurrencypair) {

		List<FXCurrencyPair> currencyPairs = currencypairdao.getAllCurrencyPair();

		for (FXCurrencyPair pair : currencyPairs) {

			if (pair.getCurrencyPair().equalsIgnoreCase(fxcurrencypair.getCurrencyPair())) {
				CustomException.CurrencyPairAlreadyExist();
			}
		}
		return currencypairdao.addCurrencyPair(fxcurrencypair);
	}
	
	/**
	 * Method to get all currency pair.
	 */

	public List<FXCurrencyPair> getAllCurrencyPair() {

		if (currencypairdao.getAllCurrencyPair().isEmpty()) {
			CustomException.CurrencyPairListEmptyException();
		}
		return currencypairdao.getAllCurrencyPair();
	}

	/**
	 * Method to update a currency pair.
	 */

	public String updateCurrencyPair(String Ccy) {

		String[] arr = Ccy.split("=");
		String currencyPair = arr[0];
		String rate = arr[1];

		double convertedRate = Double.parseDouble(rate);
		if (convertedRate <= 0) {
			return "Rate must be positive";
		}
		return currencypairdao.updateCurrencyPair(convertedRate, currencyPair);
	}

}
