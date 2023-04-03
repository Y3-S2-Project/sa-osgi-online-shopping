package com.csse_we_26.product_listing_generator.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.csse_we_26.product_listing_generator.dao.ProductDAO;
import com.csse_we_26.product_listing_generator.mapper.ProductMapper;
import com.csse_we_26.product_listing_generator.model.Product;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;




public class ProductDAOImpl implements ProductDAO {
    
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private ProductMapper mapper;
    
    public ProductDAOImpl(MongoDatabase database,String collectionName) {

        this.database = database;
        collection = this.database.getCollection(collectionName);
        mapper = new ProductMapper();
    }
    

    
    @Override
    public Product getProductById(String id) {

        try {
			Document doc = (Document) collection.find(Filters.eq("pid", id)).first();

			return mapper.mapToProduct(doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println();
			return null;
		}
    }
    
    @Override
    public List<Product> getProductsByCategory(String category) {

        try {
			List<Product> products = new ArrayList<>();
			for (Document doc : collection.find(Filters.eq("category", category))) {
			    products.add(mapper.mapToProduct(doc));
			}
			return products;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
    }
    
    @Override
    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        try {
			BasicDBObject query = new BasicDBObject("price", new BasicDBObject("$gte", minPrice).append("$lte", maxPrice));
			FindIterable<Document> iterable = collection.find(query);
			List<Product> products = new ArrayList<>();
			for (Document doc : iterable) {
			    products.add(mapper.mapToProduct(doc));
			}
			return products;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }


    
    @Override
    public List<Product> getProductsSortedByPrice() {
        try {
			BasicDBObject sort = new BasicDBObject("price", 1);
			FindIterable<Document> iterable = collection.find().sort(sort);
			List<Product> products = new ArrayList<>();
			for (Document doc : iterable) {
			    products.add(mapper.mapToProduct(doc));
			}
			return products;
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			    products.add(mapper.mapToProduct(doc));
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
