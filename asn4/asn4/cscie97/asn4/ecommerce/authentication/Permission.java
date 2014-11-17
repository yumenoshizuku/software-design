package cscie97.asn4.ecommerce.authentication;

import java.util.Iterator;

/**
 * The Class Permission.
 * @author Fanxing Meng
 * @version 1.1 2013/11/18
 */
public class Permission extends Entitlement {
	
	/** The service associated with the permission. */
	private String service;
	
	/**
	 * Instantiates a new permission.
	 *
	 * @param newId the new id
	 * @param newName the new name
	 * @param newDescription the new description
	 * @param newService the new service
	 */
	protected Permission(String newId, String newName, String newDescription, String newService) {
		super.id = newId;
		super.name = newName;
		super.description = newDescription;
		service = newService;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Entitlement#getService()
	 */
	protected String getService() {
		return service;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Entitlement#getIterator()
	 */
	protected Iterator getIterator() {
		return new PermissionIterator();
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Entitlement#accept(cscie97.asn4.ecommerce.authentication.Visitor)
	 */
	public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
