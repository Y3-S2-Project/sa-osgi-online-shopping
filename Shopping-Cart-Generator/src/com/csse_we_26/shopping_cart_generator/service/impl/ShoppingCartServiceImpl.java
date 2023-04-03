package com.csse_we_26.shopping_cart_generator.service.impl;

import java.util.List;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.shopping_cart_generator.dao.impl.ShoppingCartDAOImpl;
import com.csse_we_26.shopping_cart_generator.dto.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.dto.ShoppingCartDTO;
import com.csse_we_26.shopping_cart_generator.mapper.ShoppingCartMapper;
import com.csse_we_26.shopping_cart_generator.model.ShoppingCart;
import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;
import com.csse_we_26.shopping_cart_generator.util.MongoDBUtil;
import com.mongodb.client.MongoDatabase;



public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCartDAOImpl shoppingCartDAO;

	public ShoppingCartServiceImpl() {

	   this.shoppingCartDAO = new ShoppingCartDAOImpl(MongoDBUtil.getInstance().getDatabase(), "cartItems");
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
	public void clearCart(String customerId) {
		shoppingCartDAO.clearCart(customerId);
	}

	@Override
	public List<CartItemDTO> getAllCartItems(String customerId) {
		return shoppingCartDAO.getAllCartItems(customerId);
	}

	@Override
	public ShoppingCartDTO getShoppingCartByCustomerId(String customerId) {
	
		return ShoppingCartMapper.mapToShoppingCartDTO(shoppingCartDAO.getShoppingCartByCustomerId(customerId));
	}

	@Override
	public double calculateTotalPrice(String customerId) {
		double totalPrice = 0.0;
		List<CartItemDTO> cartItems = shoppingCartDAO.getAllCartItems(customerId);
		for (CartItemDTO item : cartItems) {
			totalPrice += item.getProduct().getPrice() * item.getQuantity();
		}
		return totalPrice;
	}

	@Override
	public void saveShoppingCart(ShoppingCartDTO shoppingCartDTO) {
		// TODO Auto-generated method stub
		
		shoppingCartDAO.saveShoppingCart(shoppingCartDTO);
	}
}
