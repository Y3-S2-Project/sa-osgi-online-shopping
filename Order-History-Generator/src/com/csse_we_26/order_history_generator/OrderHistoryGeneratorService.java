package com.csse_we_26.order_history_generator;

import java.util.List;

public interface OrderHistoryGeneratorService {


	
	public boolean addOrder(Order order);
	
	public boolean deleteOrder(String orderId);
	
	public boolean updateOrder(Order order);
	
	public Order getOrderByOrderId(String orderId);
	
	public List<Order> getOrderHistoryByCustomerId(String customerId);
	
}
