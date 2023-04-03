package com.csse_we_26.order_history_generator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class OrderHistoryGeneratorActivator implements BundleActivator {

	private ServiceRegistration registration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Order History Generator bundle...");
		
		OrderHistoryGeneratorService orderHistoryGeneratorService = new OrderHistoryGeneratorServiceImpl();
		
		registration = bundleContext.registerService(
				OrderHistoryGeneratorService.class.getName(), 
				orderHistoryGeneratorService, 
				null);
		
		System.out.println("Order History Generator bundle started successfully.");
					
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Order History Generator bundle...");
		
		registration.unregister();
		
		System.out.println("Order History bundle stopped successfully.");
	}

}
