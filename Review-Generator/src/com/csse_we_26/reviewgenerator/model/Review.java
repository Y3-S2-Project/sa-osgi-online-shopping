package com.csse_we_26.reviewgenerator.model;

import org.bson.Document;


public class Review {
	
	private String id;
	private String productId;
	private String userId;
	private double rating;
	private String comment;
    public Review() {
	  
    }
	public Review(String id, String productId,String userId, double rating, String comment) {
		
		this.id = id;
		this.productId = productId;
		this.userId =userId;
		this.rating = rating;
		this.comment =comment;
	}
	
	public Review(Document doc) {
		// TODO Auto-generated constructor stub
		 this.id = doc.getString("id");
	        this.productId = doc.getString("productId");
	        this.userId = doc.getString("userId");
	        this.rating = doc.getDouble("rating");
	        this.comment = doc.getString("comment");
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
				.append("comment", this.comment);
	        if (id != null) {
	            doc.append("id",this.id);
	      
	        }
	    return doc;

	} 
}
