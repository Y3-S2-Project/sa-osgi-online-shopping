package com.csse_we_26.product_display.view;

import java.util.List;
import java.util.Scanner;

import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;




public class ProductListingDisplay {
    
    private final ProductView productView;
    
    public ProductListingDisplay(ProductListingGenerator productListingGenerator) {
        this.productView = new ProductView();
        this.productView.setProductListingGenerator(productListingGenerator);
    }
    
    public void displayProductById(String productId) {
        productView.displayProductById(productId);
    }
    public void searchProductsByKeyword(String keyword) {
    	productView.searchProductsByKeyword(keyword);
    }
    public void displayProductsByCategory(String category) {
        productView.displayProductsByCategory(category);
    }
    
    public void displayProductsByPriceRange(double minPrice, double maxPrice) {
        productView.displayProductsByPriceRange(minPrice, maxPrice);
    }
    
    public void displayProductsSortedByPrice() {
        productView.displayProductsSortedByPrice();
    }
    
    public void displayProductsSortedByRating() {
    	productView.displayProductsSortedByRating();
    }


    public void dipalyUI() {
    	boolean isContinuing = true;

	    System.out.println("=================================================================");
	    System.out.println("PROCESS STARTING");
	    System.out.println("=================================================================");
		
		while (isContinuing) {
            // Prompt the user to select an action to perform
            System.out.println("What would you like to do?");
            System.out.println("1. View a product by  product Id");
            System.out.println("2. Search Product by keyword");
            System.out.println("3. Search product by category");
            System.out.println("4. Sort product by price range");
            System.out.println("5. Sort product by price");
            System.out.println("6. Sort product by rating");
            System.out.println("7. Quit");
            
            System.out.println("");

            // Read the user's choice
            System.out.print("Enter your choice (1-7): ");
            Scanner scanner= new Scanner(System.in);
			int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character


            switch (choice) {
                case 1:
                    // Get input from the user
                    System.out.print("Enter the product ID: ");
                    String productId = scanner.nextLine();

                    // Call the method in ReviewAggregatorService to get the reviews for the product ID
                    displayProductById(productId);

                    break;

                case 2:
                    // Get input from the user
                    System.out.print("Enter a keyword: ");
                    String keyword = scanner.nextLine();
                    
                    System.out.println("");
                     
                    searchProductsByKeyword(keyword);

                    break;

                case 3:
                    // Get input from the user
                    System.out.print("Enter the category: ");
                    String category = scanner.nextLine();

                    displayProductsByCategory(category);
                    break;
                case 4:
                    // Get input from the user
                    System.out.print("Enter the min price and max price ranges (EX :-  90 95 ): ");
                    String input = scanner.nextLine();
                    
                 // Split the input string into two substrings using the split() method
                    String[] parts = input.split(" ");
                    
                    // Convert the two substrings into double values using the Double.parseDouble() method
                    double minPrice = Double.parseDouble(parts[0]);
                    double maxPrice = Double.parseDouble(parts[1]);
                    displayProductsByPriceRange(minPrice,maxPrice);

                    break;
                case 5:
  
                    displayProductsSortedByPrice();

                    break;
                case 6:
                    displayProductsSortedByRating();
                    
                    break;    

                case 7 :
                    isContinuing = false;

                    break;

                default:
                    System.out.println("Invalid choice, please try again.");

                    break;
            }
            System.out.println("=========================================================================");
        }
		
		System.out.println("PROCESS ENDED");
	    
	    System.out.println("=========================================================================");
    }
}
