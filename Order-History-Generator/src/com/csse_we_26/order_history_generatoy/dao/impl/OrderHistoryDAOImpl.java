package com.csse_we_26.order_history_generatoy.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.csse_we_26.order_history_generator.DTO.OrderHistoryDTO;
import com.csse_we_26.order_history_generator.dao.OrderHistoryDAO;
import com.csse_we_26.order_history_generator.mapper.OrderHistoryMapper;
import com.csse_we_26.order_history_generator.model.OrderHistory;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {

	private MongoDatabase database;
	private MongoCollection<Document> collection;

	public OrderHistoryDAOImpl(MongoDatabase database, String collectionName) {
		this.database = database;
		collection = this.database.getCollection(collectionName);
	}

	@Override
	public OrderHistoryDTO getOrderByOrderNumber(String orderNumber) {
		try {
			BasicDBObject query = new BasicDBObject("orderNumber", orderNumber);
			FindIterable<Document> iterable = collection.find(query);
			Document document = iterable.first();
			return OrderHistoryMapper.mapToOrderHistoryDTO(document);
		} catch (Exception e) {
			System.out.println("Failed to retrieve Order: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<OrderHistoryDTO> getAllOrders() {
		try {
			BasicDBObject query = new BasicDBObject();
			FindIterable<Document> iterable = collection.find(query);
			List<OrderHistoryDTO> orderHistoryDTO = new ArrayList<>();
			for (Document document : iterable) {
				orderHistoryDTO.add(OrderHistoryMapper.mapToOrderHistoryDTO(document));
			}
			return orderHistoryDTO;
		} catch (Exception e) {
			System.out.println("Failed to retrieve Orders: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<OrderHistoryDTO> getOrderHistoryByCustomerId(String customerId) {
		try {
			BasicDBObject query = new BasicDBObject("customerId", customerId);
			FindIterable<Document> iterable = collection.find(query);
			List<OrderHistoryDTO> orderHistoryDTO = new ArrayList<>();
			for (Document document : iterable) {
				orderHistoryDTO.add(OrderHistoryMapper.mapToOrderHistoryDTO(document));
			}
			return orderHistoryDTO;
		} catch (Exception e) {
			System.out.println("Failed to retrieve Order: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<OrderHistoryDTO> getOrderHistoryByDate(LocalDateTime date) {
		try {
			BasicDBObject query = new BasicDBObject("orderDate", date);
			FindIterable<Document> iterable = collection.find(query);
			List<OrderHistoryDTO> orderHistoryDTO = new ArrayList<>();
			for (Document document : iterable) {
				orderHistoryDTO.add(OrderHistoryMapper.mapToOrderHistoryDTO(document));
			}
			return orderHistoryDTO;
		} catch (Exception e) {
			System.out.println("Failed to retrieve Order: " + e.getMessage());
			return null;
		}
	}

	@Override
	public boolean createOrder(OrderHistoryDTO order) {
		try {
			OrderHistory orderHistory = OrderHistoryMapper.mapToOrderHistory(order);
			Document document = new Document("orderNumber", orderHistory.getOrderNumber())
					.append("customerId", orderHistory.getCustomerId())
					.append("shoppingCart", orderHistory.getShoppingCart())
					.append("orderStatus", orderHistory.getOrderStatus())
					.append("orderDate", orderHistory.getOrderDate())
					.append("shippingAddress", orderHistory.getShippingAddress());

			collection.insertOne(document);
			return true;
		} catch (Exception e) {
			System.out.println("Failed to add Order: " + e.getMessage());
			return false;
		}

	}

	@Override
	public boolean updateOrder(OrderHistoryDTO order) {
		try {
			OrderHistory orderHistory = OrderHistoryMapper.mapToOrderHistory(order);
			Document document = new Document("orderNumber", orderHistory.getOrderNumber())
					.append("customerId", orderHistory.getCustomerId())
					.append("shoppingCart", orderHistory.getShoppingCart())
					.append("orderStatus", orderHistory.getOrderStatus())
					.append("orderDate", orderHistory.getOrderDate())
					.append("shippingAddress", orderHistory.getShippingAddress());

			collection.replaceOne(new Document("orderNumber", orderHistory.getOrderNumber()), document);
			return true;
		} catch (Exception e) {
			System.out.println("Failed to update Order: " + e.getMessage());
			return false;
		}

	}

	@Override
	public boolean removeOrderByOrderNumber(String orderNumber) {
		try {
			collection.deleteOne(new Document("orderNumber", orderNumber));
			return true;
		} catch (Exception e) {
			System.out.println("Failed to remove Order: " + e.getMessage());
			return false;
		}

	}

}
