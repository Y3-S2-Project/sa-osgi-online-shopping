package com.csse_we_26.reviewgenerator.activator;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.osgi.framework.ServiceRegistration;

import com.csse_we_26.reviewgenerator.service.ReviewGeneratorService;
import com.csse_we_26.reviewgenerator.service.impl.ReviewGeneratorServiceImpl;




public class ReviewGeneratorActivator implements BundleActivator {
	
	private ServiceRegistration registration;
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Review Generator bundle...");


      
		
		ReviewGeneratorService reviewGeneratorService = new ReviewGeneratorServiceImpl();

		registration = bundleContext.registerService(
				ReviewGeneratorService.class.getName(), 
				reviewGeneratorService, 
				null);
		


		
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		
		registration.unregister();
		
		System.out.println("Review Generator bundle stopped successfully.");
	}

}


