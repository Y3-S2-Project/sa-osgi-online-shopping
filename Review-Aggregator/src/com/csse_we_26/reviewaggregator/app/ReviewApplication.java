package com.csse_we_26.reviewaggregator.app;

import java.util.List;
import java.util.Scanner;

import com.csse_we_26.product_listing_generator.mapper.ProductMapper;
import com.csse_we_26.product_listing_generator.model.Product;
import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;
import com.csse_we_26.reviewaggregator.ReviewAggregatorService;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.csse_we_26.reviewgenerator.*;
import com.csse_we_26.reviewgenerator.model.Review;

public class ReviewApplication {

	private static ReviewAggregatorService reviewAggregatorService;
	
	public ReviewApplication(ReviewAggregatorService reviewAggregatorService) {
		this.reviewAggregatorService = reviewAggregatorService;
	}

	public static void getUserGUI() {

		boolean isContinuing = true;

//	    for (int i=0; i<reviews.size(); i++) {
//	        System.out.println(reviews.get(i).getComment());
//	    }

	    System.out.println("=================================================================");
	    System.out.println("PROCESS STARTING");
	    System.out.println("=================================================================");
		
		while (isContinuing) {
            // Prompt the user to select an action to perform
            System.out.println("What would you like to do?");
            System.out.println("1. View reviews for a product");
            System.out.println("2. Get average rating for a product");
            System.out.println("3. Get reviews for a particular user");
            System.out.println("4. Add review for a product");
            System.out.println("5. Delete review for a product");
            System.out.println("6. Update review for a product");
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
                    List<Review> reviews = reviewAggregatorService.getReviewsForProduct(productId);

                    // Display the reviews to the user
                    System.out.println("******************The list of reviews for product ID " + productId + "******************");
                    System.out.println("");
                    reviewAggregatorService.getProduct(productId);
                    if(reviews!=null) {
                        for (Review review : reviews) {
                            System.out.println("         ****" + review.getComment());
                        }
                    }else {
                    	System.out.println("No reviews for product ID "+ productId);
                    }

                    break;

                case 2:
                    // Get input from the user
                    System.out.print("Enter the product ID: ");
                    productId = scanner.nextLine();
                    
                    System.out.println("");

                    // Call the method in ReviewAggregatorService to get the average rating for the product ID
                    double averageRating = reviewAggregatorService.getAverageRatingForProduct(productId);
                    
                    //Call method Product listing generator
//                    String productName = re

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
                    System.out.print("Enter the review ID: ");
                    String reviewId = scanner.nextLine();
                	
                    // Get input from the user
                    System.out.print("Enter the product ID: ");
                    productId = scanner.nextLine();

                    System.out.print("Enter the user ID: ");
                    userId = scanner.nextLine();

                    // Get input from the user
                    System.out.print("Enter the comment: ");
                    String comment = scanner.nextLine();

                    System.out.print("Enter the rating: ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    // Create a new Review object with the user input
                    Review review = new Review(reviewId,productId, userId, rating, comment);

                    // Call the method in ReviewAggregatorService to add the review
                    reviewAggregatorService.addReview(review);

                    System.out.println("Review added successfully!");

                    break;

                case 5:
                    // Get input from the user
                    System.out.print("Enter the review ID: ");
                    String rId = scanner.nextLine();

                    // Call the method in ReviewAggregatorService to delete the review
                    boolean isDeleted = reviewAggregatorService.deleteReview(rId);

                    if (isDeleted) {
                        System.out.println("Review deleted successfully!");
                    } else {
                        System.out.println("Review not found.");
                    }

                    break;

                case 6:
                	// Get input from the user
                    System.out.print("Enter the review ID: ");
                    reviewId = scanner.nextLine();
                	
                    // Get input from the user
                    System.out.print("Enter the product ID: ");
                    productId = scanner.nextLine();

                    System.out.print("Enter the user ID: ");
                    userId = scanner.nextLine();

                    // Get input from the user
                    System.out.print("Enter the new comment: ");
                    comment = scanner.nextLine();

                    System.out.print("Enter the new rating: ");
                    rating = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    // Create a new Review object with the user input
                    Review updateReview = new Review(reviewId,productId, userId, rating, comment);

                    // Call the method in ReviewAggregatorService to update the review
                    boolean isUpdated = reviewAggregatorService.updateReview(updateReview);

                    if (isUpdated) {
                        System.out.println("Review updated successfully!");
                    } else {
                        System.out.println("Review not found.");
                    }

                    break;


                case 7:
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
