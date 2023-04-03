package com.csse_we_26.reviewgenerator.dao;

import java.util.List;



import com.csse_we_26.reviewgenerator.model.Review;







public interface ReviewGeneratorDAO {


	public List<Review> getReviewByProductId(String productId);

	public List<Review> getAllReviews();

	 public boolean updateReview(Review review);

	public boolean deleteReview(String reviewId);

	public boolean addReview(Review review);

}
