package com.csse_we_26.order_history_generator;

import java.util.Date;
import java.util.List;

public class Order {

	private String id;
	private List<String> cartItems;
	private String userId;
	private Date orderDate;
	private String orderStatus;

	public Order(String id, List<String> cartItems, String userId, Date orderDate, String orderStatus) {
		this.id = id;
		this.cartItems = cartItems;
		this.userId = userId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public List<String> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<String> cartItems) {
		this.cartItems = cartItems;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus= orderStatus;
	}
}
