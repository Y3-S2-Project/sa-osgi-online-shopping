package com.csse_we_26.order_history_generator.DTO;

import java.time.LocalDateTime;

import com.csse_we_26.order_history_generator.enumeration.OrderStatus;
import com.csse_we_26.shopping_cart_generator.DTO.ShoppingCartDTO;

public class OrderHistoryDTO {
	
	private String oderNumber;
	private String customerId;
	private ShoppingCartDTO shoppingCartDTO;
	private OrderStatus orderStatus;
	private LocalDateTime orderDate;
	private String shippingAddress;
	
	public OrderHistoryDTO(String oderNumber) {
		this.oderNumber = oderNumber;
	}
	
	public OrderHistoryDTO(String oderNumber, String customerId, ShoppingCartDTO shoppingCartDTO,
			OrderStatus orderStatus, LocalDateTime orderDate, String shippingAddress) {
		this.oderNumber = oderNumber;
		this.customerId = customerId;
		this.shoppingCartDTO = shoppingCartDTO;
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

	public ShoppingCartDTO getShoppingCartDTO() {
		return shoppingCartDTO;
	}

	public void setShoppingCartDTO(ShoppingCartDTO shoppingCartDTO) {
		this.shoppingCartDTO = shoppingCartDTO;
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