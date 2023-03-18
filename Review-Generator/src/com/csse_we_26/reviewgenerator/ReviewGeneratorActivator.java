package com.csse_we_26.reviewgenerator;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;
import com.csse_we_26.reviewgenerator.service.impl.ReviewGeneratorServiceImpl;


import mongodb_service.MongoService;

public class ReviewGeneratorActivator implements BundleActivator {
	
	private ServiceRegistration registration;
	private ServiceReference<MongoService> mongoServiceReference;
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Review Generator bundle...");
		System.out.println("I was here asloo");
		mongoServiceReference =  bundleContext.getServiceReference(MongoService.class);
		System.out.println("I was here");
		MongoService mongoService = bundleContext.getService(mongoServiceReference);
		
		System.out.println("I was here");
		
		ReviewGeneratorService reviewGeneratorService = new ReviewGeneratorServiceImpl(mongoService);
		System.out.println("This was the issue");
		registration = bundleContext.registerService(
				ReviewGeneratorService.class.getName(), 
				reviewGeneratorService, 
				null);
		
		System.out.println("Review Generator bundle started successfully.");

		
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Review Generator bundle...");
		
		registration.unregister();
		
		System.out.println("Review Generator bundle stopped successfully.");
	}

}


