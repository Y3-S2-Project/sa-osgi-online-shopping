package com.csse_we_26.reviewgenerator.service;

import java.util.List;

import org.bson.Document;









public interface ReviewGeneratorService {
	

	public List<Document> getReviewByProductId(String productId);

}
