package com.csse_we_26.shopping_cart_generator.DTO;

import java.util.List;

public class ShoppingCartDTO {
	private List<CartItemDTO> items;
	private String customerId;

	public ShoppingCartDTO(List<CartItemDTO> items, String customerId) {
		this.items = items;
		this.customerId = customerId;
	}

	public List<CartItemDTO> getItems() {
		return items;
	}

	public void setItems(List<CartItemDTO> items) {
		this.items = items;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
}
