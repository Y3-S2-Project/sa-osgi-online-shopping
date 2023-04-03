package com.csse_we_26.shopping_cart_generator.model;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.model.Product;



public class CartItem {
	
    private int quantity;
    private Product product;
    
    public CartItem() {

    }

    public CartItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
    
    public CartItem(Document document) {
      	try {
    	this.quantity = document.getInteger("quantity");
    	//Exception thrown if we just use product we need initialize it
    	this.product = new Product();
  
			this.product.setCategory(((Document)document.get("product")).getString("category"));
			this.product.setName(((Document)document.get("product")).getString("name"));
			this.product.setDescription(((Document)document.get("product")).getString("description"));
			this.product.setPrice(((Document)document.get("product")).getDouble("price"));
			this.product.setRating(((Document)document.get("product")).getDouble("rating"));
			this.product.setId(((Document)document.get("product")).getString("pid"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Document toDocument() {
		
		Document productDoc = new Document();
		productDoc.append("name",this.product.getName());
		productDoc.append("description",this.product.getDescription());
		productDoc.append("price",this.product.getPrice());
		productDoc.append("pid",this.product.getId());
		productDoc.append("category",this.product.getCategory());
		productDoc.append("rating",this.product.getRating());
		
		Document document = new Document("quantity", quantity)
				.append("product", productDoc);
         
		return document;
	}
    
}

