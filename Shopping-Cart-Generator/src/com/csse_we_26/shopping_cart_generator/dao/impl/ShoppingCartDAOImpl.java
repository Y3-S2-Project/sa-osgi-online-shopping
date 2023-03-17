package com.csse_we_26.shopping_cart_generator.dao.impl;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.mapper.ProductMapper;
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
	public ShoppingCartDTO getShoppingCartById(String cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveShoppingCart(ShoppingCartDTO cart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateShoppingCart(ShoppingCartDTO cart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteShoppingCart(String cartId) {
		// TODO Auto-generated method stub

	}

}
