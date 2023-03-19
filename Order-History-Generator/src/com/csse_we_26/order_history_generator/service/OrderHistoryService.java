package com.csse_we_26.order_history_generator.service;

import java.time.LocalDateTime;
import java.util.List;

import com.csse_we_26.order_history_generator.dto.OrderHistoryDTO;



public interface OrderHistoryService {
	
	public OrderHistoryDTO getOrderByOrderNumber(String orderNumber);
	public List<OrderHistoryDTO> getAllOrders();
	public List<OrderHistoryDTO> getOrderHistoryByCustomerId(String customerId);
	public List<OrderHistoryDTO> getOrderHistoryByDate(LocalDateTime date);
	public boolean createOrder(OrderHistoryDTO order);
	public boolean updateOrder(OrderHistoryDTO order);
	public boolean removeOrderByOrderNumber(String orderNumber); 

}
