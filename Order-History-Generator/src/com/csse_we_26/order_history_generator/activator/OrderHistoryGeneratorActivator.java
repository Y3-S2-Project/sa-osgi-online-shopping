package com.csse_we_26.order_history_generator.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.csse_we_26.order_history_generator.service.OrderHistoryService;
import com.csse_we_26.order_history_generator.service.impl.OrderHistoryServiceImpl;

import mongodb_service.OrderHistory;
import mongodb_service.OrderHistoryDTO;

public class OrderHistoryGeneratorActivator implements BundleActivator {

	private ServiceRegistration orderHistoryRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Order History Generator bundle...");

		OrderHistoryService orderHistoryService = new OrderHistoryServiceImpl();

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
