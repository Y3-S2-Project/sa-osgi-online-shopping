package com.csse_we_26.product_listing_generator.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.csse_we_26.product_listing_generator.dao.impl.ProductDAOImpl;
import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.product_listing_generator.mapper.ProductMapper;
import com.csse_we_26.product_listing_generator.model.Product;
import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;

import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;

import mongodb_service.MongoService;

public class ProductListingGeneratorImpl implements  ProductListingGenerator {
	private ProductDAOImpl productDAOImpl=null;
	private ProductMapper mapper;
	private ReviewGeneratorService reviewGeneratorService;
	public ProductListingGeneratorImpl(ReviewGeneratorService reviewGeneratorService, MongoService mongoService) {
		productDAOImpl= new ProductDAOImpl(mongoService.getDatabase(),"products");
		this.reviewGeneratorService=reviewGeneratorService;
	    mapper = new ProductMapper();
	}

	@Override
	public ProductDTO getProductById(String productId) {
		// TODO Auto-generated method stub
		
		return mapper.mapToProductDTO(productDAOImpl.getProductById(productId),reviewGeneratorService.getReviewByProductId(productId));
	}

	@Override
	public List<ProductDTO> getProductsByCategory(String category) {
	     List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product :productDAOImpl.getProductsByCategory(category)) {
			productDTOs.add(mapper.mapToProductDTO(product,reviewGeneratorService.getReviewByProductId(product.getId())));
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getProductsByPriceRange(double minPrice, double maxPrice) {
	    List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product :productDAOImpl.getProductsByPriceRange(minPrice, maxPrice)) {
			productDTOs.add(mapper.mapToProductDTO(product,reviewGeneratorService.getReviewByProductId(product.getId())));
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getProductsSortedByPrice() {
	    List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product :productDAOImpl.getProductsSortedByPrice()) {
			productDTOs.add(mapper.mapToProductDTO(product,reviewGeneratorService.getReviewByProductId(product.getId())));
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getProductsSortedByPopularity() {
	    List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product :productDAOImpl.getProductsSortedByPopularity()) {
			productDTOs.add(mapper.mapToProductDTO(product,reviewGeneratorService.getReviewByProductId(product.getId())));
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getProductsSortedByRating() {
	    List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product :productDAOImpl.getProductsSortedByRating()) {
			productDTOs.add(mapper.mapToProductDTO(product,reviewGeneratorService.getReviewByProductId(product.getId())));
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> searchProductsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		
		for(Product product :productDAOImpl.searchProductsByKeyword(keyword)) {
			productDTOs.add(mapper.mapToProductDTO(product,reviewGeneratorService.getReviewByProductId(product.getId())));
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getProductsByPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		productDAOImpl.addProduct(mapper.mapToProduct(productDTO));
	}



}
