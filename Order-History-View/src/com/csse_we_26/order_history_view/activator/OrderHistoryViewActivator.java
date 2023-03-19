package com.csse_we_26.order_history_view.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.csse_we_26.order_history_generator.service.OrderHistoryService;
import com.csse_we_26.order_history_view.view.OrderHistoryView;
import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;

public class OrderHistoryViewActivator implements BundleActivator {

	private ServiceReference<OrderHistoryService> orderHistoryGeneratorServiceReference;
	
	private ServiceReference<ShoppingCartService> shoppingCartServiceReference;
	private OrderHistoryView orderHistoryView;
	
	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Starting Order History View bundle...");
		
		orderHistoryGeneratorServiceReference = bundleContext.getServiceReference(OrderHistoryService.class);
		OrderHistoryService orderHistoryService = bundleContext.getService(orderHistoryGeneratorServiceReference);
		
		shoppingCartServiceReference =  bundleContext.getServiceReference(ShoppingCartService.class);
		ShoppingCartService shoppingCartService = bundleContext.getService(shoppingCartServiceReference);
		
		orderHistoryView = new OrderHistoryView(orderHistoryService ,shoppingCartService);
		orderHistoryView.displayUI();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Order History Bundle...");
		bundleContext.ungetService(orderHistoryGeneratorServiceReference);
	}

}
