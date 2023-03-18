package com.csse_we_26.reviewaggregator;

import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.csse_we_26.reviewaggregator.service.ReviewAggregatorService;
import com.csse_we_26.reviewaggregator.service.impl.ReviewAggregatorServiceImpl;
import com.csse_we_26.reviewaggregator.view.ReviewDisplay;
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
	ReviewAggregatorService reviewAggregatorService = new ReviewAggregatorServiceImpl(reviewGeneratorService);

		ReviewDisplay app = new ReviewDisplay(reviewAggregatorService);
		app.getUserGUI();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping Review Aggregator bundle");
		
		// Unregister the ReviewAggregatorService from the OSGi service registry
		context.ungetService(reviewGeneratorServiceReference);

	}
}

