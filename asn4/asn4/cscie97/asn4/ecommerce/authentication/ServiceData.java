package cscie97.asn4.ecommerce.authentication;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * The Class ServiceData.
 * @author Fanxing Meng
 * @version 1.3 2013/11/20
 */
public class ServiceData implements Visitable {
	
	/** The unique instance. */
	private static ServiceData uniqueInstance = new ServiceData();

	/** The service map. */
	private static Map<String, Service> serviceMap;
	
	/**
	 * Instantiates a new service data with empty service map.
	 */
	private ServiceData() {
		serviceMap = new HashMap<String, Service>();
	}

	/**
	 * Gets the single instance of ServiceData.
	 *
	 * @return single instance of ServiceData
	 */
	public static ServiceData getInstance() {
		return uniqueInstance;
	}
	
	/**
	 * Gets the service map.
	 *
	 * @return the service map
	 */
	protected Map<String, Service> getServiceMap() {
		return serviceMap;
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitable#accept(cscie97.asn4.ecommerce.authentication.Visitor)
	 */
	@Override
	public void accept(Visitor visitor) {
		Iterator iter = serviceMap.entrySet().iterator(); 
		while (iter.hasNext()) {
			Map.Entry<String, Service> entry = (Entry<String, Service>) iter.next();
			entry.getValue().accept(visitor);
		}
		visitor.visit(this);
	}
}
