package com.csse_we_26.reviewgenerator.dao;

import java.util.List;

import org.bson.Document;







public interface ReviewGeneratorDAO {


	public List<Document> getReviewByProductId(String productId);

}
