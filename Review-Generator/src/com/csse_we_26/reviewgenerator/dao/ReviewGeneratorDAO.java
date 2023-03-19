package com.csse_we_26.reviewgenerator.dao;

import java.util.List;

import mongodb_service.Review;

public interface ReviewGeneratorDAO {

	List<Review> getAllReviews();

	boolean updateReview(Review review);

	boolean deleteReview(String reviewId);

	boolean addReview(Review review);
	public List<Review> getReviewByProductId(String productId);

}
