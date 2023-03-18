package com.csse_we_26.reviewgenerator.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;




import com.csse_we_26.product_listing_generator.utils.MongoDBUtil;
import com.csse_we_26.reviewgenerator.dao.impl.ReviewGeneratorImplDAO;
import com.csse_we_26.reviewgenerator.dto.ReviewDTO;
import com.csse_we_26.reviewgenerator.mapper.ReviewMapper;
import com.csse_we_26.reviewgenerator.model.Review;
import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;


@Component(immediate = true)
public class ReviewGeneratorServiceImpl implements ReviewGeneratorService {
	private ReviewGeneratorImplDAO reviewGeneratorDAOImpl;
	private ReviewMapper mapper;
	public ReviewGeneratorServiceImpl() {
		reviewGeneratorDAOImpl= new ReviewGeneratorImplDAO(MongoDBUtil.getInstance().getDatabase(),"review");
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


	@Override
	public boolean addReview(com.csse_we_26.reviewgenerator.service.ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updateReview(com.csse_we_26.reviewgenerator.service.ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return false;
	}
	


}
