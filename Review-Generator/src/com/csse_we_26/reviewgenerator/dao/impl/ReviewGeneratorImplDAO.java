package com.csse_we_26.reviewgenerator.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.mongodb.client.model.Filters;




import org.bson.Document;


import com.csse_we_26.reviewgenerator.dao.ReviewGeneratorDAO;
import com.csse_we_26.reviewgenerator.mapper.ReviewMapper;
import com.csse_we_26.reviewgenerator.model.Review;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ReviewGeneratorImplDAO  implements ReviewGeneratorDAO{
	
	private MongoDatabase database;
	private MongoCollection<Document> collection;


	public ReviewGeneratorImplDAO(MongoDatabase database,String collectionName) {

	        this.database = database;
	        collection = this.database.getCollection(collectionName);

	    }

	public List<Review> getReviewByProductId(String productId) {
		try {
			//MongoCollection<Document> collection = database.getCollection("reviews");
			
			List<Review> reviews = new ArrayList<>();
			
			for (Document doc : collection.find(Filters.eq("productId", productId))) {
	
				
				reviews.add(ReviewMapper.mapToReview(doc));
			}
			
			return reviews;
		} catch (Exception e) {
			System.out.println("Error updating review: " + e.getMessage());
			return null;
		}
		
	}
	@Override
	public boolean addReview(Review review) {
		try {
			MongoCollection<Document> collection = database.getCollection("reviews");
			
			//proCollection
			
			Document doc = new Document("productId", review.getProductId())
					.append("userId", review.getUserId())
					.append("rating", review.getRating())
					.append("comment", review.getComment()).append("reviewId",review.getId());
			
			collection.insertOne(doc);
			
			return true;
		} catch (Exception e) {
			System.out.println("Error adding review: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteReview(String reviewId) {
		try {
			MongoCollection<Document> collection = database.getCollection("reviews");
			
			collection.deleteOne(new Document("reviewId", reviewId));
			
			return true;
		} catch (Exception e) {
			System.out.println("Error deleting review: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateReview(Review review) {
		try {
			MongoCollection<Document> collection = database.getCollection("reviews");
			
			Document doc = new Document("reviewId", review.getId())
					.append("productId", review.getProductId())
					.append("userId", review.getUserId())
					.append("rating", review.getRating())
					.append("comment", review.getComment());
			
			collection.replaceOne(new Document("reviewId", review.getId()), doc);
			
			return true;
		} catch (Exception e) {
			System.out.println("Error updating review: " + e.getMessage());
			return false;
		}
	}

	@Override
	public List<Review> getAllReviews() {
		try {
			MongoCollection<Document> collection = database.getCollection("reviews");
			
			List<Review> reviews = new ArrayList<>();
			
			for (Document doc : collection.find()) {
				Review review = new Review(
						doc.getObjectId("_id"),
						doc.getString("productId"),
						doc.getString("userId"),
						doc.getDouble("rating"),
						doc.getString("comment")
				);
				
				reviews.add(review);
			}
			
			return reviews;
		} catch (Exception e) {
			System.out.println("Error getting reviews: " + e.getMessage());
			return null;
		}
	}
	
}
