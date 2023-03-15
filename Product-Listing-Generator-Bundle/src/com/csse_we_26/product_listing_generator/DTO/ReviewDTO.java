package com.csse_we_26.product_listing_generator.DTO;

public class ReviewDTO {
	private String id;
	private String productId;
	private String userId;
	private double rating;
	private String comment;

	public ReviewDTO(ReviewBuilder builder) {
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

	public static class ReviewBuilder {
		private String id;
		private String productId;
		private String userId;
		private double rating;
		private String comment;

		public ReviewBuilder() {}

		public ReviewBuilder setId(String id) {
			this.id = id;
			return this;
		}

		public ReviewBuilder setProductId(String productId) {
			this.productId = productId;
			return this;
		}

		public ReviewBuilder setUserId(String userId) {
			this.userId = userId;
			return this;
		}

		public ReviewBuilder setRating(double rating) {
			this.rating = rating;
			return this;
		}

		public ReviewBuilder setComment(String comment) {
			this.comment = comment;
			return this;
		}

		public ReviewDTO build() {
			return new ReviewDTO(this);
		}
	}
}
