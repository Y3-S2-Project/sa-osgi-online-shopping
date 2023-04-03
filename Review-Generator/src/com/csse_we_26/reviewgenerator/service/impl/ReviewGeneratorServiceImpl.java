package com.csse_we_26.reviewgenerator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.csse_we_26.reviewgenerator.dao.impl.ReviewGeneratorImplDAO;
import com.csse_we_26.reviewgenerator.dto.ReviewDTO;
import com.csse_we_26.reviewgenerator.mapper.ReviewMapper;
import com.csse_we_26.reviewgenerator.model.Review;
import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;
import com.csse_we_26.reviewgenerator.util.MongoDBUtil;



public class ReviewGeneratorServiceImpl implements ReviewGeneratorService {
	private ReviewGeneratorImplDAO reviewGeneratorDAOImpl;


	public ReviewGeneratorServiceImpl() {
		try {
						
		// Print the database name 
		System.out.println("Connected to mongodb");
		System.out.println(MongoDBUtil.getInstance().getDatabase().getName());
		reviewGeneratorDAOImpl = new ReviewGeneratorImplDAO( MongoDBUtil.getInstance().getDatabase() , "reviews");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
	}



	public List<ReviewDTO> getReviewByProductId(String productId) {

		List<ReviewDTO> reviews = new ArrayList<>();

		for (Review review : reviewGeneratorDAOImpl.getReviewByProductId(productId)) {
			reviews.add(ReviewMapper.mapToReviewDTO(review));
		}

		return reviews;
	}



	@Override
	public List<ReviewDTO> getAllReviews() {
		// TODO Auto-generated method stub
		List<ReviewDTO> reviews = new ArrayList<>();

		for (Review review : reviewGeneratorDAOImpl.getAllReviews()) {
			reviews.add(ReviewMapper.mapToReviewDTO(review));
		}

		return reviews;
	}



	@Override
	public boolean updateReview(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		
		return reviewGeneratorDAOImpl.updateReview(ReviewMapper.mapToReview(reviewDTO));
	}



	@Override
	public boolean deleteReview(String reviewId) {
		// TODO Auto-generated method stub
		return reviewGeneratorDAOImpl.deleteReview(reviewId);
	}



	@Override
	public boolean addReview(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return reviewGeneratorDAOImpl.addReview(ReviewMapper.mapToReview(reviewDTO));
	}

}
