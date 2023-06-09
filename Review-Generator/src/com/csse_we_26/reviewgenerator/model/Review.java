package com.csse_we_26.reviewgenerator.model;

import org.bson.Document;
import org.bson.types.ObjectId;


public class Review {
	

	private ObjectId _id;
	private String reviewId;
	private String productId;
	private String userId;
	private double rating;
	private String comment;
    public Review() {
	  
    }
	public Review(ObjectId _id, String productId,String userId, double rating, String comment) {
		
		this._id = _id;
		this.productId = productId;
		this.userId =userId;
		this.rating = rating;
		this.comment =comment;
	}
	
	public Review(Document doc) {
		// TODO Auto-generated constructor stub
		  this.reviewId= doc.getString("reviewId");
	      this.productId = doc.getString("productId");
	      this.userId = doc.getString("userId");
	      this.rating = doc.getDouble("rating");
	      this.comment = doc.getString("comment");
	}

	
	public Review(String _id, String productId,String userId, double rating, String comment) {
		// TODO Auto-generated constructor stub
		this.setId(_id);
		this.productId = productId;
		this.userId =userId;
		this.rating = rating;
		this.comment =comment;
	}
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Document toDocument() {
		// TODO Auto-generated method stub
		Document doc = new Document("productId", this.productId).append("userId", this.userId)
				.append("rating", this.rating)
				.append("comment", this.comment).append("reviewId", this.reviewId);
	        if (_id != null) {
	            doc.append("id",this._id);
	      
	        }
	    return doc;

	}

	public String getId() {
		return reviewId;
	}
	public void setId(String reviewId) {
		this.reviewId = reviewId;
	} 
}
