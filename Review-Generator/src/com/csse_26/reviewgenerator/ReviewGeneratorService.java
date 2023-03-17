package com.csse_26.reviewgenerator;

import java.util.List;

public interface ReviewGeneratorService {
	
	public String ReviewGeneratorService();
	
	public boolean addReview(Review review);
	
	public boolean deleteReview(String reviewId);
	
	public boolean updateReview(Review review);
	
	public List<Review> getAllReviews();

}
