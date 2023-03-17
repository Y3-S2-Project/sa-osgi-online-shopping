package com.csse_we_26.shopping_cart_generator.model;

import com.csse_we_26.product_listing_generator.model.Product;

public class CartItem {
	
    private int quantity;
    private Product product;
    
    public CartItem() {}

    public CartItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
}

