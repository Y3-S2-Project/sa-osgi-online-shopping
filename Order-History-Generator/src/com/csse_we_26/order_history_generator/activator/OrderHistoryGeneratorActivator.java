package com.csse_we_26.order_history_generator.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.csse_we_26.order_history_generator.service.OrderHistoryService;
import com.csse_we_26.order_history_generator.service.impl.OrderHistoryServiceImpl;

import mongodb_service.MongoService;
import mongodb_service.OrderHistory;
import mongodb_service.OrderHistoryDTO;

public class OrderHistoryGeneratorActivator implements BundleActivator {

	private ServiceRegistration orderHistoryRegistration;
	private ServiceReference<MongoService> mongoServiceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Order History Generator bundle...");
        
		mongoServiceReference =  bundleContext.getServiceReference(MongoService.class);
		MongoService mongoService = bundleContext.getService(mongoServiceReference);
		
		
		OrderHistoryService orderHistoryService = new OrderHistoryServiceImpl(mongoService.getDatabase());

		orderHistoryRegistration = bundleContext.registerService(OrderHistoryService.class.getName(),
				orderHistoryService, null);

		System.out.println("Order History Generator bundle started successfully...");
		OrderHistory order = new OrderHistory();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Order History Generator bundle...");

		orderHistoryRegistration.unregister();

		System.out.println("Order History Generator bundle stopped successfully...");
	}

}
