package com.project.ForeignExchangeTrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ForeignExchangeTrading.model.FXCurrencyPair;
import com.project.ForeignExchangeTrading.services.FXCurrencyPairService;

@RestController
public class FXCurrencyPairController {

	@Autowired
	private FXCurrencyPairService currencypairservice;

	/**@author Sakshi Mourya
	 * POST endpoint to add a currency pair.
	 * 
	 * @param trade The currency details provided in the request body.
	 * 
	 * @return The result of the adding currency pair.
	 */

	@PostMapping("addCurrencyPair")
	public String addCurrencyPair(@RequestBody FXCurrencyPair fxcurrencypair) {
		try {
			currencypairservice.addCurrencyPair(fxcurrencypair);
			return "Currency Pair Added Succesfully";

		} catch (RuntimeException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	/**@author Sakshi Mourya
	 * GET endpoint to retrieve a list of currency pair.
	 *
	 * @return All list of Currency pair.
	 */

	@GetMapping("getAllCurrencyPair")
	public List<FXCurrencyPair> getAllCurrencyPair() {
		return currencypairservice.getAllCurrencyPair();
	}

	/**@author Sakshi Mourya
	 * POST endpoint to update a currency pair.
	 * 
	 * @param The currency details provided in the request body.
	 * 
	 * @return The result of the updating currency pair.
	 */

	@PutMapping("updateCurrencyPair/{CurrencyPair}")
	public String updateCurrencyPair(@PathVariable String Ccy) {
		currencypairservice.updateCurrencyPair(Ccy);
		return "Currency Pair Updated Succesfully";
	}

}
