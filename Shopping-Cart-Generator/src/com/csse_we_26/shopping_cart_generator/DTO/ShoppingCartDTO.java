package com.csse_we_26.shopping_cart_generator.DTO;

import java.util.List;

public class ShoppingCartDTO {
	private List<CartItemDTO> items;

	public ShoppingCartDTO(List<CartItemDTO> items) {
		this.items = items;
	}

	public List<CartItemDTO> getItems() {
		return items;
	}

	public void setItems(List<CartItemDTO> items) {
		this.items = items;
	}
}
