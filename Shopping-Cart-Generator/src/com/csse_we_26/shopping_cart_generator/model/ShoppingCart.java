package com.csse_we_26.shopping_cart_generator.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class ShoppingCart {
	
	private List<CartItem> items;
	private String customerId;
	
	public ShoppingCart() {}
	
	public ShoppingCart(Document document) {
		this.customerId = document.getString("customerId");
		List<Document> cartItemList = (List<Document>) document.get("items");
	    List<CartItem> cartItems = new ArrayList<>();
	    for (Document cartItemDoc : cartItemList) {
	        CartItem cartItem = new CartItem(cartItemDoc);
	        cartItems.add(cartItem);
	    }
	    this.items = cartItems;
	}
	
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
	
	public Document toDocument() {
		Document document = new Document("customerId", customerId)
				.append("items", items);
		System.out.println("document" + document.toJson());
		return document;
	}
}
