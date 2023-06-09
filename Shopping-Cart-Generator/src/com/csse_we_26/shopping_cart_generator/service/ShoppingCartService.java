package com.csse_we_26.shopping_cart_generator.service;

import java.util.List;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.shopping_cart_generator.dto.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.dto.ShoppingCartDTO;



public interface ShoppingCartService {
	
	public void addItemToCart(ProductDTO product, int quantity);
	public void removeItemFromCart(String productId);
	public void updateItemQuantity(String prodcutId, int itemQuantity);
	public void clearCart(String customerId);
	public List<CartItemDTO> getAllCartItems(String customerId);
	public ShoppingCartDTO getShoppingCartByCustomerId(String customerId);
	public double calculateTotalPrice(String customerId);
	public void saveShoppingCart(ShoppingCartDTO shoppingCartDTO);

}
