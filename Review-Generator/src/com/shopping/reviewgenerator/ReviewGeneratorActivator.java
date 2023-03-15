package com.shopping.reviewgenerator;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.shopping.reviewgenerator.ReviewGeneratorService;
import com.shopping.reviewgenerator.ReviewGeneratorServiceImpl;

public class ReviewGeneratorActivator implements BundleActivator {
	
	private ServiceRegistration registration;
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Review Generator bundle...");
		
//		MongoClient mongoClient = new MongoClient("localhost", 27017);
//		System.out.println("mongodb connected");
//		MongoDatabase database = mongoClient.getDatabase("shopping");
//		MongoCollection<org.bson.Document> collection = database.getCollection("reviews");
		
		ReviewGeneratorService reviewGeneratorService = new ReviewGeneratorServiceImpl();
		
//		reviewGeneratorServiceImpl.activate();
		
		registration = bundleContext.registerService(
				ReviewGeneratorService.class.getName(), 
				reviewGeneratorService, 
				null);
		
		System.out.println("Review Generator bundle started successfully.");
//		System.out.println(collection.count());
		
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Review Generator bundle...");
		
		registration.unregister();
		
		System.out.println("Review Generator bundle stopped successfully.");
	}

}


