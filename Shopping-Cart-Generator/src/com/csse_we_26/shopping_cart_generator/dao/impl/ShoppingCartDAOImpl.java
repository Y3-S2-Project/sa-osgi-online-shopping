package com.csse_we_26.shopping_cart_generator.dao.impl;

import java.util.List;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.DTO.ProductDTO;
import com.csse_we_26.shopping_cart_generator.DTO.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.DTO.ShoppingCartDTO;
import com.csse_we_26.shopping_cart_generator.dao.ShoppingCartDAO;
import com.csse_we_26.shopping_cart_generator.mapper.ShoppingCartMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ShoppingCartDAOImpl implements ShoppingCartDAO {
	
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	private ShoppingCartMapper mapper;
	
	public ShoppingCartDAOImpl(MongoDatabase database, String collectionName) {
		
		this.database = database;
		collection = this.database.getCollection(collectionName);
		mapper = new ShoppingCartMapper();
	}

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

	

}
