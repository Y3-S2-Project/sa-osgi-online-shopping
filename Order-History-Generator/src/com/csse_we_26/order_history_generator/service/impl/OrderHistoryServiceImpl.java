package com.csse_we_26.order_history_generator.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.csse_we_26.order_history_generator.service.OrderHistoryService;
import com.csse_we_26.order_history_generator.util.MongoDBUtil;
import com.csse_we_26.order_history_generatoy.dao.impl.OrderHistoryDAOImpl;
import com.mongodb.client.MongoDatabase;

import mongodb_service.OrderHistoryDTO;

public class OrderHistoryServiceImpl implements OrderHistoryService {

	private OrderHistoryDAOImpl orderHistoryDAOImpl = null;

	public OrderHistoryServiceImpl(MongoDatabase database) {
		System.out.println("check one");
		System.out.println(MongoDBUtil.getInstance().getDatabase());
//		orderHistoryDAOImpl = new OrderHistoryDAOImpl(MongoDBUtil.getInstance().getDatabase(), "orders");
		System.out.println("check two");
	}

	@Override
	public OrderHistoryDTO getOrderByOrderNumber(String orderNumber) {
		return orderHistoryDAOImpl.getOrderByOrderNumber(orderNumber);
	}

	@Override
	public List<OrderHistoryDTO> getAllOrders() {
		return orderHistoryDAOImpl.getAllOrders();
	}

	@Override
	public List<OrderHistoryDTO> getOrderHistoryByCustomerId(String customerId) {
		return orderHistoryDAOImpl.getOrderHistoryByCustomerId(customerId);
	}

	@Override
	public List<OrderHistoryDTO> getOrderHistoryByDate(LocalDateTime date) {
		return orderHistoryDAOImpl.getOrderHistoryByDate(date);
	}

	@Override
	public boolean createOrder(OrderHistoryDTO order) {
		return orderHistoryDAOImpl.createOrder(order);
	}

	@Override
	public boolean updateOrder(OrderHistoryDTO order) {
		return orderHistoryDAOImpl.updateOrder(order);
	}

	@Override
	public boolean removeOrderByOrderNumber(String orderNumber) {
		return orderHistoryDAOImpl.removeOrderByOrderNumber(orderNumber);
	}

}
