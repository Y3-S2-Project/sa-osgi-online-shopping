package com.csse_we_26.order_history_view.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.csse_we_26.order_history_generator.service.OrderHistoryService;
import com.csse_we_26.order_history_view.view.OrderHistoryView;

public class OrderHistoryViewActivator implements BundleActivator {

	private ServiceReference<OrderHistoryService> orderHistoryGeneratorServiceReference;
	private OrderHistoryView orderHistoryView;
	
	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Starting Order History View bundle...");
		
		orderHistoryGeneratorServiceReference = bundleContext.getServiceReference(OrderHistoryService.class);
		OrderHistoryService orderHistoryService = bundleContext.getService(orderHistoryGeneratorServiceReference);
		
		orderHistoryView = new OrderHistoryView(orderHistoryService);
		orderHistoryView.displayUI();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Order History Bundle...");
		bundleContext.ungetService(orderHistoryGeneratorServiceReference);
	}

}
