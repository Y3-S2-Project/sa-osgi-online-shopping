package com.csse_we_26.order_history_view;



import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.csse_we_26.order_history_generator.OrderHistoryGeneratorService;
import com.csse_we_26.order_history_view.app.OrderApplication;
import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;

public class OrderHistoryViewActivator implements BundleActivator {
	
	private OrderHistoryViewService orderHistoryViewService;
	private ServiceReference<OrderHistoryGeneratorService> orderHistoryGeneratorReference;
	
	private ServiceReference<ShoppingCartService> shoppingCartServiceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Order History View bundle...");
		
		orderHistoryGeneratorReference = bundleContext.getServiceReference(OrderHistoryGeneratorService.class);
		OrderHistoryGeneratorService orderHistoryGeneratorService = bundleContext.getService(orderHistoryGeneratorReference);
		
		orderHistoryViewService = new OrderHistoryViewServiceImpl(orderHistoryGeneratorService);
		
		bundleContext.registerService(OrderHistoryViewService.class, orderHistoryViewService, null);
		
		
		shoppingCartServiceReference = bundleContext.getServiceReference(ShoppingCartService.class);
		ShoppingCartService shoppingCartService = bundleContext.getService(shoppingCartServiceReference);
		
		OrderApplication app = new OrderApplication(orderHistoryViewService, shoppingCartService);
		app.getUserGUI();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Order History View bundle...");
		bundleContext.ungetService(orderHistoryGeneratorReference);
		System.out.println("Order History View bundle stopped.");
	}

}
