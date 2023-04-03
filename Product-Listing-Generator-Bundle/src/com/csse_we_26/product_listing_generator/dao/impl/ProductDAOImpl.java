package com.csse_we_26.product_listing_generator.dao.impl;

import java.util.ArrayList;
import java.util.List;


import org.bson.Document;
import org.bson.conversions.Bson;

import com.csse_we_26.product_listing_generator.dao.ProductDAO;
import com.csse_we_26.product_listing_generator.mapper.ProductMapper;
import com.csse_we_26.product_listing_generator.model.Product;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;



//This class is used to implement the methods that are defined in the ProductDAO interface
public class ProductDAOImpl implements ProductDAO {
    
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    
    public ProductDAOImpl(MongoDatabase database,String collectionName) {

        this.database = database;
        collection = this.database.getCollection(collectionName);

    }
    
  
    //This method is used to get the product by id
    @Override
    public Product getProductById(String id) {

		try {
			//Find the product by id
			Document doc = (Document) collection.find(Filters.eq("pid", id)).first();
			//Map the document to the product and return the product
			
			return ProductMapper.mapToProduct(doc);
		} catch (Exception e) {
	
			e.printStackTrace();
			
			return null;
		}
    }
    //This method is used to get the products by category
    @Override
    public List<Product> getProductsByCategory(String category) {

		try {
			//Find the products by category
			List<Product> products = new ArrayList<>();
			//Map the documents to the products
			for (Document doc : collection.find(Filters.eq("category", category))) {
				products.add(ProductMapper.mapToProduct(doc));
			}
			//Return the products
			return products;
		} catch (Exception e) {

			e.printStackTrace();
			
			return null;
		}
    }
    //This method is used to get the products by price range
    @Override
    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
		try {
			//Find the products by price range
			BasicDBObject query = new BasicDBObject("price",
					new BasicDBObject("$gte", minPrice).append("$lte", maxPrice));
			//Map the documents to the products
			FindIterable<Document> iterable = collection.find(query);
			//Return the products
			List<Product> products = new ArrayList<>();
			//Map the documents to the products
			for (Document doc : iterable) {
				//Map the documents to the products
				products.add(ProductMapper.mapToProduct(doc));
			}
			//Return the products
			return products;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
    }


    //This method is used to get the products sorted by price
    @Override
    public List<Product> getProductsSortedByPrice() {
		try {
			//Sort the products by price
			BasicDBObject sort = new BasicDBObject("price", 1);
			//Map the documents to the products
			FindIterable<Document> iterable = collection.find().sort(sort);
			List<Product> products = new ArrayList<>();
			for (Document doc : iterable) {
				products.add(ProductMapper.mapToProduct(doc));
			}
			//Return the products
			return products;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
    }
    

    
    @Override
    public List<Product> getProductsSortedByRating() {
        try {
			BasicDBObject sort = new BasicDBObject("rating", -1);
			FindIterable<Document> iterable = collection.find().sort(sort);
			List<Product> products = new ArrayList<>();
			for (Document doc : iterable) {
			    products.add(ProductMapper.mapToProduct(doc));
			}
			return products;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
    @Override
    public List<Product> searchProductsByKeyword(String keyword) {
        try {
			List<Product> products = new ArrayList<>();
			    
			    // Create text search index on the "name" field
			    collection.createIndex(Indexes.text("name"));
			    
			    // Search for products containing the keyword
			    Bson filter = Filters.text(keyword);
			    FindIterable<Document> result = collection.find(filter);
			    
			    // Convert the documents to Product objects
			    for (Document document : result) {
			        Product product = new Product(document);
			        products.add(product);
			    }

			
			return products;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }


}
