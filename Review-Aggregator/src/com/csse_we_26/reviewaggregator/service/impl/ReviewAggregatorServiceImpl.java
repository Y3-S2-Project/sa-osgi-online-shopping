package com.csse_we_26.reviewaggregator.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.csse_we_26.product_listing_generator.dto.ReviewDTO;
import com.csse_we_26.reviewaggregator.service.ReviewAggregatorService;
import com.csse_we_26.reviewgenerator.mapper.ReviewMapper;
import com.csse_we_26.reviewgenerator.model.Review;
import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;

public class ReviewAggregatorServiceImpl implements ReviewAggregatorService {
	
	private ReviewGeneratorService reviewGeneratorService;
	private ReviewMapper mapper;
	
	public ReviewAggregatorServiceImpl(ReviewGeneratorService reviewGeneratorService) {
		this.reviewGeneratorService = reviewGeneratorService;
		mapper = new ReviewMapper();
	}

	@Override
	public List<Review> getReviewsForProduct(String productId) {
		List<ReviewDTO> allReviews = reviewGeneratorService.getAllReviews();
		List<Review> reviewsForProduct = new ArrayList<Review>();
		 
		for (ReviewDTO reviewDTO : allReviews) {
			if (reviewDTO.getProductId().equals(productId)) {
			
				reviewsForProduct.add(mapper.mapToReview(reviewDTO));
			}
		}
		
		return reviewsForProduct;
	}

	@Override
	public double getAverageRatingForProduct(String productId) {
		List<Review> reviewsForProduct = getReviewsForProduct(productId);
		
		if (reviewsForProduct.isEmpty()) {
			return 0;
		}
		
		double sum = 0;
		
		for (Review review : reviewsForProduct) {
			sum += review.getRating();
		}
		
		return sum / reviewsForProduct.size();
	}

	@Override
	public List<Review> getReviewsByUser(String userId) {
		
		List<ReviewDTO> allReviews = reviewGeneratorService.getAllReviews();
		List<Review> reviewsByUser = new ArrayList<Review>();
		
		for (ReviewDTO reviewDTO : allReviews) {
			if (reviewDTO.getUserId().equals(userId)) {
				
				reviewsByUser.add(mapper.mapToReview(reviewDTO));
			}
		}
		
		return reviewsByUser;
	}

}

