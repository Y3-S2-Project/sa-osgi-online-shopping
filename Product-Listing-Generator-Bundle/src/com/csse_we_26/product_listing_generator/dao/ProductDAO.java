package com.csse_we_26.product_listing_generator.dao;

import java.util.List;

import com.csse_we_26.product_listing_generator.model.Product;







//This interface is used to define the methods that are used to get the products from the database
public interface ProductDAO {
    

    
    public Product getProductById(String id);
    
    public List<Product> getProductsByCategory(String category);
    
    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice);
    
    public List<Product> getProductsSortedByPrice();
    
    public List<Product> getProductsSortedByRating();
    
    public List<Product> searchProductsByKeyword(String keyword);
    


}
