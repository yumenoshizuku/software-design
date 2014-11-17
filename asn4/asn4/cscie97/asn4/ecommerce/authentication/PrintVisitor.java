package cscie97.asn4.ecommerce.authentication;

/**
 * The Class PrintVisitor.
 * @author Fanxing Meng
 * @version 1.1 2013/11/20
 */
public class PrintVisitor implements Visitor {

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitor#visit(cscie97.asn4.ecommerce.authentication.User)
	 */
	public void visit(User user) {
		System.out.println("Visiting User: " + user.getId() + ", " + user.getName());
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitor#visit(cscie97.asn4.ecommerce.authentication.Permission)
	 */
	public void visit(Permission permission) {
		System.out.println("Visiting Permission: " + permission.getName() + ", " + permission.getDescription());
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitor#visit(cscie97.asn4.ecommerce.authentication.Role)
	 */
	public void visit(Role role) {
		System.out.println("Visiting Role: " + role.getName() + ", " + role.getDescription());
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitor#visit(cscie97.asn4.ecommerce.authentication.Service)
	 */
	public void visit(Service service) {
		System.out.println("Visiting Service: " + service.getName() + ", " + service.getDescription());
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitor#visit(cscie97.asn4.ecommerce.authentication.Entitlement)
	 */
	public void visit(Entitlement entitlement) {
		System.out.println("Visiting Entitlement: " + entitlement.getName() + ", " + entitlement.getDescription());
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitor#visit(cscie97.asn4.ecommerce.authentication.ServiceData)
	 */
	public void visit(ServiceData serviceData) {
		System.out.println("Visited All Service Data.");
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitor#visit(cscie97.asn4.ecommerce.authentication.UserData)
	 */
	public void visit(UserData userData) {
		System.out.println("Visited All User Data.");
	}

	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitor#visit(cscie97.asn4.ecommerce.authentication.EntitlementData)
	 */
	public void visit(EntitlementData entitlementData) {
		System.out.println("Visited All Entitlement Data.");
		
	}

}
