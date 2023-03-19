package com.csse_we_26.shopping_cart_generator.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;


import com.csse_we_26.shopping_cart_generator.service.ShoppingCartService;
import com.csse_we_26.shopping_cart_generator.service.impl.ShoppingCartServiceImpl;

import mongodb_service.MongoService;
import mongodb_service.ShoppingCart;
import mongodb_service.ShoppingCartMapper;

public class ShoppingCartGeneratorActivator implements BundleActivator {

	private ServiceRegistration shoppingCartGeneratorRegistration;
	private ServiceReference<MongoService> mongoServiceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Shopping Cart Generator bundle...");
		
		mongoServiceReference =  bundleContext.getServiceReference(MongoService.class);
		MongoService mongoService = bundleContext.getService(mongoServiceReference);
		
		
		ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl(mongoService.getDatabase());
		
		shoppingCartGeneratorRegistration = bundleContext.registerService(ShoppingCartService.class.getName(),
				shoppingCartService, null);
		
		System.out.println("Shopping Cart Generator bundle started successfully...");
		
		ShoppingCart cart = new ShoppingCart();
		System.out.println(cart.getItems().toString());
//		ShoppingCartMapper mapper = new ShoppingCartMapper();
//		shoppingCartService.addItemToCart(new ProductDTO.Builder().setId("PID009").build(), 1);
//		shoppingCartService.addItemToCart(new ProductDTO.Builder().setId("PID010").build(), 3);
//		System.out.println(shoppingCartService.getShoppingCartByCustomerId("CID001"));
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping Shopping Cart Generator bundle...");
		shoppingCartGeneratorRegistration.unregister();
		System.out.println("Shopping Cart Generator bundle stopped successfully...");
	}

}
