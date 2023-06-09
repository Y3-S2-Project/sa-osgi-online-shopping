package com.csse_we_26.product_listing_generator.model;


import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.csse_we_26.reviewgenerator.model.Review;



//This class is used to define the product
public class Product {
	private ObjectId _id;
	private String pid;
    private String name;
    private String description;
    private String category;
    private double price;
    private double rating;

    private List<String> images;
    private Map<String, String> specs;
    private List<Review> reviews;
    

    public Product() {

    }
    //This constructor is used to create a product object from the user input
    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    //This constructor is used to create a product object from a document
    public Product(Document doc) {

        this._id = doc.getObjectId("_id");
        this.pid = doc.getString("pid");
        this.name = doc.getString("name");
        this.description = doc.getString("description");
        this.price = doc.getDouble("price");
        this.rating= doc.getDouble("rating");
        this.category=doc.getString("category");
    }
	public void setCategory(String category) {
		this.category = category;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}


    
    public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public Map<String, String> getSpecs() {
		return specs;
	}
	public void setSpecs(Map<String, String> specs) {
		this.specs = specs;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public String getCategory() {
		return category;
	}
	public double getRating() {
		return rating;
	}
	public void setPrice(double price) {
		this.price = price;
	}



    public String getId() {
        return pid;
    }

    public void setId(String id) {
        this.pid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
   //This method is used to convert a product object to a document
    public Document toDocument() {
        Document doc = new Document("name", name)
                .append("description", description)
                .append("price", price);
        if (pid != null) {
            doc.append("pid", pid);
      
        }
        return doc;
    }


}
