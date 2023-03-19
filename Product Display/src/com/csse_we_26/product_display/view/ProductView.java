package com.csse_we_26.product_display.view;

import java.util.List;

import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;

import mongodb_service.ProductDTO;

public class ProductView {

    private ProductListingGenerator productListingGenerator;

    public void setProductListingGenerator(ProductListingGenerator productListingGenerator) {
        this.productListingGenerator = productListingGenerator;
    }

    public void displayProductById(String productId) {
        ProductDTO product = productListingGenerator.getProductById(productId);
        if (product != null) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Description: " + product.getDescription());
            System.out.println("Product Price: " + product.getPrice());
            System.out.println("Product Rating: " + product.getRating());
     
            System.out.println("Product Category: " + product.getCategory());
            System.out.println("Product reviews"+ product.getReviews().toString());
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    public void displayProductsByCategory(String category) {
        List<ProductDTO> products = productListingGenerator.getProductsByCategory(category);
        if (products.isEmpty()) {
            System.out.println("No products found in category: " + category);
        } else {
            System.out.println("Products in category " + category + ":");
            for (ProductDTO product : products) {
                System.out.println(product.getName() + " (" + product.getPrice() + ")");
            }
        }
    }
    public void displayProductsByPriceRange(double minPrice, double maxPrice) {
        List<ProductDTO> products = productListingGenerator.getProductsByPriceRange(minPrice, maxPrice);
        if (products.isEmpty()) {
            System.out.println("No products found in price range: " + minPrice + " - " + maxPrice);
        } else {
            System.out.println("Products in price range " + minPrice + " - " + maxPrice + ":");
            for (ProductDTO product : products) {
                System.out.println(product.getName() + " (" + product.getPrice() + ")");
            }
        }
    }

    public void displayProductsSortedByPrice() {
        List<ProductDTO> products = productListingGenerator.getProductsSortedByPrice();
        if (products.isEmpty()) {
            System.out.println("No products found");
        } else {
            System.out.println("Products sorted by price:");
            for (ProductDTO product : products) {
                System.out.println(product.getName() + " (" + product.getPrice() + ")");
            }
        }
    }


    public void displayProductsSortedByRating() {
        List<ProductDTO> products = productListingGenerator.getProductsSortedByRating();
        if (products.isEmpty()) {
            System.out.println("No products found");
        } else {
            System.out.println("Products sorted by rating:");
            for (ProductDTO product : products) {
                System.out.println(product.getName() + " (" + product.getRating() + ")");
            }
        }
    }

    public void searchProductsByKeyword(String keyword) {
        List<ProductDTO> products = productListingGenerator.searchProductsByKeyword(keyword);
        if (products.isEmpty()) {
            System.out.println("No products found for keyword: " + keyword);
        } else {
            System.out.println("Products found for keyword: " + keyword);
            for (ProductDTO product : products) {
                System.out.println(product.getName());
            }
        }
    }

    public void displayProductsByPage(int pageNum, int pageSize) {
        List<ProductDTO> products = productListingGenerator.getProductsByPage(pageNum, pageSize);
        if (products.isEmpty()) {
            System.out.println("No products found");
        } else {
            System.out.println("Products on page " + pageNum + ", page size " + pageSize + ":");
            for (ProductDTO product : products) {
                System.out.println(product.getName() + " (" + product.getPrice() + ")");
            }
        }
    }
}
