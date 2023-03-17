package com.csse_we_26.shopping_cart_generator.model;

import java.util.List;

public class ShoppingCart {
	
	private List<CartItem> items;
	
	public ShoppingCart() {}

	public ShoppingCart(List<CartItem> items) {
		this.items = items;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}	
	
}
