package com.project.ForeignExchangeTrading.services;

import java.util.List;
import java.util.Map;

import com.project.ForeignExchangeTrading.model.FXTradingEntity;

public interface FXTradingInterface {

	public Map<String, String> bookTrade(FXTradingEntity Fxtrade);

	public List<FXTradingEntity> getTradeList();

}
