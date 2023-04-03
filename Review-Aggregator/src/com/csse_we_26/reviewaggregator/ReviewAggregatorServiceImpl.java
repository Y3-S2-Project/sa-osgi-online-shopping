package com.csse_we_26.reviewaggregator;

import java.util.ArrayList;
import java.util.List;

import com.csse_we_26.product_listing_generator.mapper.ProductMapper;
import com.csse_we_26.product_listing_generator.model.Product;
import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;
import com.csse_we_26.reviewgenerator.dto.ReviewDTO;
import com.csse_we_26.reviewgenerator.mapper.ReviewMapper;
import com.csse_we_26.reviewgenerator.model.Review;
import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;




public class ReviewAggregatorServiceImpl implements ReviewAggregatorService {
	
	private ReviewGeneratorService reviewGeneratorService;
	private ProductListingGenerator productListingGenerator;
	
	public ReviewAggregatorServiceImpl(ReviewGeneratorService reviewGeneratorService, ProductListingGenerator productListingGenerator) {
		this.reviewGeneratorService = reviewGeneratorService;
		this.productListingGenerator = productListingGenerator;
	}

	@Override
	public List<Review> getReviewsForProduct(String productId) {
		List<ReviewDTO> allReviews = reviewGeneratorService.getAllReviews();
		List<Review> reviewsForProduct = new ArrayList<Review>();
		
		for (ReviewDTO review : allReviews) {
			if (review.getProductId().equals(productId)) {
				reviewsForProduct.add(ReviewMapper.mapToReview(review));
			}
		}
		
		return reviewsForProduct;
	}

	@Override
	public double getAverageRatingForProduct(String productId) {
		List<Review> reviewsForProduct = getReviewsForProduct(productId);
		
		if (reviewsForProduct.isEmpty()) {
			return 0;
		}
		
		double sum = 0;
		
		for (Review review : reviewsForProduct) {
			sum += review.getRating();
		}
		
		return sum / reviewsForProduct.size();
	}

	@Override
	public List<Review> getReviewsByUser(String userId) {
		List<ReviewDTO> allReviews = reviewGeneratorService.getAllReviews();
		List<Review> reviewsByUser = new ArrayList<Review>();
		
		for (ReviewDTO review : allReviews) {
			if (review.getUserId().equals(userId)) {
				reviewsByUser.add(ReviewMapper.mapToReview(review));
			}
		}
		
		return reviewsByUser;
	}
	
	@Override
	public void addReview(Review review) {

		reviewGeneratorService.addReview(ReviewMapper.mapToReviewDTO(review));
	}

	@Override
	public boolean deleteReview(String reviewId) {
		return reviewGeneratorService.deleteReview(reviewId);
	}

	@Override
	public boolean updateReview(Review review) {
		return reviewGeneratorService.updateReview(ReviewMapper.mapToReviewDTO(review));
	}

	@Override
	public void getProduct(String productId) {
		// TODO Auto-generated method stub
		Product product=(ProductMapper.mapToProduct(productListingGenerator.getProductById(productId)));
		try {

			System.out.println(">> Category : "+product.getCategory()+"<<");
			System.out.println(">> Name : "+product.getName()+"<<");
			System.out.println(">> Price : "+product.getPrice()+"<<");
			System.out.println("============================================");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}
	

}

