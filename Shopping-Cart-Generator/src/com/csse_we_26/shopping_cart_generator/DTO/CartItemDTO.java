package com.csse_we_26.shopping_cart_generator.DTO;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.DTO.ProductDTO;

public class CartItemDTO {
	private int quantity;
	private ProductDTO product;
	
	public CartItemDTO(ProductDTO product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public CartItemDTO(Document document) {
		this.quantity = document.getInteger("quantity");
		this.product = (ProductDTO) document.get("product");
	}

	public CartItemDTO() {
		
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Document toDocument() {
		Document document = new Document("quantity", quantity)
				.append("product", product);
		System.out.println("document" + document.toJson());
		return document;
	}
}
