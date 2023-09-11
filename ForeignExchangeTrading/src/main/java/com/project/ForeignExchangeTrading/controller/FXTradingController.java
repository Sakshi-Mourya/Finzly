package com.project.ForeignExchangeTrading.controller;

import java.util.List;
import java.util.Map;

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

	/**
	 * POST endpoint to book a trade.
	 * 
	 * @param trade The trade details provided in the request body.
	 * 
	 * @return The result of the trade booking.
	 */

	@PostMapping("booktrade")
	public Map<String, String> bookTrade(@RequestBody FXTradingEntity Fxtrade) {

		return FxTradeService.bookTrade(Fxtrade);
	}

	/**
	 * GET endpoint to retrieve a list of trades.
	 *
	 * @return the trade details or an error message.
	 */

	@GetMapping("getalltrades")
	public Object getAllTrades() {

		List<FXTradingEntity> tradeList = this.FxTradeService.getTradeList();

		if (tradeList.isEmpty()) {
			return "Your Trade List is Empty";
		} else {
			return tradeList;
		}
	}

}
