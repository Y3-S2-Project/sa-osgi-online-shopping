package com.csse_we_26.order_history_generator.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class OrderHistoryGeneratorActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		OrderHistoryGeneratorActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		OrderHistoryGeneratorActivator.context = null;
	}

}
