package com.csse_we_26.reviewgenerator.dto;

public class ReviewDTO {
	private String id;
	private String productId;
	private String userId;
	private double rating;
	private String comment;

	public ReviewDTO(Builder builder) {
		this.id = builder.id;
		this.productId = builder.productId;
		this.userId = builder.userId;
		this.rating = builder.rating;
		this.comment = builder.comment;
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

	public static class Builder {
		private String id;
		private String productId;
		private String userId;
		private double rating;
		private String comment;

		public Builder() {}

		public Builder setId(String id) {
			this.id = id;
			return this;
		}

		public Builder setProductId(String productId) {
			this.productId = productId;
			return this;
		}

		public Builder setUserId(String userId) {
			this.userId = userId;
			return this;
		}

		public Builder setRating(double rating) {
			this.rating = rating;
			return this;
		}

		public Builder setComment(String comment) {
			this.comment = comment;
			return this;
		}

		public ReviewDTO build() {
			return new ReviewDTO(this);
		}
	}
}
