
package cscie97.asn4.ecommerce.authentication;

import java.util.UUID;

/**
 * The Class Creator.
 * @author Fanxing Meng
 * @version 1.0 2013/11/18
 */
public class Creator {

	/**
	 * Creates a service.
	 *
	 * @param newId the new service's id
	 * @param newName the new service's name
	 * @param newDescription the new service's description
	 * @return the service
	 */
	protected Service createService(String newId, String newName, String newDescription) {
		return new Service(newId, newName, newDescription);
	}

	/**
	 * Creates a user.
	 *
	 * @param newId the new user's id
	 * @param newName the new user's name
	 * @return the user
	 */
	protected User createUser(String newId, String newName) {
		return new User(newId, newName);
	}

	/**
	 * Creates a permission.
	 *
	 * @param newId the new permission's id
	 * @param newName the new permission's name
	 * @param newDescription the new permission's description
	 * @param newService the new service associated with the permission
	 * @return the permission
	 */
	protected Permission createPermission(String newId, String newName, String newDescription, String newService) {
		return new Permission(newId, newName, newDescription, newService);
	}
	
	/**
	 * Creates a role.
	 *
	 * @param newId the new role's id
	 * @param newName the new role's name
	 * @param newDescription the new role's description
	 * @return the role
	 */
	protected Role createRole(String newId, String newName, String newDescription) {
		return new Role(newId, newName, newDescription);
	}
	
	/**
	 * Creates a token.
	 *
	 * @param newId the new token's id
	 * @param newName the new token's name
	 * @param time current time to set the token
	 * @return the token
	 */
	protected Token createToken(UUID newId, String newName, long time) {
		return new Token(newId, newName, time);
	}
}
