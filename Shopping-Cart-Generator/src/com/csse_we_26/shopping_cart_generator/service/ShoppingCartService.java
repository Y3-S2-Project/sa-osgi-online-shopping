package com.csse_we_26.shopping_cart_generator.service;

import java.util.List;

import com.csse_we_26.product_listing_generator.DTO.ProductDTO;
import com.csse_we_26.shopping_cart_generator.DTO.CartItemDTO;

public interface ShoppingCartService {
	
	public void addItemToCart(ProductDTO product, int quantity);
	public void removeItemFromCart(String productId);
	public void updateItemQuantity(String prodcutId, int itemQuantity);
	public void clearCart();
	public List<CartItemDTO> getAllCartItems();
	public double getTotalPrice();

}
