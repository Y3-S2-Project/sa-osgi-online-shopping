package com.csse_we_26.shopping_cart_generator.DTO;

import java.util.List;

import org.bson.Document;

public class ShoppingCartDTO {
	private List<CartItemDTO> items;
	private String customerId;

	public ShoppingCartDTO(List<CartItemDTO> items, String customerId) {
		this.items = items;
		this.customerId = customerId;
	}
	
	public ShoppingCartDTO(Document document) {
		this.customerId = document.getString("customerId");
		this.items = (List<CartItemDTO>) document.get("items");
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
	
	public Document toDocument() {
		Document document = new Document("customerId", customerId)
				.append("items", items);
		System.out.println("document" + document.toJson());
		return document;
	}
}
