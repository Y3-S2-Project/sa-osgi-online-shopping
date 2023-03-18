package com.csse_we_26.product_listing_generator.service;
import java.util.List;

import com.csse_we_26.product_listing_generator.DTO.*;
public interface ProductListingGenerator {

    ProductDTO getProductById(String productId);
    List<ProductDTO> getProductsByCategory(String category);
    List<ProductDTO> getProductsByPriceRange(double minPrice, double maxPrice);
    List<ProductDTO> getProductsSortedByPrice();
    List<ProductDTO> getProductsSortedByPopularity();
    List<ProductDTO> getProductsSortedByRating();
    List<ProductDTO> searchProductsByKeyword(String keyword);
    List<ProductDTO> getProductsByPage(int pageNum, int pageSize);

}
