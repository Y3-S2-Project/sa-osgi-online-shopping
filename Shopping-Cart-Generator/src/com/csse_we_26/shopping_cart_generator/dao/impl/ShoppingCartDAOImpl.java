package com.csse_we_26.shopping_cart_generator.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.shopping_cart_generator.dao.ShoppingCartDAO;
import com.csse_we_26.shopping_cart_generator.dto.CartItemDTO;
import com.csse_we_26.shopping_cart_generator.dto.ShoppingCartDTO;
import com.csse_we_26.shopping_cart_generator.mapper.ShoppingCartMapper;
import com.csse_we_26.shopping_cart_generator.model.CartItem;
import com.csse_we_26.shopping_cart_generator.model.ShoppingCart;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Updates;



public class ShoppingCartDAOImpl implements ShoppingCartDAO {

	private MongoDatabase database;
	private MongoCollection<Document> collection;

	public ShoppingCartDAOImpl(MongoDatabase database, String collectionName) {

		this.database = database;
		collection = this.database.getCollection(collectionName);
	}

	@Override
	public void addItemToCart(ProductDTO productDTO, int quantity) {
		// Create a new CartItemDTO object and set its fields
		CartItemDTO cartItemDTO = new CartItemDTO(productDTO, quantity);

		// Insert the new document into the collection
		try{collection.insertOne((ShoppingCartMapper.mapToCartItem(cartItemDTO)).toDocument());}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeItemFromCart(String productId) {
		// Create a query to find the document with the matching productId
		BasicDBObject query = new BasicDBObject("product.pid", productId);

		// Remove the matching document from the collection
		collection.deleteOne(query);
	}

	@Override
	public void updateItemQuantity(String productId, int itemQuantity) {
		// Create a query to find the document with the matching productId
		BasicDBObject query = new BasicDBObject("product.pid", productId);

		// Create an update document to set the new quantity value
		BasicDBObject update = new BasicDBObject("$set", new BasicDBObject("quantity", itemQuantity));

		// Update the matching document in the collection
		collection.updateOne(query, update);
	}

	@Override
	public void clearCart(String customerId) {

		try {
			Document document = this.database.getCollection("shoppingcarts")
				    .findOneAndUpdate(
				        Filters.eq("customerId", customerId),
				        Updates.set("items", null),
				        new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER)
				    );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public List<CartItemDTO> getAllCartItems(String customerId) {
		// Create an empty list to hold the results
		List<CartItemDTO> cartItems = new ArrayList<>();
        
		BasicDBObject query = new BasicDBObject("customerId", customerId);

		// Find all documents in the collection
		FindIterable<Document> document =  (this.database.getCollection("shoppingcarts").find(query));
		
		Document firtDocument = document.first();
		FindIterable<Document> cartItemDoc = firtDocument.get("items",null);
		// Loop over the documents and convert each one to a CartItemDTO object
	    for(Document doc : cartItemDoc) {
	    	ShoppingCartMapper.mapToCartItemDTO(doc);
	    }
		return cartItems;
	}

	@Override
	public ShoppingCart getShoppingCartByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		BasicDBObject query = new BasicDBObject("customerId", customerId);

		FindIterable<Document> iterable = this.database.getCollection("shoppingcarts").find(query);
		Document document = iterable.first();
		return 	ShoppingCartMapper.mapToShoppingCart(document);
	}

	@Override
	public void saveShoppingCart(ShoppingCartDTO shoppingCartDTO) {
		// TODO Auto-generated method stub
		this.database.getCollection("shoppingcarts").insertOne(shoppingCartDTO.toDocument());
	}

}
