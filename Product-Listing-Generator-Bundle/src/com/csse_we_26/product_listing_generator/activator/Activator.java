package com.csse_we_26.product_listing_generator.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;
import com.csse_we_26.product_listing_generator.service.impl.ProductListingGeneratorImpl;
import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;




public class Activator implements BundleActivator {
    //Declare service registration and service reference
	private ServiceRegistration registration;
	private ServiceReference<ReviewGeneratorService> reviewGeneratorServiceReference;

	public void start(BundleContext bundleContext) throws Exception {
		//Get review generator service reference
		reviewGeneratorServiceReference = bundleContext.getServiceReference(ReviewGeneratorService.class);
		//Get the review generator service reference
		ReviewGeneratorService reviewGeneratorService = bundleContext.getService(reviewGeneratorServiceReference);
		
		//Pass review generator service  to  productListing implementation later will be used to fetch reviews for the products
		ProductListingGenerator productListingGeneratorService = new ProductListingGeneratorImpl(reviewGeneratorService);
		//export the service
		registration = bundleContext.registerService(
				ProductListingGenerator.class.getName(), 
				productListingGeneratorService, 
				null);	
		System.out.println("Product Listing Generator bundle started successfully.");	
	
	}
	public void stop(BundleContext bundleContext) throws Exception {
        //unregister the service
		registration.unregister();
		
		System.out.println("Product Listing Generator bundle stopped successfully.");
	}

}
