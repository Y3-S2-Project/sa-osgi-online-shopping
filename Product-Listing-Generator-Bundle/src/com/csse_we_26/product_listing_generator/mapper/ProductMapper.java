package com.csse_we_26.product_listing_generator.mapper;



import java.util.List;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;

import com.csse_we_26.product_listing_generator.model.Product;
import com.csse_we_26.reviewgenerator.dto.ReviewDTO;

//This class is used to define the product mapper
public class ProductMapper {
     //This method is used to map the product DTO to the product
    public static Product mapToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setRating(productDTO.getRating());

        return product;
    }
     //This method is used to map the product to the product DTO
    public static ProductDTO mapToProductDTO(Product product, List<ReviewDTO> list) {
        ProductDTO productDTO = null;
        
        
 
    	if(list !=null) {
    		
    		try {
    	          //Build the product DTO with the reviews
				  productDTO = new ProductDTO.Builder().
				        setRating(product.getRating()).setPrice(product.getPrice()).
				        setId(product.getId()).setCategory(product.getCategory()).
				        setDescription(product.getDescription()).
				        setName(product.getName()).setReviews(list).build();
			} catch (Exception e) {

				e.printStackTrace();
			}
        } else {
            //build the product DTO without the reviews
    		  productDTO = new ProductDTO.Builder().
      	            setRating(product.getRating()).setPrice(product.getPrice()).
      	            setId(product.getId()).setCategory(product.getCategory()).
      	            setDescription(product.getDescription()).
      	            setName(product.getName()).build();
    	}
    


        return productDTO;
    }
   
    //This method is used to map the product to the document
    public static Document mapToDocument(Product product) {
        //Convert the product to the document
        Document document = product.toDocument();
        //Return the document
        return document;
    }
    //This method is used to map the document to the product
    public static Product mapToProduct(Document document) {
        //Convert the document to the product
        Product product = new Product(document);
 
        //Return the product
		return product;
    }
}