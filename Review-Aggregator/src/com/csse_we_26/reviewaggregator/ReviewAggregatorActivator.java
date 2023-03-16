package com.csse_we_26.reviewaggregator;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.csse_we_26.reviewaggregator.app.ReviewApplication;
import com.csse_we_26.reviewgenerator.Review;
import com.csse_we_26.reviewgenerator.ReviewGeneratorService;

public class ReviewAggregatorActivator implements BundleActivator {

	private ReviewAggregatorService reviewAggregatorService;
	private ServiceReference<ReviewGeneratorService> reviewGeneratorServiceReference;
	// Get input from the user
	Scanner scanner = new Scanner(System.in);
	boolean isContinuing = true;
	
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Starting Review Aggregator bundle");
		
		// Get a reference to the ReviewGeneratorService
		reviewGeneratorServiceReference = context.getServiceReference(ReviewGeneratorService.class);
		ReviewGeneratorService reviewGeneratorService = context.getService(reviewGeneratorServiceReference);
		
		// Create a new instance of the ReviewAggregatorServiceImpl and pass in the ReviewGeneratorService reference
		reviewAggregatorService = new ReviewAggregatorServiceImpl(reviewGeneratorService);
		
		// Register the ReviewAggregatorService with the OSGi service registry
		context.registerService(ReviewAggregatorService.class, reviewAggregatorService, null);
		
		
//		Scanner scanner = new Scanner(System.in);
//	    System.out.print("Enter the product Id: ");
//	    String productId = scanner.nextLine();

//	    List<Review> reviews= reviewAggregatorService.getReviewsForProduct("1");
//	    System.out.println("=================================================================");
////	    System.out.println("The List of Reviews for product Id " + productId);
//
//	    for (int i=0; i<reviews.size(); i++) {
//	        System.out.println(reviews.get(i).getComment());
//	    }
//
//	    System.out.println("=================================================================");
//	    System.out.println("PROCESS STARTING");
//	    System.out.println("=================================================================");
//
////	    scanner.close();
//		
//		while (isContinuing) {
//            // Prompt the user to select an action to perform
//            System.out.println("What would you like to do?");
//            System.out.println("1. View reviews for a product");
//            System.out.println("2. Get average rating for a product");
//            System.out.println("3. Get reviews for a particular user");
//            System.out.println("4. Quit");
//            
//            System.out.println("");
//
//            // Read the user's choice
//            System.out.print("Enter your choice (1-4): ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline character
//
//
//            switch (choice) {
//                case 1:
//                    // Get input from the user
//                    System.out.print("Enter the product ID: ");
//                    String productId = scanner.nextLine();
//
//                    // Call the method in ReviewAggregatorService to get the reviews for the product ID
//                    List<Review> reviews = reviewAggregatorService.getReviewsForProduct(productId);
//
//                    // Display the reviews to the user
//                    System.out.println("******************The list of reviews for product ID " + productId + "******************");
//                    System.out.println("");
//                    
//                    for (Review review : reviews) {
//                        System.out.println("         ****" + review.getComment());
//                    }
//
//                    break;
//
//                case 2:
//                    // Get input from the user
//                    System.out.print("Enter the product ID: ");
//                    productId = scanner.nextLine();
//                    
//                    System.out.println("");
//
//                    // Call the method in ReviewAggregatorService to get the average rating for the product ID
//                    double averageRating = reviewAggregatorService.getAverageRatingForProduct(productId);
//
//                    // Display the average rating to the user
//                    System.out.println("****************The average rating for product ID " + productId + " is " + averageRating+"****************");
//                    System.out.println("");
//
//                    break;
//
//                case 3:
//                    // Get input from the user
//                    System.out.print("Enter the user ID: ");
//                    String userId = scanner.nextLine();
//
//                    // Call the method in ReviewAggregatorService to get the reviews for the user ID
//                    reviews = reviewAggregatorService.getReviewsByUser(userId);
//
//                    // Display the reviews to the user
//                    System.out.println("****************The list of reviews for user ID " + userId+" ****************");
//                    for (Review review : reviews) {
//                        System.out.println("         ****" + review.getComment());
//                    }
//
//                    break;
//
//                case 4:
//                    // Set isContinuing to false to exit the loop
//                    isContinuing = false;
//
//                    break;
//
//                default:
//                    System.out.println("Invalid choice, please try again.");
//
//                    break;
//            }
//            System.out.println("=========================================================================");
//        }
//		
//		System.out.println("PROCESS ENDED");
//	    
//	    System.out.println("=========================================================================");
		
		ReviewApplication app = new ReviewApplication(reviewAggregatorService);
		app.getUserGUI();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping Review Aggregator bundle");
		
		// Unregister the ReviewAggregatorService from the OSGi service registry
		context.ungetService(reviewGeneratorServiceReference);
//		context.unregisterService(ReviewAggregatorService.class.getName(), reviewAggregatorService);
	}
}

