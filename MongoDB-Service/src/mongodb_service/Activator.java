package mongodb_service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {


	private ServiceRegistration mongoDBServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
	   System.out.println("MongoDB sercice is runnig");
	   MongoDBService mongoDBService = new  MongoDBServiceImpl();
		
	   mongoDBServiceRegistration = bundleContext.registerService( MongoDBService.class.getName(),
			   mongoDBService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		   System.out.println("MongoDB sercice is stopped");

	}

}
