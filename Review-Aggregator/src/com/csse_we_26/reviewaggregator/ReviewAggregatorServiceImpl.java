package com.csse_we_26.reviewaggregator;

import java.util.ArrayList;
import java.util.List;

import com.csse_we_26.reviewgenerator.Review;
import com.csse_we_26.reviewgenerator.ReviewGeneratorService;

public class ReviewAggregatorServiceImpl implements ReviewAggregatorService {
	
	private ReviewGeneratorService reviewGeneratorService;
	
	public ReviewAggregatorServiceImpl(ReviewGeneratorService reviewGeneratorService) {
		this.reviewGeneratorService = reviewGeneratorService;
	}

	@Override
	public List<Review> getReviewsForProduct(String productId) {
		List<Review> allReviews = reviewGeneratorService.getAllReviews();
		List<Review> reviewsForProduct = new ArrayList<Review>();
		
		for (Review review : allReviews) {
			if (review.getProductId().equals(productId)) {
				reviewsForProduct.add(review);
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
		List<Review> allReviews = reviewGeneratorService.getAllReviews();
		List<Review> reviewsByUser = new ArrayList<Review>();
		
		for (Review review : allReviews) {
			if (review.getUserId().equals(userId)) {
				reviewsByUser.add(review);
			}
		}
		
		return reviewsByUser;
	}
}

