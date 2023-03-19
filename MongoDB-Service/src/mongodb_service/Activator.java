package mongodb_service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {

	private ServiceRegistration registration;
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("MongoDB Service started");
	    MongoService mongoService =MongoServiceImpl.getInstance();
        System.out.println(mongoService.getDatabase().getName());
		registration = bundleContext.registerService(
				MongoService.class.getName(), 
				mongoService, 
				null);
		System.out.println("MongoDB Service registration done");
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		registration.unregister();
	}

}
