package com.project.ForeignExchangeTrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ForeignExchangeTrading.model.FXTradingEntity;
import com.project.ForeignExchangeTrading.services.FXTradingService;

@RestController
@RequestMapping("/trade")
public class FXTradingController {

	/**
	 * Autowired the TradeService to handle trade-related operations
	 */
	@Autowired
	private FXTradingService FxTradeService;

	/**@author Sakshi Mourya
	 * POST endpoint to book a trade.
	 * 
	 * @param trade The trade details provided in the request body.
	 * 
	 * @return The result of the trade booking.
	 */

	@PostMapping("booktrade")
	public String bookTrade(@RequestBody FXTradingEntity Fxtrade) {

		try {
			FxTradeService.bookTrade(Fxtrade);
			return "Trade Booked Successfully";
		}
		catch (RuntimeException exception) {
			exception.printStackTrace();
			return exception.getMessage();
		}

	}

	/**@author Sakshi Mourya
	 * GET endpoint to retrieve a list of trades.
	 *
	 * @return All Trade details.
	 */

	@GetMapping("getalltrades")
	public Object getAllTrades() {
		return FxTradeService.getAllTrades();

	}

}
