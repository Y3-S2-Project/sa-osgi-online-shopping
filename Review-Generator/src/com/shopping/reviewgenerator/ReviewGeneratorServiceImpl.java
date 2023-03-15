package com.shopping.reviewgenerator;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component(immediate = true)
public class ReviewGeneratorServiceImpl implements ReviewGeneratorService {
	
	public String ReviewGeneratorService() {
		return "Execute the publish service of ServicePublisher";
	};
	
	private MongoDatabase database;
	private MongoClient mongoClient;
	
	public ReviewGeneratorServiceImpl() {
		   MongoClient client = new MongoClient("localhost", 27017);
		    database = client.getDatabase("shopping");
		    System.out.println("ServiceImpl activated");	
	}
	
	@Activate
	public void activate() {
	    // Connect to the database here
//	    MongoClient client = new MongoClient("localhost", 27017);
//	    database = client.getDatabase("shopping");
//	    System.out.println("ServiceImpl activated");	    
	}

	@Deactivate
	public void deactivate() {
	    // Disconnect from the database here
	    if (database != null) {
	        mongoClient.close();
	        System.out.println("database closed");
	    }
	}

	@Reference(policy = ReferencePolicy.STATIC, cardinality = ReferenceCardinality.MANDATORY)
	public void setDatabase(MongoDatabase database) {
		this.database = database;
	}
	
	@Override
	public boolean addReview(Review review) {
		try {
			MongoCollection<Document> collection = database.getCollection("reviews");
			
			Document doc = new Document("productId", review.getProductId())
					.append("userId", review.getUserId())
					.append("rating", review.getRating())
					.append("comment", review.getComment());
			
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
			
			collection.deleteOne(new Document("_id", reviewId));
			
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
			
			Document doc = new Document("_id", review.getId())
					.append("productId", review.getProductId())
					.append("userId", review.getUserId())
					.append("rating", review.getRating())
					.append("comment", review.getComment());
			
			collection.replaceOne(new Document("_id", review.getId()), doc);
			
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
						doc.getObjectId("_id").toString(),
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
