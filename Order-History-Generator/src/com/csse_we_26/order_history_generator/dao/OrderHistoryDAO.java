package com.csse_we_26.order_history_generator.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.csse_we_26.order_history_generator.DTO.OrderHistoryDTO;

public interface OrderHistoryDAO {
	
	public OrderHistoryDTO getOrderByOrderNumber(String orderNumber);
	public List<OrderHistoryDTO> getAllOrders();
	public List<OrderHistoryDTO> getOrderHistoryByCustomerId(String customerId);
	public List<OrderHistoryDTO> getOrderHistoryByDate(LocalDateTime date);
	public void createOrder(OrderHistoryDTO order);
	public void updateOrder(OrderHistoryDTO order);
	public void removeOrderByOrderNumber(String orderNumber);

}
