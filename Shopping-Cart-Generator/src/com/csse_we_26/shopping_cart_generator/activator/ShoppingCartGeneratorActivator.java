package com.csse_we_26.shopping_cart_generator.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ShoppingCartGeneratorActivator implements BundleActivator {

	private ServiceRegistration shoppingCartGeneratorRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Shopping Cart Generator bundle...");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Shopping Cart Generator bundle stopped...");
	}

}
