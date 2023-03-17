package com.csse_we_26.shopping_cart_generator.model;

import java.util.List;

public class ShoppingCart {
	
	private List<CartItem> items;
	private String customerId;
	
	public ShoppingCart() {}

	public ShoppingCart(List<CartItem> items, String customerId) {
		this.items = items;
		this.customerId = customerId;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}	
	
	
	
}
