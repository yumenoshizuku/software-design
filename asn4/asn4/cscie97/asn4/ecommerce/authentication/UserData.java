package cscie97.asn4.ecommerce.authentication;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The Class UserData.
 * @author Fanxing Meng
 * @version 1.3 2013/11/20
 */
public class UserData implements Visitable {
	
	/** The unique instance of user data. */
	private static UserData uniqueInstance = new UserData();

	/** The user map that stores all user information. */
	private static Map<String, User> userMap;
	
	/**
	 * Instantiates a new user data, initialize with an admin user having root role.
	 */
	private UserData() {
		Creator creator = new Creator();
		User admin = creator.createUser("admin", "admin");
		admin.addCredential("admin", Authentication.getInstance().MD5("admin"));
		admin.addEntitlement("rootRole");
		userMap = new HashMap<String, User>();
		userMap.put("admin", admin);
	}
	
	/**
	 * Gets the single instance of UserData.
	 *
	 * @return single instance of UserData
	 */
	public static UserData getInstance() {
		return uniqueInstance;
	}
	
	/**
	 * Gets the user map.
	 *
	 * @return the user map
	 */
	protected Map<String, User> getUserMap() {
		return userMap;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn4.ecommerce.authentication.Visitable#accept(cscie97.asn4.ecommerce.authentication.Visitor)
	 */
	public void accept(Visitor visitor) {
		Iterator iter = userMap.entrySet().iterator(); 
		while (iter.hasNext()) {
			Map.Entry<String, User> entry = (Entry<String, User>) iter.next();
			entry.getValue().accept(visitor);
		}
		visitor.visit(this);
	}
}
