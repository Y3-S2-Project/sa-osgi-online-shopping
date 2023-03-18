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
        BasicDBObject query = new BasicDBObject("pid", id);
        FindIterable<Document> iterable = collection.find(query);
        Document doc = iterable.first();
        return mapper.mapToProduct(doc);
    }
    
    @Override
    public List<Product> getProductsByCategory(String category) {
        BasicDBObject query = new BasicDBObject("category", category);
        FindIterable<Document> iterable = collection.find(query);
        List<Product> products = new ArrayList<>();
        for (Document doc : iterable) {
            products.add(mapper.mapToProduct(doc));
        }
        return products;
    }
    
    @Override
    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        BasicDBObject query = new BasicDBObject("price", new BasicDBObject("$gte", minPrice).append("$lte", maxPrice));
        FindIterable<Document> iterable = collection.find(query);
        List<Product> products = new ArrayList<>();
        for (Document doc : iterable) {
            products.add(mapper.mapToProduct(doc));
        }
        return products;
    }


    
    @Override
    public List<Product> getProductsSortedByPrice() {
        BasicDBObject sort = new BasicDBObject("price", 1);
        FindIterable<Document> iterable = collection.find().sort(sort);
        List<Product> products = new ArrayList<>();
        for (Document doc : iterable) {
            products.add(mapper.mapToProduct(doc));
        }
        return products;
    }
    
    @Override
    public List<Product> getProductsSortedByPopularity() {
        BasicDBObject sort = new BasicDBObject("popularity", -1);
        FindIterable<Document> iterable = collection.find().sort(sort);
        List<Product> products = new ArrayList<>();
        for (Document doc : iterable) {
            products.add(mapper.mapToProduct(doc));
        }
        return products;
    }
    
    @Override
    public List<Product> getProductsSortedByRating() {
        BasicDBObject sort = new BasicDBObject("rating", -1);
        FindIterable<Document> iterable = collection.find().sort(sort);
        List<Product> products = new ArrayList<>();
        for (Document doc : iterable) {
            products.add(mapper.mapToProduct(doc));
        }
        return products;
    }
    
    @Override
    public List<Product> searchProductsByKeyword(String keyword) {
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
    }

	@Override
	public List<Product> getProductsByPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}



	   
    @Override
    public void addProduct(Product product) {
        Document doc = mapper.mapToDocument(product);
        collection.insertOne(doc);
    }
}
