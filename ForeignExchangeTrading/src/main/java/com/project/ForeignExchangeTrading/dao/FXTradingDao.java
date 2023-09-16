package com.project.ForeignExchangeTrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.ForeignExchangeTrading.model.FXTradingEntity;

@Repository
public class FXTradingDao {

	@Autowired
	SessionFactory sessionFactory;

	public String bookTrade(FXTradingEntity fxtrade) {
		Session session = sessionFactory.openSession();
		session.save(fxtrade);
		session.beginTransaction().commit();
		return "success";
	}

	public List<FXTradingEntity> getAllTrades() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(FXTradingEntity.class);
		return criteria.list();
	}
}
