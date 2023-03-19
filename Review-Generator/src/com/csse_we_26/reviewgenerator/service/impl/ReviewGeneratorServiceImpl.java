package com.csse_we_26.reviewgenerator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.csse_we_26.reviewgenerator.dao.impl.ReviewGeneratorImplDAO;



import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;
import com.csse_we_26.reviewgenerator.util.MongoDBUtil;



public class ReviewGeneratorServiceImpl implements ReviewGeneratorService {
	private ReviewGeneratorImplDAO reviewGeneratorDAOImpl;


	public ReviewGeneratorServiceImpl() {
		try {
						
		// Print the database name 
		System.out.println(MongoDBUtil.getInstance().getDatabase().getName());
		reviewGeneratorDAOImpl = new ReviewGeneratorImplDAO( MongoDBUtil.getInstance().getDatabase() , "reviews");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
	}



	public List<Document> getReviewByProductId(String productId) {

		List<Document> review = new ArrayList<>();

		for (Document review1 : reviewGeneratorDAOImpl.getReviewByProductId(productId)) {
			review.add(review1);
		}

		return review;
	}

}
