package com.project.ForeignExchangeTrading.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.project.ForeignExchangeTrading.model.FXTradingEntity;
import org.springframework.stereotype.Service;

@Service
public class FXTradingService {
	
	private static List<FXTradingEntity> trades = new ArrayList<>();
	
	public Map<String,String> isValid(FXTradingEntity Fxtrade){
	
		Map<String,String> res = new LinkedHashMap<>();
		
		
		//Validation check for customer name 
		if(Fxtrade.getCustomerName().isEmpty()) {
            res.put("Customer_Name","Customer Name can't be empty");
		}
		else{
			for(char c : Fxtrade.getCustomerName().toCharArray()){
				if(!Character.isLetter(c) && c != ' '){
					res.put("Customer_Name","Customer Name can't be other than characters");
				}
			}
		}
        
		
		//Validation check for currency pair
	    if(Fxtrade.getCurrencyPair().isEmpty()) {
	            res.put("Currency_Pair","Currency pair can't be empty");
	    }
	    else if(!Fxtrade.getCurrencyPair().equalsIgnoreCase("USDINR")){
            res.put("Currency_Pair","Currency pair can't be other than USDINR");
	    }
	
	    
	    //Validation check for amount
	    if(Fxtrade.getAmount()<=0)
	            res.put("Amount","Amount can't be less than or equals to Zero");
	    else{
	    	String amountInt = String.format("%.2f", Fxtrade.getAmount());
	    	if((amountInt.trim()).matches("[0-9]+")){
	    		res.put("Amount","Amount can't be other than digits");
	    	}
	    }  
	    
	    return res;	
	}
	
	
	public Map<String,String> bookTrade(FXTradingEntity Fxtrade) {
		
		Map<String,String> response = new LinkedHashMap<>();
		
		//check all validation
		response = isValid(Fxtrade);

		//If all validation are not true than return a message 'Trade not booked'
        if(!(response.isEmpty())){

                response.put("Message","Trade not booked");
               
                return response;
        } 
        
        //If all Checks are true than go for booking the trade.
        if(response.isEmpty()){


            double amount = Fxtrade.getAmount();

            double finalAmount = amount*Fxtrade.getRate();
           

            Fxtrade.setAmount(finalAmount);
            
            Fxtrade.setCurrencyPair(Fxtrade.getCurrencyPair().toUpperCase());

            FXTradingEntity bookTrade = new FXTradingEntity(Fxtrade.getCustomerName(), Fxtrade.getCurrencyPair(), Fxtrade.getAmount());
            response.put("Message", "Trade for " + Fxtrade.getCurrencyPair() + " has been booked with rate " + Fxtrade.getRate() + ". The amount of Rs " + Fxtrade.getAmount() + " will be transferred in 2 working days to " + Fxtrade.getCustomerName());

            
            trades.add(bookTrade);
            return response;

        }
        
        response.put("Message","Trade not booked");
        return response; 
	}
	
	//print all trade list
	public List<FXTradingEntity> getTradeList()
	{
		return this.trades;
	}
}
