package com.dugu.dev.ws.security.service;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dugu.dev.ws.security.dao.OrderDAO;
import com.dugu.dev.ws.security.util.OrderUtil;

import in.order.online.services.service.BusinessException;
import in.order.online.services.service.OnlineOrderService;
import in.order.online.services.types.Order;
import in.order.online.services.types.Recipt;

@WebService(serviceName = "OrderService", portName = "OrderServiceSOAPPort", targetNamespace = "http://online.order.in/services/service", endpointInterface = "in.order.online.services.service.OnlineOrderService", name = "OnlineOrderServiceImpl")
@Transactional
public class OnlineOrderServiceImpl implements OnlineOrderService {
	@Autowired(required = true)
	private OrderDAO dao;

	@Override
	public Recipt orderNow(Order orderRequest) throws BusinessException {
		Recipt recipt = null;
		recipt = dao.placeOrder(OrderUtil.pojoMapper(orderRequest));
		return recipt;
	}

}
