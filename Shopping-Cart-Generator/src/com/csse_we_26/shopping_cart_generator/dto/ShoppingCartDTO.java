package com.csse_we_26.shopping_cart_generator.dto;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;


;

public class ShoppingCartDTO {
	private List<CartItemDTO> items;
	private String customerId;

	public ShoppingCartDTO(List<CartItemDTO> items, String customerId) {
		this.items = items;
		this.customerId = customerId;

	}
	
	public ShoppingCartDTO(Document document) {
		this.customerId = document.getString("customerId");
		

		List<Document> cartItemList = (List<Document>) document.get("items");

	    List<CartItemDTO> cartItems = new ArrayList<>();


         cartItems= null;
	    this.items = cartItems;
	}

	public ShoppingCartDTO() {
		
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
		return document;
	}
}
