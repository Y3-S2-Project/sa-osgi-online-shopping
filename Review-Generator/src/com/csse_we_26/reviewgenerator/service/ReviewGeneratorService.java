package com.csse_we_26.reviewgenerator.service;

import java.util.List;

import org.bson.Document;

import com.csse_we_26.reviewgenerator.dto.ReviewDTO;
import com.csse_we_26.reviewgenerator.model.Review;









public interface ReviewGeneratorService {
	

	public List<ReviewDTO> getReviewByProductId(String productId);
	public List<ReviewDTO> getAllReviews();

	public boolean updateReview(ReviewDTO reviewDTO);

	public boolean deleteReview(String reviewId);

	public boolean addReview(ReviewDTO reviewDTO);

}
