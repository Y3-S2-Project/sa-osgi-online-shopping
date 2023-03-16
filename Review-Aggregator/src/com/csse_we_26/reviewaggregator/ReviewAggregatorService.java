package com.csse_we_26.reviewaggregator;

import java.util.List;

import com.csse_we_26.reviewgenerator.Review;

public interface ReviewAggregatorService {

    List<Review> getReviewsForProduct(String productId);
    
    double getAverageRatingForProduct(String productId);
    
    List<Review> getReviewsByUser(String userId);
}
