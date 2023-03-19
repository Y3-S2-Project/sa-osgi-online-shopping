package com.csse_we_26.reviewgenerator.activator;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;
import com.csse_we_26.reviewgenerator.service.impl.ReviewGeneratorServiceImpl;
import com.mongodb.client.MongoDatabase;

import mongodb_service.MongoService;


public class ReviewGeneratorActivator implements BundleActivator {
	
	private ServiceRegistration registration;
	private ServiceReference<MongoService> mongoServiceReference;
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Review Generator bundle...");

		mongoServiceReference =  bundleContext.getServiceReference(MongoService.class);

		MongoService mongoService = bundleContext.getService(mongoServiceReference);
        
		MongoDatabase db = (MongoDatabase)mongoService.getDatabase();
		System.out.println(db instanceof MongoDatabase);
		
		ReviewGeneratorService reviewGeneratorService = new ReviewGeneratorServiceImpl(mongoService);

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

