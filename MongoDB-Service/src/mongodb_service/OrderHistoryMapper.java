package mongodb_service;

import org.bson.Document;



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

    public static OrderHistory mapToOrderHistory(OrderHistoryDTO orderHistoryDTO) {

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
    
    public static Document mapToDocument(OrderHistoryDTO orderHistoryDTO) {
    	Document document = orderHistoryDTO.toDocument();
    	return document;
    }
    
    public static OrderHistoryDTO mapToOrderHistoryDTO(Document document) {
    	OrderHistoryDTO orderHistoryDTO = new OrderHistoryDTO(document);
    	return orderHistoryDTO;
    }

}
