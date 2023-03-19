package com.csse_we_26.product_listing_generator.mapper;



import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.product_listing_generator.dto.ReviewDTO;
import com.csse_we_26.product_listing_generator.model.Product;

public class ProductMapper {

    public Product mapToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setRating(productDTO.getRating());

        return product;
    }

    public ProductDTO mapToProductDTO(Product product, List<Document> list) {
    	  ProductDTO productDTO =null;
    	  ReviewMapper mapper = new ReviewMapper();
    	
    	// list=null;
    	if(list !=null) {
    		
    		List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
    		System.out.println(list.toString());
    		try {
    			for (Object obj : list) {
    				  System.out.println(obj.getClass());
    				  
    			    if (obj instanceof Document) {
    			    	System.out.println(obj.getClass());
    			        Document doc = (Document) obj;
    			        System.out.println(doc.getClass());
    			        reviewList.add(mapper.mapToReviewDTO(doc));
    			    }
    			}
				  productDTO = new ProductDTO.Builder().
				        setRating(product.getRating()).setPrice(product.getPrice()).
				        setId(product.getId()).setCategory(product.getCategory()).
				        setDescription(product.getDescription()).
				        setName(product.getName()).setReviews(reviewList).build();
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
   

    public Document mapToDocument(Product product) {
        Document document = product.toDocument();

        return document;
    }

    public Product mapToProduct(Document document) {
        Product product = new Product(document);

		return product;
    }
}