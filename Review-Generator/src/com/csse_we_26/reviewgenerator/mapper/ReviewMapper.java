package com.csse_we_26.reviewgenerator.mapper;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.dto.ReviewDTO;
import com.csse_we_26.reviewgenerator.model.Review;



public class ReviewMapper {
	   public Review mapToReview(ReviewDTO reviewDTO) {
	        Review review = new Review();
	        review.setComment(reviewDTO.getComment());
	        review.setId(reviewDTO.getId());
	        review.setUserId(reviewDTO.getUserId());
	        review.setRating(reviewDTO.getRating());
	        review.setProductId(reviewDTO.getProductId());

	        return review;
	    }

	    public ReviewDTO mapToReviewDTO(Review review) {
	        ReviewDTO reviewDTO = new ReviewDTO.Builder().setComment(review.getComment()).setId(review.getId()).setProductId(review
	        .getProductId()).setRating(review.getRating()).setUserId(review.getUserId()).build();

	        return reviewDTO;
	    }
	   

	    public Document mapToDocument(Review review) {
	        Document document = review.toDocument();

	        return document;
	    }

	    public Review mapToReview(Document document) {
	        Review review = new Review(document);

			return review;
	    }
}
