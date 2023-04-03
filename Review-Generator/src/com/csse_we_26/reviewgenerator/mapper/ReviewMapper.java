package com.csse_we_26.reviewgenerator.mapper;

import org.bson.Document;

import com.csse_we_26.reviewgenerator.dto.ReviewDTO;
import com.csse_we_26.reviewgenerator.model.Review;






public class ReviewMapper {
	   public static Review mapToReview(ReviewDTO reviewDTO) {
	        Review review = new Review();
	        review.setId(reviewDTO.getId());
	        review.setComment(reviewDTO.getComment());
	        review.setUserId(reviewDTO.getUserId());
	        review.setRating(reviewDTO.getRating());
	        review.setProductId(reviewDTO.getProductId());

	        return review;
	    }

	    public static ReviewDTO mapToReviewDTO(Review review) {
	        ReviewDTO reviewDTO = new ReviewDTO.Builder().setComment(review.getComment()).setProductId(review
	        .getProductId()).setRating(review.getRating()).setUserId(review.getUserId()).setId(review.getId()).build();
System.out.println("Mapped to dto");
	        return reviewDTO;
	    }
	   

	    public  static Document mapToDocument(Review review) {
	        Document document = review.toDocument();

	        return document;
	    }

	    public static Review mapToReview(Document document) {
	        Review review = new Review(document);

			return review;
	    }
	    public static ReviewDTO mapToReviewDTO(Document document) {
	   
	    	 Review review = new Review(document);
	    	 System.out.println("Doc to review");
	    	 return mapToReviewDTO(review);
	    }
}
