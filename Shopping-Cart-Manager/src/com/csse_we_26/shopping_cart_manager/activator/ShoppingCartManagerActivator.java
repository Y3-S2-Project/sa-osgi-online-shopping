package com.csse_we_26.shopping_cart_manager.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;
import com.csse_we_26.shopping_cart_manager.view.CartManagerView;

public class ShoppingCartManagerActivator implements BundleActivator {

	private ServiceReference<ShoppingCartService> shoppingCartServiceReference;
	private CartManagerView cartManagerView;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Cart Manager View bundle...");

		shoppingCartServiceReference = bundleContext.getServiceReference(ShoppingCartService.class);
		ShoppingCartService shoppingCartService = bundleContext.getService(shoppingCartServiceReference);

		cartManagerView = new CartManagerView(shoppingCartService);
		cartManagerView.displayUI();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Cart Manager View bundle...");
		bundleContext.ungetService(shoppingCartServiceReference);
	}
}
