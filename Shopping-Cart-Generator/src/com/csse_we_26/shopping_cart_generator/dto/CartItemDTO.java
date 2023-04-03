package com.csse_we_26.shopping_cart_generator.dto;
import org.bson.Document;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.product_listing_generator.mapper.ProductMapper;
import com.csse_we_26.product_listing_generator.model.Product;



public class CartItemDTO {
	private int quantity;
	private ProductDTO product;
	
	public CartItemDTO(ProductDTO product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public CartItemDTO(Document document) {
		this.quantity = document.getInteger("quantity");


		Document doc = ((Document)document.get("product"));
		Product product= (ProductMapper.mapToProduct(doc));
	

		ProductDTO productDTO = new ProductDTO.Builder().
			        setRating(product.getRating()).setPrice(product.getPrice()).
			        setId(product.getId()).setCategory(product.getCategory()).
			        setDescription(product.getDescription()).
			        setName(product.getName()).build();
		

		this.product = productDTO ;
	}

	public CartItemDTO() {
		
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Document toDocument() {
		Document document = new Document("quantity", quantity)
				.append("product", product);
	
		return document;
	}
}
