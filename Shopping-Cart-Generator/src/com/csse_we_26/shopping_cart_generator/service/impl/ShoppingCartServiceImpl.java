package com.csse_we_26.shopping_cart_generator.service.impl;

import java.util.List;

import com.csse_we_26.product_listing_generator.DTO.ProductDTO;
import com.csse_we_26.shopping_cart_generator.DTO.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.DTO.ShoppingCartDTO;
import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Override
	public void addItemToCart(ProductDTO product, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItemFromCart(String productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItemQuantity(String prodcutId, int itemQuantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearCart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CartItemDTO> getAllCartItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCartDTO getShoppingCartByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
