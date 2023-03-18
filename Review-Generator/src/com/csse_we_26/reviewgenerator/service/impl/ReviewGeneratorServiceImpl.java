package com.csse_we_26.reviewgenerator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.csse_we_26.reviewgenerator.model.Review;
import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;
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
		    System.out.println("MongoDb connected");	
	}
	
	@Activate
	public void activate() {
	    
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReview(String reviewId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReview(Review review) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
