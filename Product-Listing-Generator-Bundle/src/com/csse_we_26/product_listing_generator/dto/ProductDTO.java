package com.csse_we_26.product_listing_generator.dto;

import java.util.List;
import java.util.Map;



public class ProductDTO {
    private String pid;
    private String name;
    private String description;
    private String category;
    private double price;
    private double rating;
    
    private List<String> images;
    private Map<String, String> specs;
    private List<ReviewDTO> reviewDTOs;

    private ProductDTO(Builder builder) {
        this.pid = builder.pid;
        this.name = builder.name;
        this.description = builder.description;
        this.category = builder.category;
        this.price = builder.price;
        this.rating = builder.rating;

        this.images = builder.images;
        this.specs = builder.specs;
        this.reviewDTOs = builder.reviewDTOs;
    }

    public String getId() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }



    public List<String> getImages() {
        return images;
    }

    public Map<String, String> getSpecs() {
        return specs;
    }

    public List<ReviewDTO> getReviews() {
        return reviewDTOs;
    }

    public static class Builder {
        private String pid;
        private String name;
        private String description;
        private String category;
        private double price;
        private double rating;

        private List<String> images;
        private Map<String, String> specs;
        private List<ReviewDTO> reviewDTOs;

        public Builder() {}

        public Builder setId(String id) {
            this.pid = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setRating(double rating) {
            this.rating = rating;
            return this;
        }


        public Builder setImages(List<String> images) {
            this.images = images;
            return this;
        }

        public Builder setSpecs(Map<String, String> specs) {
            this.specs = specs;
            return this;
        }

        public Builder setReviews(List<ReviewDTO> list) {
            this.reviewDTOs = list;
            return this;
        }

        public ProductDTO build() {
            return new ProductDTO(this);
        }
    }


}
