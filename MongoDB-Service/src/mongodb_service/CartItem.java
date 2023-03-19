package mongodb_service;

import org.bson.Document;



public class CartItem {
	
    private int quantity;
    private Product product;
    
    public CartItem() {}

    public CartItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
    
    public CartItem(Document document) {
    	this.quantity = document.getInteger("quantity");
    	this.product = (Product) document.get("product");
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
		Document document = new Document("quantity", quantity)
				.append("product", product);
		System.out.println("document" + document.toJson());
		return document;
	}
    
}
