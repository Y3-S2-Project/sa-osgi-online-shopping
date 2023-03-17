package com.csse_we_26.product_display.view;

import java.util.List;
import java.util.Scanner;

import com.csse_we_26.product_listing_generator.DTO.ProductDTO;
import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;
import com.csse_we_26.reviewgenerator.Review;

public class ProductListingDisplay {
    
    private final ProductView productView;
    
    public ProductListingDisplay(ProductListingGenerator productListingGenerator) {
        this.productView = new ProductView();
        this.productView.setProductListingGenerator(productListingGenerator);
    }
    
    public void displayProductById(String productId) {
        productView.displayProductById(productId);
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

    public void searchProductsByKeyword(String keyword) {
    	productView.searchProductsByKeyword( keyword);
    }

    public void displayProductsByPage(int pageNum, int pageSize) {
    	productView.displayProductsByPage(pageNum,pageSize);
    }
    public void dipalyUI() {
    	boolean isContinuing = true;

	    System.out.println("=================================================================");
	    System.out.println("PROCESS STARTING");
	    System.out.println("=================================================================");
		
		while (isContinuing) {
            // Prompt the user to select an action to perform
            System.out.println("What would you like to do?");
            System.out.println("1. View a product");
            System.out.println("2. Sort product with category");
            System.out.println("3. Sort Product By Price Range");
            System.out.println("4. Sort Product By Price");
            System.out.println("5. Sort Product By Rating");
            System.out.println("6. Sort Product By Keyword");
            System.out.println("7. Sort Product By Page");
            System.out.println("8. Quit");
            
            System.out.println("");

            // Read the user's choice
            System.out.print("Enter your choice (1-4): ");
            Scanner scanner= new Scanner(System.in);
			int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character


            switch (choice) {
                case 1:
                    // Get input from the user
                    System.out.print("Enter the product ID: ");
                    String productId = scanner.nextLine();

                    // Call the method in ReviewAggregatorService to get the reviews for the product ID
                    List<Review> reviews = reviewAggregatorService.getReviewsForProduct(productId);

                    // Display the reviews to the user
                    System.out.println("******************The list of reviews for product ID " + productId + "******************");
                    System.out.println("");
                    
                    for (Review review : reviews) {
                        System.out.println("         ****" + review.getComment());
                    }

                    break;

                case 2:
                    // Get input from the user
                    System.out.print("Enter the product ID: ");
                    productId = scanner.nextLine();
                    
                    System.out.println("");

                    // Call the method in ReviewAggregatorService to get the average rating for the product ID
                    double averageRating = reviewAggregatorService.getAverageRatingForProduct(productId);

                    // Display the average rating to the user
                    System.out.println("****************The average rating for product ID " + productId + " is " + averageRating+"****************");
                    System.out.println("");

                    break;

                case 3:
                    // Get input from the user
                    System.out.print("Enter the user ID: ");
                    String userId = scanner.nextLine();

                    // Call the method in ReviewAggregatorService to get the reviews for the user ID
                    reviews = reviewAggregatorService.getReviewsByUser(userId);

                    // Display the reviews to the user
                    System.out.println("****************The list of reviews for user ID " + userId+" ****************");
                    for (Review review : reviews) {
                        System.out.println("         ****" + review.getComment());
                    }

                    break;
                case 4:
                    // Get input from the user
                    System.out.print("Enter the user ID: ");
                    String userId = scanner.nextLine();

                    // Call the method in ReviewAggregatorService to get the reviews for the user ID
                    reviews = reviewAggregatorService.getReviewsByUser(userId);

                    // Display the reviews to the user
                    System.out.println("****************The list of reviews for user ID " + userId+" ****************");
                    for (Review review : reviews) {
                        System.out.println("         ****" + review.getComment());
                    }

                    break;
                case 5:
                    // Get input from the user
                    System.out.print("Enter the user ID: ");
                    String userId = scanner.nextLine();

                    // Call the method in ReviewAggregatorService to get the reviews for the user ID
                    reviews = reviewAggregatorService.getReviewsByUser(userId);

                    // Display the reviews to the user
                    System.out.println("****************The list of reviews for user ID " + userId+" ****************");
                    for (Review review : reviews) {
                        System.out.println("         ****" + review.getComment());
                    }

                    break;
                case 6:
                    // Get input from the user
                    System.out.print("Enter the user ID: ");
                    String userId = scanner.nextLine();

                    // Call the method in ReviewAggregatorService to get the reviews for the user ID
                    reviews = reviewAggregatorService.getReviewsByUser(userId);

                    // Display the reviews to the user
                    System.out.println("****************The list of reviews for user ID " + userId+" ****************");
                    for (Review review : reviews) {
                        System.out.println("         ****" + review.getComment());
                    }

                    break;
                case 7:
                    // Get input from the user
                    System.out.print("Enter the user ID: ");
                    String userId = scanner.nextLine();

                    // Call the method in ReviewAggregatorService to get the reviews for the user ID
                    reviews = reviewAggregatorService.getReviewsByUser(userId);

                    // Display the reviews to the user
                    System.out.println("****************The list of reviews for user ID " + userId+" ****************");
                    for (Review review : reviews) {
                        System.out.println("         ****" + review.getComment());
                    }

                    break;     

                case 8 :
                    // Set isContinuing to false to exit the loop
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
