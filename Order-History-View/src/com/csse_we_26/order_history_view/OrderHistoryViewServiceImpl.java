package com.csse_we_26.order_history_view;

import java.util.List;


import com.csse_we_26.order_history_generator.Order;
import com.csse_we_26.order_history_generator.OrderHistoryGeneratorService;

public class OrderHistoryViewServiceImpl implements OrderHistoryViewService {

	private OrderHistoryGeneratorService orderHistoryGeneratorService;

	public OrderHistoryViewServiceImpl(OrderHistoryGeneratorService orderHistoryGeneratorService) {
		this.orderHistoryGeneratorService = orderHistoryGeneratorService;
	}
	
	@Override
	public List<Order> getOrderByCustomerId(String customerId) {
		List<Order> orders = orderHistoryGeneratorService.getOrderHistoryByCustomerId(customerId);
		return orders;
	}

	@Override
	public Order getOrderByOrderId(String orderId) {
		Order order = orderHistoryGeneratorService.getOrderByOrderId(orderId);
		return order;
	}

	@Override
	public boolean createOrder(Order order) {
		return orderHistoryGeneratorService.addOrder(order);
	}

	@Override
	public boolean deleteOrder(String orderId) {
		return orderHistoryGeneratorService.deleteOrder(orderId);

	}

	@Override
	public boolean updateOrder(Order order) {
		return orderHistoryGeneratorService.updateOrder(order);

	}

}
