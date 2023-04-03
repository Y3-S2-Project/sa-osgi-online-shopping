package com.csse_we_26.product_listing_generator.mapper;



import java.util.List;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;

import com.csse_we_26.product_listing_generator.model.Product;
import com.csse_we_26.reviewgenerator.dto.ReviewDTO;
import com.csse_we_26.reviewgenerator.mapper.ReviewMapper;

public class ProductMapper {

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

    public static ProductDTO mapToProductDTO(Product product, List<ReviewDTO> list) {
    	  ProductDTO productDTO =null;
    	  ReviewMapper mapper = new ReviewMapper();
    	
     //list=null;
    	if(list !=null) {
    		

    	
    		try {
    	
				  productDTO = new ProductDTO.Builder().
				        setRating(product.getRating()).setPrice(product.getPrice()).
				        setId(product.getId()).setCategory(product.getCategory()).
				        setDescription(product.getDescription()).
				        setName(product.getName()).setReviews(list).build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else {
    		  productDTO = new ProductDTO.Builder().
      	            setRating(product.getRating()).setPrice(product.getPrice()).
      	            setId(product.getId()).setCategory(product.getCategory()).
      	            setDescription(product.getDescription()).
      	            setName(product.getName()).build();
    	}
    


        return productDTO;
    }
   

    public static Document mapToDocument(Product product) {
        Document document = product.toDocument();

        return document;
    }

    public static Product mapToProduct(Document document) {
 
        Product product = new Product(document);

   
		return product;
    }
}