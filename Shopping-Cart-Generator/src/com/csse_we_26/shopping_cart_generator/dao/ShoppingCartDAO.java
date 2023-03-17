package com.csse_we_26.shopping_cart_generator.dao;

import com.csse_we_26.shopping_cart_generator.DTO.ShoppingCartDTO;

public interface ShoppingCartDAO {
	
	public ShoppingCartDTO getShoppingCartById(String cartId);
	public void saveShoppingCart(ShoppingCartDTO cart);
	public void updateShoppingCart(ShoppingCartDTO cart);
	public void deleteShoppingCart(String cartId);
	
}
