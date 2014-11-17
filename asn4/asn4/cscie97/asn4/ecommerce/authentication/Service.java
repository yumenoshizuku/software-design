package cscie97.asn4.ecommerce.authentication;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Service.
 * @author Fanxing Meng
 * @version 1.3 2013/11/20
 */
public class Service implements Visitable {
	
	/** The service id. */
	private String id;
	
	/** The service name. */
	private String name;
	
	/** The service description. */
	private String description;
	
	/** The permissions associated with the service. */
	private List<String> permissions = new ArrayList<String>();
	
	/**
	 * Instantiates a new service.
	 *
	 * @param newId the new id
	 * @param newName the new name
	 * @param newDescription the new description
	 */
	protected Service(String newId, String newName, String newDescription) {
		id = newId;
		name = newName;
		description = newDescription;
	}
	
	/**
	 * Adds a permission associated with the service.
	 *
	 * @param newPermission the new permission
	 */
	protected void addPermission(String newPermission) {
		try {
			if(!permissions.contains(newPermission)) {
				permissions.add(newPermission);
			} else {
				throw new AuthenticationException("Service " + id + " already contains " + newPermission);
			}
		} catch(AuthenticationException ex){
			System.out.println(ex);
		}
	}

	/**
	 * Gets the service id.
	 *
	 * @return the id
	 */
	protected String getId() {
		return id;
	}

	/**
	 * Gets the service name.
	 *
	 * @return the name
	 */
	protected String getName() {
		return name;
	}
	
	/**
	 * Gets the service description.
	 *
	 * @return the description
	 */
	protected String getDescription() {
		return description;
	}
	
	/**
	 * Gets the permissions associated with the service.
	 *
	 * @return the permissions
	 */
	protected List<String> getPermissions() {
		return permissions;
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitable#accept(cscie97.asn4.ecommerce.authentication.Visitor)
	 */
	public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
