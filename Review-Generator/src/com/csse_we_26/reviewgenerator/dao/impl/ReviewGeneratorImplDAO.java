package com.csse_we_26.reviewgenerator.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.mongodb.client.model.Filters;




import org.bson.Document;


import com.csse_we_26.reviewgenerator.dao.ReviewGeneratorDAO;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ReviewGeneratorImplDAO  implements ReviewGeneratorDAO{
	
	private MongoDatabase database;
	private MongoCollection<Document> collection;


	public ReviewGeneratorImplDAO(MongoDatabase database,String collectionName) {

	        this.database = database;
	        collection = this.database.getCollection(collectionName);

	    }

	public List<Document> getReviewByProductId(String productId) {
		try {
			//MongoCollection<Document> collection = database.getCollection("reviews");
			
			List<Document> reviews = new ArrayList<>();
			
			for (Document doc : collection.find(Filters.eq("productId", productId))) {
	
				
				reviews.add(doc);
			}
			
			return reviews;
		} catch (Exception e) {
			System.out.println("Error updating review: " + e.getMessage());
			return null;
		}
		
	}
}
