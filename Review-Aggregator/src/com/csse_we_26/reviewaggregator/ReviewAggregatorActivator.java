package com.csse_we_26.reviewaggregator;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.csse_30.reviewgenerator.Review;
import com.csse_30.reviewgenerator.ReviewGeneratorService;

public class ReviewAggregatorActivator implements BundleActivator {

	private ReviewAggregatorService reviewAggregatorService;
	private ServiceReference<ReviewGeneratorService> reviewGeneratorServiceReference;
//	Scanner sc = new Scanner(System.in);
	
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Starting Review Aggregator bundle");
		
		// Get a reference to the ReviewGeneratorService
		reviewGeneratorServiceReference = context.getServiceReference(ReviewGeneratorService.class);
		ReviewGeneratorService reviewGeneratorService = context.getService(reviewGeneratorServiceReference);
		
		// Create a new instance of the ReviewAggregatorServiceImpl and pass in the ReviewGeneratorService reference
		reviewAggregatorService = new ReviewAggregatorServiceImpl(reviewGeneratorService);
		
		// Register the ReviewAggregatorService with the OSGi service registry
		context.registerService(ReviewAggregatorService.class, reviewAggregatorService, null);
		
		
		Scanner scanner = new Scanner(System.in);
//	    System.out.print("Enter the product Id: ");
//	    String productId = scanner.nextLine();

	    List<Review> reviews= reviewAggregatorService.getReviewsForProduct("1");
	    System.out.println("=================================================================");
//	    System.out.println("The List of Reviews for product Id " + productId);

	    for (int i=0; i<reviews.size(); i++) {
	        System.out.println(reviews.get(i).getComment());
	    }

	    System.out.println("=================================================================");

//	    scanner.close();
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping Review Aggregator bundle");
		
		// Unregister the ReviewAggregatorService from the OSGi service registry
		context.ungetService(reviewGeneratorServiceReference);
//		context.unregisterService(ReviewAggregatorService.class.getName(), reviewAggregatorService);
	}
}

