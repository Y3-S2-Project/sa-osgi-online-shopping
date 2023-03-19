package com.csse_we_26.order_history_generator.dto;


import java.time.LocalDateTime;

import org.bson.Document;

import com.csse_we_26.shopping_cart_generator.dto.ShoppingCartDTO;



public class OrderHistoryDTO {

	private String orderNumber;
	private String customerId;
	private ShoppingCartDTO shoppingCartDTO;
	private String orderStatus;
	//private LocalDateTime orderDate;
	private String shippingAddress;

	public OrderHistoryDTO(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public OrderHistoryDTO(String orderNumber, String customerId, ShoppingCartDTO shoppingCartDTO,
			String orderStatus, String shippingAddress) {
		this.orderNumber = orderNumber;
		this.customerId = customerId;
		this.shoppingCartDTO = shoppingCartDTO;
		this.orderStatus = orderStatus;
	//	this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
	}

	public OrderHistoryDTO(Document document) {
		this.orderNumber = document.getString("orderNumber");
		this.customerId = document.getString("customerId");
		this.shoppingCartDTO = (ShoppingCartDTO) document.get("shoppingCartDTO");
		this.orderStatus =  document.getString("orderStatus");
		//this.orderDate = (LocalDateTime) document.get("orderDate");
		this.shippingAddress = document.getString("shippingAddress");
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

	public ShoppingCartDTO getShoppingCartDTO() {
		return shoppingCartDTO;
	}

	public void setShoppingCartDTO(ShoppingCartDTO shoppingCartDTO) {
		this.shoppingCartDTO = shoppingCartDTO;
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
		Document document = new Document("orderNumber", orderNumber).append("customerId", customerId)
				.append("shoppingCartDTO", shoppingCartDTO).append("orderStatus", orderStatus)
				.append("shippingAddress", shippingAddress);
		return document;
	}

}
