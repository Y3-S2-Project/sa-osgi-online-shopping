package com.csse_we_26.reviewaggregator.service;

import java.util.List;

import com.csse_we_26.reviewgenerator.model.Review;

public interface ReviewAggregatorService {

    List<Review> getReviewsForProduct(String productId);
    
    double getAverageRatingForProduct(String productId);
    
    List<Review> getReviewsByUser(String userId);
}
