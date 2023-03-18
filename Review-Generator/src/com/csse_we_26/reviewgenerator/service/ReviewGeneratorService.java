package com.csse_we_26.reviewgenerator.service;

import java.util.List;

import com.csse_we_26.reviewgenerator.model.Review;

public interface ReviewGeneratorService {
	
	public String ReviewGeneratorService();
	
	public boolean addReview(Review review);
	
	public boolean deleteReview(String reviewId);
	
	public boolean updateReview(Review review);
	
	public List<Review> getAllReviews();

}
