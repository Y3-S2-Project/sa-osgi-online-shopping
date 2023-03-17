package com.csse_we_26.order_history_generator.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.csse_we_26.order_history_generator.DTO.OrderHistoryDTO;
import com.csse_we_26.order_history_generator.service.OrderHistoryService;

public class OrderHistoryServiceImpl implements OrderHistoryService {

	@Override
	public OrderHistoryDTO getOrderByOrderNumber(String orderNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderHistoryDTO> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderHistoryDTO> getOrderHistoryByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderHistoryDTO> getOrderHistoryByDate(LocalDateTime date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrder(OrderHistoryDTO order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrder(OrderHistoryDTO order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrderByOrderNumber(String orderNumber) {
		// TODO Auto-generated method stub
		
	}

}
