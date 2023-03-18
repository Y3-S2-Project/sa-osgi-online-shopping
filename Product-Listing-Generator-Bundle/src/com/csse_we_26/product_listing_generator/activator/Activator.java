package com.csse_we_26.product_listing_generator.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


import com.csse_we_26.product_listing_generator.mapper.ProductMapper;
import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;
import com.csse_we_26.product_listing_generator.service.impl.ProductListingGeneratorImpl;


public class Activator implements BundleActivator {

	private ServiceRegistration registration;


	public void start(BundleContext bundleContext) throws Exception {
		ProductListingGenerator productListingGeneratorService = new ProductListingGeneratorImpl();
		
		registration = bundleContext.registerService(
				ProductListingGenerator.class.getName(), 
				productListingGeneratorService, 
				null);
		
		System.out.println("Product Listing Generator bundle started successfully.");
		ProductMapper mapper = new ProductMapper();
		//productListingGeneratorService.addProduct(new ProductDTO.Builder().setId("PID009").build());
        System.out.println(productListingGeneratorService.getProductById("PID009").getId());
	}
	public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stopping Product Listing Generator bundle...");
		
		registration.unregister();
		
		System.out.println("Product Listing Generator bundle stopped successfully.");
	}

}
