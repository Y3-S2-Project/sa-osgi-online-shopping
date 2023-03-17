package com.csse_we_26.order_history_generator.mapper;

import com.csse_we_26.order_history_generator.DTO.OrderHistoryDTO;
import com.csse_we_26.order_history_generator.model.OrderHistory;
import com.csse_we_26.shopping_cart_generator.mapper.ShoppingCartMapper;

public class OrderHistoryMapper {
	
    public OrderHistoryDTO mapToOrderHistoryDTO(OrderHistory orderHistory) {
        return new OrderHistoryDTO(
                orderHistory.getOderNumber(),
                orderHistory.getCustomerId(),
                ShoppingCartMapper.mapToShoppingCartDTO(orderHistory.getShoppingCart()),
                orderHistory.getOrderStatus(),
                orderHistory.getOrderDate(),
                orderHistory.getShippingAddress()
        );
    }

    public OrderHistory mapToOderHistory(OrderHistoryDTO orderHistoryDTO) {
        return new OrderHistory(
                orderHistoryDTO.getOderNumber(),
                orderHistoryDTO.getCustomerId(),
                ShoppingCartMapper.mapToShoppingCart(orderHistoryDTO.getShoppingCartDTO()),
                orderHistoryDTO.getOrderStatus(),
                orderHistoryDTO.getOrderDate(),
                orderHistoryDTO.getShippingAddress()
        );
    }

}
