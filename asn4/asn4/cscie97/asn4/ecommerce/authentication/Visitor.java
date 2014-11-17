package cscie97.asn4.ecommerce.authentication;

/**
 * The Interface Visitor.
 * @author Fanxing Meng
 * @version 1.2 2013/11/20
 */
public interface Visitor {
	
	/**
	 * Visit a user.
	 *
	 * @param user the user to be visited
	 */
	void visit(User user);
	
	/**
	 * Visit a permission.
	 *
	 * @param permission the permission to be visited
	 */
	void visit(Permission permission);
	
	/**
	 * Visit a role.
	 *
	 * @param role the role to be visited
	 */
	void visit(Role role);

	/**
	 * Visit a service.
	 *
	 * @param service the service to be visited
	 */
	void visit(Service service);

	/**
	 * Visit an entitlement.
	 *
	 * @param entitlement the entitlement to be visited
	 */
	void visit(Entitlement entitlement);

	/**
	 * Visit all services.
	 *
	 * @param serviceData the service data instance to be traversed
	 */
	void visit(ServiceData serviceData);
	
	/**
	 * Visit all users.
	 *
	 * @param userData the user data instance to be traversed
	 */
	void visit(UserData userData);
	
	/**
	 * Visit all entitlements.
	 *
	 * @param entitlementData the entitlement data instance to be traversed
	 */
	void visit(EntitlementData entitlementData);
}
