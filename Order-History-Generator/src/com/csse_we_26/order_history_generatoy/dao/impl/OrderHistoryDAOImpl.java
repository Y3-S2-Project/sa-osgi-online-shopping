package com.csse_we_26.order_history_generatoy.dao.impl;

import java.time.LocalDateTime;
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
		BasicDBObject query = new BasicDBObject("orderNumber", orderNumber);
		FindIterable<Document> iterable = collection.find(query);
		Document document = iterable.first();
		OrderHistory orderHistory = OrderHistoryMapper.mapToOrderHistory(document);
		return OrderHistoryMapper.mapToOrderHistoryDTO(orderHistory);
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
