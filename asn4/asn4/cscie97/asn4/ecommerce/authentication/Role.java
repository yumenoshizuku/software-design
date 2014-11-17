package cscie97.asn4.ecommerce.authentication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The Class Role.
 * @author Fanxing Meng
 * @version 1.3 2013/11/18
 */
public class Role extends Entitlement {
	
	/** The entitlements affiliated with the role. */
	private List<String> entitlements = new ArrayList<String>();
	
	/** The all child. */
	private Map<String, Entitlement> allChild = new HashMap<String, Entitlement>();
	
	/**
	 * Instantiates a new role.
	 *
	 * @param newId the new id
	 * @param newName the new name
	 * @param newDescription the new description
	 */
	protected Role(String newId, String newName, String newDescription) {
		super.id = newId;
		super.name = newName;
		super.description = newDescription;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Entitlement#addEntitlement(java.lang.String)
	 */
	protected void addEntitlement(String newEntitlement) {
		try {
			if(!entitlements.contains(newEntitlement)) {
				entitlements.add(newEntitlement);
			} else {
				throw new AuthenticationException("Entitlement " + newEntitlement + " already exists in " + id);
			}
		} catch(AuthenticationException ex){
			System.out.println(ex);
		}
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Entitlement#getEntitlement()
	 */
	protected List<String> getEntitlement() {
		return entitlements;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Entitlement#getIterator()
	 */
	protected Iterator getIterator() {
		allChild.clear();
		for(String entitlement : entitlements) {
			allChild.put(entitlement, EntitlementData.getInstance().getEntitlementMap().get(entitlement));
		}
		return new RoleIterator(allChild.values().iterator());
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Entitlement#accept(cscie97.asn4.ecommerce.authentication.Visitor)
	 */
	public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
