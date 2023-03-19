package com.csse_we_26.order_history_generator.model;
import java.time.LocalDateTime;
import java.util.Date;

import org.bson.Document;

import com.csse_we_26.shopping_cart_generator.model.ShoppingCart;


public class OrderHistory {

	private String orderNumber;
	private String customerId;
	private ShoppingCart shoppingCart;
	private String orderStatus;
	//private LocalDateTime orderDate;
	private String shippingAddress;

	public OrderHistory() {
	}

	public OrderHistory(String orderNumber, String customerId, ShoppingCart shoppingCart, String orderStatus,
		 String shippingAddress) {
		this.orderNumber = orderNumber;
		this.customerId = customerId;
		this.shoppingCart = shoppingCart;
		this.orderStatus = orderStatus;
	//	this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
	}

	
	public OrderHistory(Document document) {
		this.orderNumber = document.getString("orderNumber");
		this.customerId = document.getString("customerId");
	//	this.shoppingCart = (ShoppingCart) document.get("shoppingCart");
		this.orderStatus =  document.getString("orderStatus");
	//	this.orderDate = (LocalDateTime) document.get("orderDate");
		this.shippingAddress = document.getString("shippingAddress");
	}

	public String getOderNumber() {
		return orderNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

//	public LocalDateTime getOrderDate() {
//		return orderDate;
//	}
//
//	public void setOrderDate(LocalDateTime orderDate) {
//		this.orderDate = orderDate;
//	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public Document toDocument() {
		Document document = new Document("orderNumber", orderNumber)
				.append("customerId", customerId)
				.append("shoppingCart", shoppingCart)
				.append("orderStatus", orderStatus)
				
				.append("shippingAddress", shippingAddress);
		return document;
	}
}
