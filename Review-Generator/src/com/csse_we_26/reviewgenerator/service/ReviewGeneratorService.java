package com.csse_we_26.reviewgenerator.service;

import java.util.List;

import mongodb_service.ReviewDTO;




public interface ReviewGeneratorService {
	

	
	public boolean addReview(ReviewDTO reviewDTO);
	
	public boolean deleteReview(String reviewId);
	
	public boolean updateReview(ReviewDTO reviewDTO);
	
	public List<ReviewDTO> getAllReviews();
	public List<ReviewDTO> getReviewByProductId(String productId);

}
