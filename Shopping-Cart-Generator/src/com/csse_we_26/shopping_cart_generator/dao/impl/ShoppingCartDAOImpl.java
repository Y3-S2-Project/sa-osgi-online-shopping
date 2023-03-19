package com.csse_we_26.shopping_cart_generator.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import mongodb_service.ProductDTO;
import com.csse_we_26.shopping_cart_generator.dao.ShoppingCartDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import mongodb_service.CartItemDTO;
import mongodb_service.ShoppingCartDTO;
import mongodb_service.ShoppingCartMapper;

public class ShoppingCartDAOImpl implements ShoppingCartDAO {

	private MongoDatabase database;
	private MongoCollection<Document> collection;

	public ShoppingCartDAOImpl(MongoDatabase database, String collectionName) {

		this.database = database;
		collection = this.database.getCollection(collectionName);
	}

	@Override
	public void addItemToCart(ProductDTO product, int quantity) {
		// Create a new CartItemDTO object and set its fields
		CartItemDTO cartItem = new CartItemDTO(product, quantity);

		// Insert the new document into the collection
		collection.insertOne(cartItem.toDocument());
	}

	@Override
	public void removeItemFromCart(String productId) {
		// Create a query to find the document with the matching productId
		BasicDBObject query = new BasicDBObject("product.productId", productId);

		// Remove the matching document from the collection
		collection.deleteOne(query);
	}

	@Override
	public void updateItemQuantity(String productId, int itemQuantity) {
		// Create a query to find the document with the matching productId
		BasicDBObject query = new BasicDBObject("product.productId", productId);

		// Create an update document to set the new quantity value
		BasicDBObject update = new BasicDBObject("$set", new BasicDBObject("quantity", itemQuantity));

		// Update the matching document in the collection
		collection.updateOne(query, update);
	}

	@Override
	public void clearCart() {
		// Remove all documents from the collection
		collection.deleteMany(new BasicDBObject());
	}

	@Override
	public List<CartItemDTO> getAllCartItems() {
		// Create an empty list to hold the results
		List<CartItemDTO> cartItems = new ArrayList<>();

		// Find all documents in the collection
		FindIterable<Document> documents = collection.find();

		// Loop over the documents and convert each one to a CartItemDTO object
		for (Document document : documents) {
			cartItems.add(ShoppingCartMapper.mapToCartItemDTO(document));
		}

		return cartItems;
	}

	@Override
	public ShoppingCartDTO getShoppingCartByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		BasicDBObject query = new BasicDBObject("customerId", customerId);
		FindIterable<Document> iterable = collection.find(query);
		Document document = iterable.first();
		return ShoppingCartMapper.mapToShoppingCartDTO(document);
	}

	@Override
	public void saveShoppingCart(ShoppingCartDTO shoppingCartDTO) {
		// TODO Auto-generated method stub
		
	}

}
