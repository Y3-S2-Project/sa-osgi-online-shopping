package com.csse_we_26.shopping_cart_generator.service.impl;

import java.util.List;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.shopping_cart_generator.dao.impl.ShoppingCartDAOImpl;
import com.csse_we_26.shopping_cart_generator.dto.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.dto.ShoppingCartDTO;
import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;
import com.csse_we_26.shopping_cart_generator.util.MongoDBUtil;
import com.mongodb.client.MongoDatabase;



public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCartDAOImpl shoppingCartDAO;

	public ShoppingCartServiceImpl() {

	   this.shoppingCartDAO = new ShoppingCartDAOImpl(MongoDBUtil.getInstance().getDatabase(), "carts");
	}

	@Override
	public void addItemToCart(ProductDTO product, int quantity) {
		shoppingCartDAO.addItemToCart(product, quantity);
	}

	@Override
	public void removeItemFromCart(String productId) {
		shoppingCartDAO.removeItemFromCart(productId);
	}

	@Override
	public void updateItemQuantity(String productId, int itemQuantity) {
		shoppingCartDAO.updateItemQuantity(productId, itemQuantity);
	}

	@Override
	public void clearCart() {
		shoppingCartDAO.clearCart();
	}

	@Override
	public List<CartItemDTO> getAllCartItems() {
		return shoppingCartDAO.getAllCartItems();
	}

	@Override
	public ShoppingCartDTO getShoppingCartByCustomerId(String customerId) {
	
		return shoppingCartDAO.getShoppingCartByCustomerId(customerId);
	}

	@Override
	public double calculateTotalPrice() {
		double totalPrice = 0.0;
		List<CartItemDTO> cartItems = shoppingCartDAO.getAllCartItems();
		for (CartItemDTO item : cartItems) {
			totalPrice += item.getProduct().getPrice() * item.getQuantity();
		}
		return totalPrice;
	}

	@Override
	public void saveShoppingCart(ShoppingCartDTO shoppingCartDTO) {
		// TODO Auto-generated method stub
		
	}
}
