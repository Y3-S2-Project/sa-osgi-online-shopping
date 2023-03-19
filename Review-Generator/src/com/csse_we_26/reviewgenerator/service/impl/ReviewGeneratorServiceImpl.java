package com.csse_we_26.reviewgenerator.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.csse_we_26.reviewgenerator.dao.impl.ReviewGeneratorImplDAO;
import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;

import mongodb_service.MongoService;
import mongodb_service.Review;
import mongodb_service.ReviewDTO;
import mongodb_service.ReviewMapper;


@Component(immediate = true)
public class ReviewGeneratorServiceImpl implements ReviewGeneratorService {
	private ReviewGeneratorImplDAO reviewGeneratorDAOImpl;
	private ReviewMapper mapper;
	public ReviewGeneratorServiceImpl(MongoService mongoService) {
		try {
			reviewGeneratorDAOImpl= new ReviewGeneratorImplDAO(mongoService.getDatabase(),"reviews");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Yeah I am here");;
		}
	    mapper = new ReviewMapper();
	}


	@Override
	public boolean addReview(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return reviewGeneratorDAOImpl.addReview(mapper.mapToReview(reviewDTO));
	}

	@Override
	public boolean updateReview(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return reviewGeneratorDAOImpl.updateReview(mapper.mapToReview(reviewDTO));
	}

	@Override
	public boolean deleteReview(String reviewId) {
		// TODO Auto-generated method stub
		return reviewGeneratorDAOImpl.deleteReview(reviewId);
	}

	@Override
	public List<ReviewDTO> getAllReviews() {
		// TODO Auto-generated method stub
		List<ReviewDTO> reviewDTO = new ArrayList<>();
		
		for(Review review : reviewGeneratorDAOImpl.getAllReviews() ) {
			reviewDTO.add(mapper.mapToReviewDTO(review));
		}
		
		return  reviewDTO;
	}
   public List<ReviewDTO> getReviewByProductId(String productId) {
	   
	    List<ReviewDTO> reviewDTO = new ArrayList<>();
		
		for(Review review : reviewGeneratorDAOImpl.getReviewByProductId(productId) ) {
			reviewDTO.add(mapper.mapToReviewDTO(review));
		}
		
		return  reviewDTO;
   }


	


}
