package com.csse_we_26.order_history_generator.mapper;

import org.bson.Document;

import com.csse_we_26.order_history_generator.DTO.OrderHistoryDTO;
import com.csse_we_26.order_history_generator.model.OrderHistory;
import com.csse_we_26.shopping_cart_generator.mapper.ShoppingCartMapper;

public class OrderHistoryMapper {
	
    public static OrderHistoryDTO mapToOrderHistoryDTO(OrderHistory orderHistory) {
        return new OrderHistoryDTO(
                orderHistory.getOrderNumber(),
                orderHistory.getCustomerId(),
                ShoppingCartMapper.mapToShoppingCartDTO(orderHistory.getShoppingCart()),
                orderHistory.getOrderStatus(),
                orderHistory.getOrderDate(),
                orderHistory.getShippingAddress()
        );
    }

    public static OrderHistory mapToOderHistory(OrderHistoryDTO orderHistoryDTO) {

        return new OrderHistory(
                orderHistoryDTO.getOrderNumber(),
                orderHistoryDTO.getCustomerId(),
                ShoppingCartMapper.mapToShoppingCart(orderHistoryDTO.getShoppingCartDTO()),
                orderHistoryDTO.getOrderStatus(),
                orderHistoryDTO.getOrderDate(),
                orderHistoryDTO.getShippingAddress()
        );
    }
    
    public static Document mapToDocument(OrderHistory orderHistory) {
    	Document document = orderHistory.toDocument();
    	return document;
    }
    
    public static OrderHistory mapToOrderHistory(Document document) {
    	OrderHistory orderHistory = new OrderHistory(document);
    	return orderHistory;
    }

}
