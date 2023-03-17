package com.csse_we_26.order_history_generator.model;

import java.time.LocalDateTime;
import java.util.Date;

import com.csse_we_26.order_history_generator.enumeration.OrderStatus;
import com.csse_we_26.product_listing_generator.DTO.ProductDTO;
import com.csse_we_26.shopping_cart_generator.DTO.ShoppingCartDTO;
import com.csse_we_26.shopping_cart_generator.model.ShoppingCart;

public class OrderHistory {

	private String oderNumber;
	private String customerId;
	private ShoppingCart shoppingCart;
	private OrderStatus orderStatus;
	private LocalDateTime orderDate;
	private String shippingAddress;

	public OrderHistory() {
	}

	public OrderHistory(String oderNumber, String customerId, ShoppingCart shoppingCart, OrderStatus orderStatus,
			LocalDateTime orderDate, String shippingAddress) {
		this.oderNumber = oderNumber;
		this.customerId = customerId;
		this.shoppingCart = shoppingCart;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
	}

	public String getOderNumber() {
		return oderNumber;
	}

	public void setOderNumber(String oderNumber) {
		this.oderNumber = oderNumber;
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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}