package com.csse_we_26.product_display.view;

import java.util.List;

import com.csse_we_26.product_listing_generator.dto.ProductDTO;
import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;
import com.csse_we_26.reviewgenerator.dto.ReviewDTO;


//Prompt the user to select an action to perform
public class ProductView {

    private ProductListingGenerator productListingGenerator;

    public void setProductListingGenerator(ProductListingGenerator productListingGenerator) {
        this.productListingGenerator = productListingGenerator;
    }
    //View a product by  product Id
    public void displayProductById(String productId) {
        ProductDTO product = productListingGenerator.getProductById(productId);
        if (product != null) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Description: " + product.getDescription());
            System.out.println("Product Price: " + product.getPrice());
            System.out.println("Product Rating: " + product.getRating());
     
            System.out.println("Product Category: " + product.getCategory());
            List<ReviewDTO> reviewDTOS =product.getReviews();
            if(reviewDTOS!=null ) {
            	 System.out.print("Product reviews: [ ");
            	    for(ReviewDTO reviewDTO :reviewDTOS ) {
            	    	  
                    	System.out.print("[ User : "+ reviewDTO.getUserId()+ ", ");
                    	System.out.print("Comment : "+ reviewDTO.getComment()+", ");
                    	System.out.print("Rating : "+ reviewDTO.getRating()+" ] , ");

                    }
                    System.out.println(" ]");
            }else {
            	 System.out.print("Product reviews: No reviewes");
            }
        
        } else {
            System.out.println("Product not found: " + productId);
        }
    }
    //Search Product by keyword
    public void displayProductsByCategory(String category) {
        List<ProductDTO> products = productListingGenerator.getProductsByCategory(category);
        if (products.isEmpty()) {
            System.out.println("No products found in category: " + category);
        } else {
            System.out.println("Products in category " + category + ":");
            System.out.println("");
            for (ProductDTO product : products) {
                System.out.println(product.getName() + " (" + product.getPrice() + ")");
            }
        }
    }
    //Search product by category
    public void displayProductsByPriceRange(double minPrice, double maxPrice) {
        List<ProductDTO> products = productListingGenerator.getProductsByPriceRange(minPrice, maxPrice);
        if (products.isEmpty()) {
            System.out.println("No products found in price range: " + minPrice + " - " + maxPrice);
        } else {
            System.out.println("Products in price range " + minPrice + " - " + maxPrice + ":");
            System.out.println("");
            for (ProductDTO product : products) {
                System.out.println(product.getName() + " (" + product.getPrice() + ")");
            }
        }
    }
    //Display all products
    public void displayProductsSortedByPrice() {
        List<ProductDTO> products = productListingGenerator.getProductsSortedByPrice();
        if (products.isEmpty()) {
            System.out.println("No products found");
        } else {
            System.out.println("Products sorted by price:");
            System.out.println("");
            for (ProductDTO product : products) {
                System.out.println(product.getName() + " (" + product.getPrice() + ")");
            }
        }
    }

  //Display all products
    public void displayProductsSortedByRating() {
        List<ProductDTO> products = productListingGenerator.getProductsSortedByRating();
        if (products.isEmpty()) {
            System.out.println("No products found");
        } else {
            System.out.println("Products sorted by rating:");
            System.out.println("");
            for (ProductDTO product : products) {
                System.out.println(product.getName() + " (" + product.getRating() + ")");
            }
        }
    }
   //Display all products
    public void searchProductsByKeyword(String keyword) {
        List<ProductDTO> products = productListingGenerator.searchProductsByKeyword(keyword);
        if (products.isEmpty()) {
            System.out.println("No products found for keyword: " + keyword);
        } else {
            System.out.println("Products found for keyword: " + keyword);
            System.out.println("");
            for (ProductDTO product : products) {
                System.out.println("Product Name: " + product.getName());
                System.out.println("Product Description: " + product.getDescription());
                System.out.println("Product Price: " + product.getPrice());
                System.out.println("Product Rating: " + product.getRating());
            }
        }
    }


}
