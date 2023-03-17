package com.csse_we_26.product_display.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.csse_we_26.product_display.service.ProductDisplayService;
import com.csse_we_26.product_display.service.impl.ProductDisplayServiceImpl;
import com.csse_we_26.product_display.view.ProductListingDisplay;
import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;


public class Activator implements BundleActivator {

	private ServiceReference<ProductListingGenerator> productListingGeneratorServiceReference;
	private ProductListingDisplay productListingDisplay;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Product Display bundle");
		
		// Get a reference to the ReviewGeneratorService
		productListingGeneratorServiceReference = bundleContext.getServiceReference(ProductListingGenerator.class);
		ProductListingGenerator productListingGeneratorService = bundleContext.getService(productListingGeneratorServiceReference);

		productListingDisplay = new ProductListingDisplay(productListingGeneratorService);

	    
	   
	}

	public void stop(BundleContext bundleContext) throws Exception {
		 System.out.println("Stopping Product Display bundle");
		    
		 // Unregister any services that were registered in the start method
		 bundleContext.ungetService(productListingGeneratorServiceReference);
	}

}
