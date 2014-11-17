package cscie97.asn4.ecommerce.authentication;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * The Class User.
 * @author Fanxing Meng
 * @version 1.3 2013/11/20
 */
public class User implements Visitable {
	
	/** The user id. */
	private String id;
	
	/** The name of the user id. */
	private String name;
	
	/** The user credentials affiliated with this user id. */
	private Map<String, String> credentials = new HashMap<String, String>();
	
	/** The entitlements assigned to the user. */
	private List<String> entitlements = new ArrayList<String>();
	
	/**
	 * Instantiates a new user.
	 *
	 * @param newId the new id
	 * @param newName the new name
	 */
	protected User(String newId, String newName) {
		id = newId;
		name = newName;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the id
	 */
	protected String getId() {
		return id;
	}
	
	/**
	 * Gets the user name.
	 *
	 * @return the name
	 */
	protected String getName() {
		return name;
	}
	
	/**
	 * Adds a credential to current user.
	 *
	 * @param login the login name
	 * @param passwordMD5 the hashed password using md5
	 */
	protected void addCredential(String login, String passwordMD5) {
		try {
			if(credentials.containsKey(login)) {
				throw new AuthenticationException("User name " + login + " already exists for the user " + id);
			}
			credentials.put(login, passwordMD5);
		} catch (AuthenticationException ex) {
			System.out.println(ex);
		}
	}

	/**
	 * Gets the credentials affiliated with the user.
	 *
	 * @return the credentials
	 */
	protected Map<String, String> getCredentials() {
		return credentials;
	}
	
	/**
	 * Adds an entitlement to the user.
	 *
	 * @param newEntitlement the new entitlement's id
	 */
	protected void addEntitlement(String newEntitlement) {
		try {
			if(!entitlements.contains(newEntitlement)) {
				entitlements.add(newEntitlement);
			} else {
				throw new AuthenticationException("User " + id + " already has entitlement " + newEntitlement);
			}
		} catch(AuthenticationException ex){
			System.out.println(ex);
		}
	}

	/**
	 * Gets the entitlements associated with the user.
	 *
	 * @return the entitlements
	 */
	protected List<String> getEntitlements() {
		return entitlements;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitable#accept(cscie97.asn4.ecommerce.authentication.Visitor)
	 */
	public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
