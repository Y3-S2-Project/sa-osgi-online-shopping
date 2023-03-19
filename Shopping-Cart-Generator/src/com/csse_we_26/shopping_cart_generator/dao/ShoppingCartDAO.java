package com.csse_we_26.shopping_cart_generator.dao;

import java.util.List;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.shopping_cart_generator.dto.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.dto.ShoppingCartDTO;



public interface ShoppingCartDAO {
	
	public void addItemToCart(ProductDTO product, int quantity);
	public void removeItemFromCart(String productId);
	public void updateItemQuantity(String prodcutId, int itemQuantity);
	public void clearCart();
	public List<CartItemDTO> getAllCartItems();
	public ShoppingCartDTO getShoppingCartByCustomerId(String customerId);
	public void saveShoppingCart(ShoppingCartDTO shoppingCartDTO);
	
}
