package com.csse_we_26.order_history_generator;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@Component(immediate = true)
public class OrderHistoryGeneratorServiceImpl implements OrderHistoryGeneratorService {

	private MongoDatabase database;
	private MongoClient mongoClient;


	public OrderHistoryGeneratorServiceImpl() {
		MongoClient client = new MongoClient("localhost", 27017);
		database = client.getDatabase("shopping");
		System.out.println("Mongo DB Connected!");
	}

	@Activate
	public void activate() {

	}

	@Deactivate
	public void deactivate() {
		if (database != null) {
			mongoClient.close();
			System.out.println("Database closed!");
		}
	}

	@Reference(policy = ReferencePolicy.STATIC, cardinality = ReferenceCardinality.MANDATORY)
	public void setDatabase(MongoDatabase database) {
		this.database = database;
	}

	@Override
	public boolean addOrder(Order order) {
		try {
			MongoCollection<Document> collection = database.getCollection("orders");

			Document document = new Document("orderId", order.getId())
					.append("cartItems", order.getCartItems())
					.append("userId", order.getUserId())
					.append("orderDate", order.getOrderDate())
					.append("orderStatus", order.getOrderStatus());

			collection.insertOne(document);
			return true;

		} catch (Exception e) {
			System.out.println("Failed to create order: " + e.getMessage());
			return false;

		}
	}

	@Override
	public boolean deleteOrder(String orderId) {
		try {
			MongoCollection<Document> collection = database.getCollection("orders");

			collection.deleteOne(new Document("orderId", orderId));
			return true;

		} catch (Exception e) {
			System.out.println("Failed to delete order: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateOrder(Order order) {
		try {
			MongoCollection<Document> collection = database.getCollection("orders");

			Document document = new Document("orderId", order.getId())
					.append("cartItems", order.getCartItems())
					.append("userId", order.getUserId())
					.append("orderDate", order.getOrderDate())
					.append("orderStatus", order.getOrderStatus());

			collection.replaceOne(new Document("orderId", order.getId()), document);
			return true;

		} catch (Exception e) {
			System.out.println("Failed to update order: " + e.getMessage());
			return false;
		}
	}

	@Override
	public Order getOrderByOrderId(String orderId) {
	    try {
	        MongoCollection<Document> collection = database.getCollection("orders");

	        Bson filter = Filters.eq("orderId", orderId);
	        Document document = collection.find(filter).first();

	        if (document != null) {
				Date orderDate = document.getDate("orderDate");

				List<String> cartItems = (List<String>) document.get("cartItems");

				return new Order(document.getString("orderId"), 
						cartItems,
						document.getString("userId"),
						orderDate,
						document.getString("orderStatus"));
			} else {
				return null;
			}
	    } catch (Exception e) {
	        System.out.println("Failed to retrieve order: " + e.getMessage());
	        return null;
	    }
	}


	@Override
	public List<Order> getOrderHistoryByCustomerId(String customerId) {
		try {
			MongoCollection<Document> collection = database.getCollection("orders");

			Bson filter = Filters.eq("userId", customerId);
			FindIterable<Document> documents = collection.find(filter);

			List<Order> orders = new ArrayList<>();

			for (Document document : documents) {
				Date orderDate = document.getDate("orderDate");

				List<String> cartItems = (List<String>) document.get("cartItems");

				Order order = new Order(document.getString("orderId"), 
						cartItems,
						document.getString("userId"), 
						orderDate, 
						document.getString("orderStatus"));

				orders.add(order);
			}

			return orders;
		} catch (Exception e) {
			System.out.println("Failed to retrieve orders: " + e.getMessage());
			return null;
		}
	}

}
