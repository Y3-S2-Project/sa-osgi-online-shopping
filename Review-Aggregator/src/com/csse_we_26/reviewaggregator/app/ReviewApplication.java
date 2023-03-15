package com.csse_we_26.reviewaggregator.app;

import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

import com.csse_30.reviewgenerator.Review;
import com.csse_we_26.reviewaggregator.ReviewAggregatorService;

public class ReviewApplication {

	public static void main(String[] args) {
		FrameworkFactory frameworkFactory = ServiceLoader.load(FrameworkFactory.class).iterator().next();
		Framework framework = frameworkFactory.newFramework(null);
		
		try {
            framework.start();
            BundleContext bundleContext = framework.getBundleContext();
    		
    		// Install and start ReviewGenerator bundle
//    		bundleContext.installBundle("file:/path/to/ReviewGenerator.jar").start();
    		
    		// Install and start ReviewAggregator bundle
//    		bundleContext.installBundle("file:/path/to/ReviewAggregator.jar").start();
    		
    		// Get a reference to the ReviewAggregatorService
    		ServiceReference<ReviewAggregatorService> reviewAggregatorServiceReference = bundleContext.getServiceReference(ReviewAggregatorService.class);
    		ReviewAggregatorService reviewAggregatorService = bundleContext.getService(reviewAggregatorServiceReference);
    		
    		// Get input from the user
    		Scanner scanner = new Scanner(System.in);
    		System.out.print("Enter the product ID: ");
    		String productId = scanner.nextLine();
    		
    		// Call the method in ReviewAggregatorService to get the reviews for the product ID
    		List<Review> reviews = reviewAggregatorService.getReviewsForProduct(productId);
    		
    		System.out.println("=================================================================");
    		
    		// Display the reviews to the user
    		System.out.println("Reviews for product ID " + productId + ":");
    		for (Review review : reviews) {
    			System.out.println(review);
    		}
    		
    		System.out.println("=================================================================");

    	    scanner.close();
    	    
        } catch (BundleException e) {
            e.printStackTrace();
        } finally {
            try {
//            	bundleContext.ungetService(reviewAggregatorServiceReference);
                framework.stop();
                framework.waitForStop(0);
            } catch (BundleException | InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

}
