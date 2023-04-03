package com.csse_we_26.product_listing_generator.service;
import java.util.List;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;








//This interface is used to define the methods that are used to get the products from the database
public interface ProductListingGenerator {

    ProductDTO getProductById(String productId);
    List<ProductDTO> getProductsByCategory(String category);
    List<ProductDTO> getProductsByPriceRange(double minPrice, double maxPrice);
    List<ProductDTO> getProductsSortedByPrice();
    List<ProductDTO> getProductsSortedByRating();
    List<ProductDTO> searchProductsByKeyword(String keyword);



}
