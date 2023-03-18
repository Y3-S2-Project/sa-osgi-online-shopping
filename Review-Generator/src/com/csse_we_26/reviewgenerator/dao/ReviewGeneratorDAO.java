package com.csse_we_26.reviewgenerator.dao;

import java.util.List;

import com.csse_we_26.reviewgenerator.model.Review;

public interface ReviewGeneratorDAO {

	List<Review> getAllReviews();

	boolean updateReview(Review review);

	boolean deleteReview(String reviewId);

	boolean addReview(Review review);

}