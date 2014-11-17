
package cscie97.asn4.ecommerce.authentication;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The Class EntitlementData.
 * @author Fanxing Meng
 * @version 1.3 2013/11/20
 */
public class EntitlementData implements Visitable {
	
	/** The unique instance. */
	private static EntitlementData uniqueInstance = new EntitlementData();

	/** The entitlement map. */
	private static Map<String, Entitlement> entitlementMap;
	
	/**
	 * Instantiates a new entitlement data, initialize with root permission and root role.
	 */
	private EntitlementData() {
		Creator creator = new Creator();
		Permission root = creator.createPermission("root", "root", "root", "");
		Role rootRole = creator.createRole("rootRole", "rootRole", "rootRole");
		rootRole.addEntitlement("root");
		entitlementMap = new HashMap<String, Entitlement>();
		entitlementMap.put("rootRole", rootRole);
		entitlementMap.put("root", root);
	}

	/**
	 * Gets the single instance of EntitlementData.
	 *
	 * @return single instance of EntitlementData
	 */
	public static EntitlementData getInstance() {
		return uniqueInstance;
	}
	
	/**
	 * Gets the entitlement map.
	 *
	 * @return the entitlement map
	 */
	protected Map<String, Entitlement> getEntitlementMap() {
		return entitlementMap;
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitable#accept(cscie97.asn4.ecommerce.authentication.Visitor)
	 */
	@Override
	public void accept(Visitor visitor) {
		Iterator iter = entitlementMap.entrySet().iterator(); 
		while (iter.hasNext()) {
			Map.Entry<String, Entitlement> entry = (Entry<String, Entitlement>) iter.next();
			entry.getValue().accept(visitor);
		}
		visitor.visit(this);
	}
}
