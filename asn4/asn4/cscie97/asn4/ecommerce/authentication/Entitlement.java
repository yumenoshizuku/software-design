
package cscie97.asn4.ecommerce.authentication;

import java.util.*;

/**
 * The Class Entitlement.
 * @author Fanxing Meng
 * @version 1.1 2013/11/18
 */
public abstract class Entitlement implements Visitable {
	
	/** The entitlement id. */
	protected String id;
	
	/** The name of entitlement. */
	protected String name;
	
	/** The entitlement description. */
	protected String description;

	/**
	 * Gets the entitlement id.
	 *
	 * @return the id
	 */
	protected String getId() {
		return id;
	}
	
	/**
	 * Gets the entitlement name.
	 *
	 * @return the name
	 */
	protected String getName() {
		return name;
	}
	
	/**
	 * Gets the entitlement description.
	 *
	 * @return the description
	 */
	protected String getDescription() {
		return description;
	}
	
	/**
	 * Adds another entitlement to the current entitlement.
	 *
	 * @param newEntitlement the new entitlement
	 */
	protected void addEntitlement(String newEntitlement) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Gets the service associated with the entitlement.
	 *
	 * @return the service
	 */
	protected String getService() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Gets the entitlements affiliated to the current entitlement.
	 *
	 * @return the entitlement
	 */
	protected List<String> getEntitlement() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Gets the entitlement iterator.
	 *
	 * @return the iterator
	 */
	protected Iterator getIterator() {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitable#accept(cscie97.asn4.ecommerce.authentication.Visitor)
	 */
	public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
