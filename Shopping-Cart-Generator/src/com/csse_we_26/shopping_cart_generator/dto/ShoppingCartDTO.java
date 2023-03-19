package com.csse_we_26.shopping_cart_generator.dto;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.mapper.ProductMapper;
import com.csse_we_26.product_listing_generator.model.Product;
import com.csse_we_26.shopping_cart_generator.model.CartItem;

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
		System.out.println("ShoppingCartDTO");
	    List<CartItemDTO> cartItems = new ArrayList<>();
		System.out.println("ShoppingCartDTOsssssssssssss");
		ProductMapper mapper = new ProductMapper();
	    for (Document cartItemDoc : cartItemList) {
	        CartItemDTO cartItem = new CartItemDTO();
	        cartItem.setQuantity(cartItemDoc.getInteger("quantity", 0));
	        System.out.println((Document)(cartItemDoc.get("product")));
	        Product product = mapper.mapToProduct((Document)(cartItemDoc.get("product")));
	        cartItem.setProduct(mapper.mapToProductDTO(product, null));
			System.out.println("ShoppingCartDTOsssssssssssss here");
	        cartItems.add(cartItem);
	    }
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
		System.out.println("document" + document.toJson());
		return document;
	}
}
