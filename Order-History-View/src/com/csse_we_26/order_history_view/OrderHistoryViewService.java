package com.csse_we_26.order_history_view;

import com.csse_we_26.order_history_generator.Order;
import java.util.List;

public interface OrderHistoryViewService {

	public List<Order> getOrderByCustomerId(String customerId);

	public Order getOrderByOrderId(String orderId);

	public boolean createOrder(Order order);

	public boolean deleteOrder(String orderId);

	public boolean updateOrder(Order order);

}
