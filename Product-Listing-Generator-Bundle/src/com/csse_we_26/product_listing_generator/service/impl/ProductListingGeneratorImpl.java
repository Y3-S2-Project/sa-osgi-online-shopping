package com.csse_we_26.product_listing_generator.service.impl;

import java.util.ArrayList;
import java.util.List;



import com.csse_we_26.product_listing_generator.dao.impl.ProductDAOImpl;
import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.product_listing_generator.mapper.ProductMapper;
import com.csse_we_26.product_listing_generator.model.Product;
import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;
import com.csse_we_26.product_listing_generator.util.MongoDBUtil;
import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;




//This class is used to define the product listing generator implementation
public class ProductListingGeneratorImpl implements ProductListingGenerator {

	private ProductDAOImpl productDAOImpl=null;

	private ReviewGeneratorService reviewGeneratorService;

	public ProductListingGeneratorImpl(ReviewGeneratorService reviewGeneratorService) {
		
        
		productDAOImpl = new ProductDAOImpl(MongoDBUtil.getInstance().getDatabase(), "products");
		
		this.reviewGeneratorService=reviewGeneratorService;

	}
    //This method is used to get the product by id
	@Override
	public ProductDTO getProductById(String productId) {

		//System.out.println(reviewGeneratorService.getReviewByProductId(productId).toString());
		return ProductMapper.mapToProductDTO(productDAOImpl.getProductById(productId),reviewGeneratorService.getReviewByProductId(productId));
	}
    //This method is used to get the products by category
	@Override
	public List<ProductDTO> getProductsByCategory(String category) {
	     List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product :productDAOImpl.getProductsByCategory(category)) {
			productDTOs.add(ProductMapper.mapToProductDTO(product,reviewGeneratorService.getReviewByProductId(product.getId())));
		}
		return productDTOs;
	}
    //This method is used to get the products by price range
	@Override
	public List<ProductDTO> getProductsByPriceRange(double minPrice, double maxPrice) {
	    List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product :productDAOImpl.getProductsByPriceRange(minPrice, maxPrice)) {
			productDTOs.add(ProductMapper.mapToProductDTO(product,reviewGeneratorService.getReviewByProductId(product.getId())));
		}
		return productDTOs;
	}
    //This method is used to get the products sorted by price
	@Override
	public List<ProductDTO> getProductsSortedByPrice() {
	    List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product :productDAOImpl.getProductsSortedByPrice()) {
			productDTOs.add(ProductMapper.mapToProductDTO(product,reviewGeneratorService.getReviewByProductId(product.getId())));
		}
		return productDTOs;
	}


    //This method is used to get the products sorted by rating
	@Override
	public List<ProductDTO> getProductsSortedByRating() {
	    List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product :productDAOImpl.getProductsSortedByRating()) {
			productDTOs.add(ProductMapper.mapToProductDTO(product,reviewGeneratorService.getReviewByProductId(product.getId())));
		}
		return productDTOs;
	}
   //This method is used to search the products by keyword
	@Override
	public List<ProductDTO> searchProductsByKeyword(String keyword) {

		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product :productDAOImpl.searchProductsByKeyword(keyword)) {
			productDTOs.add(ProductMapper.mapToProductDTO(product,reviewGeneratorService.getReviewByProductId(product.getId())));
		}
		return productDTOs;
	}





}
