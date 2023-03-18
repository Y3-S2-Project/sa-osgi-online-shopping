package com.csse_we_26.reviewaggregator.app;

import java.util.List;
import java.util.Scanner;

import com.csse_we_26.reviewaggregator.service.ReviewAggregatorService;
import com.csse_we_26.reviewgenerator.model.Review;

public class ReviewApplication {

	private static ReviewAggregatorService reviewAggregatorService;
	
	public ReviewApplication(ReviewAggregatorService reviewAggregatorService) {
		this.reviewAggregatorService = reviewAggregatorService;
	}

	public static void getUserGUI() {

		boolean isContinuing = true;

	    System.out.println("=================================================================");
	    System.out.println("PROCESS STARTING");
	    System.out.println("=================================================================");
		
		while (isContinuing) {
            // Prompt the user to select an action to perform
            System.out.println("What would you like to do?");
            System.out.println("1. View reviews for a product");
            System.out.println("2. Get average rating for a product");
            System.out.println("3. Get reviews for a particular user");
            System.out.println("4. Quit");
            
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
