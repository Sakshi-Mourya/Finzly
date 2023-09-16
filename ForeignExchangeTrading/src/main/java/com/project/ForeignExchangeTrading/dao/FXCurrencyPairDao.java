package com.project.ForeignExchangeTrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.ForeignExchangeTrading.model.FXCurrencyPair;
import com.project.ForeignExchangeTrading.model.FXTradingEntity;

@Repository
public class FXCurrencyPairDao {

	@Autowired
	SessionFactory sessionFactory;

	public String addCurrencyPair(FXCurrencyPair fxcurrencypair) {
		Session session = sessionFactory.openSession();
		session.save(fxcurrencypair);
		session.beginTransaction().commit();
		return "Currency Pair Added Successfully..";
	}

	public List<FXCurrencyPair> getAllCurrencyPair() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(FXCurrencyPair.class);
		return criteria.list();
	}

	public String updateCurrencyPair(double convertedRate, String currencyPair) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(FXCurrencyPair.class);
		criteria.add(Restrictions.eq("CurrencyPair", currencyPair));
		List<FXCurrencyPair> currencyPairs = criteria.list();

		if (!currencyPairs.isEmpty()) {
			FXCurrencyPair currencyPair1 = currencyPairs.get(0);
			currencyPair1.setCurrencyRate(convertedRate);
			session.update(currencyPair1);
			session.beginTransaction().commit();
			return "Currency pair exchange rate updated successfully";
		} else {
			return "Currency pair not found for update";
		}
	}

}
