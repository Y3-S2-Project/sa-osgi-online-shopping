package com.csse_we_26.reviewaggregator;

import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.csse_we_26.reviewaggregator.app.ReviewApplication;
import com.csse_we_26.reviewaggregator.service.ReviewAggregatorService;
import com.csse_we_26.reviewaggregator.service.impl.ReviewAggregatorServiceImpl;
import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;

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
		
		//Register the ReviewAggregatorService with the OSGi service registry
		context.registerService(ReviewAggregatorService.class, reviewAggregatorService, null);
		
		ReviewApplication app = new ReviewApplication(reviewAggregatorService);
		app.getUserGUI();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping Review Aggregator bundle");
		
		// Unregister the ReviewAggregatorService from the OSGi service registry
		context.ungetService(reviewGeneratorServiceReference);

	}
}

