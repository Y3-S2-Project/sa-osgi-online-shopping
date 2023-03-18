package com.csse_we_26.shopping_cart_manager.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ShoppingCartManagerActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		ShoppingCartManagerActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		ShoppingCartManagerActivator.context = null;
	}

}
