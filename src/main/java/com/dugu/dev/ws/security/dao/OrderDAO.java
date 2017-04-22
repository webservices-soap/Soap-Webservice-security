package com.dugu.dev.ws.security.dao;

import in.order.online.services.types.Recipt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dugu.dev.ws.security.model.OrderModel;
import com.dugu.dev.ws.security.util.OrderUtil;

@Repository
public class OrderDAO {
	@Autowired(required = true)
	private SessionFactory factory;

	private Session getSession() {
		Session session = null;
		if (factory.getCurrentSession() == null) {
			session = factory.openSession();
		} else {
			session = factory.getCurrentSession();
		}
		return session;
	}

	public Recipt placeOrder(OrderModel model) {
		getSession().save(model);
		if (model != null) {
			return OrderUtil.generateRecipt();
		} else {
			return null;
		}
	}
}
