package com.csse_we_26.product_display.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.csse_we_26.product_display.view.ProductListingDisplay;
import com.csse_we_26.product_listing_generator.service.ProductListingGenerator;


public class Activator implements BundleActivator {
    //Declare producer service reference with type safety
	private ServiceReference<ProductListingGenerator> productListingGeneratorServiceReference;
	//Declare product display view
	private ProductListingDisplay productListingDisplay;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Product Display bundle started sucessfully");
		
		//Get a service reference to the product listing generator service and get the service
		productListingGeneratorServiceReference = bundleContext.getServiceReference(ProductListingGenerator.class);
		ProductListingGenerator productListingGeneratorService = bundleContext.getService(productListingGeneratorServiceReference);
        //passing product listing generator service for to accessed by consumer
		productListingDisplay = new ProductListingDisplay(productListingGeneratorService);
        
		//call display UI function to give customers the output
		productListingDisplay.dipalyUI();
	   
	}

	public void stop(BundleContext bundleContext) throws Exception {
		 System.out.println("Product Display bundle stopped sucessfully");
		    
		 // Unregister any services that were registered in the start method
		 bundleContext.ungetService(productListingGeneratorServiceReference);
	}

}
