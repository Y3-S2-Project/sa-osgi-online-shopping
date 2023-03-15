package com.shopping.reviewaggregator;

import java.util.List;

import com.shopping.reviewgenerator.Review;

public interface ReviewAggregatorService {

    List<Review> getReviewsForProduct(String productId);
    
    double getAverageRatingForProduct(String productId);
    
    List<Review> getReviewsByUser(String userId);
}
