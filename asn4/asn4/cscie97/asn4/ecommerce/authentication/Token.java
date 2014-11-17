package cscie97.asn4.ecommerce.authentication;

import java.util.UUID;

/**
 * The Class Token.
 * @author Fanxing Meng
 * @version 1.2 2013/11/18
 */
public class Token {
	
	/** The token id. */
	private UUID id;
	
	/** The user name associated with the token. */
	private String username;
	
	/** The last used time. */
	private long lastUsed;
	
	/** The state of the token, false for expired and true for active. */
	private boolean state;
	
	/** The Constant expiration time in millisecond. */
	private static final long expire = 3600000; 
	
	/**
	 * Instantiates a new token.
	 *
	 * @param newId the new id
	 * @param newName the new name
	 * @param time current time
	 */
	protected Token(UUID newId, String newName, long time) {
		id = newId;
		username = newName;
		lastUsed = time;
		state = true;
	}

	/**
	 * Gets the id of the token.
	 *
	 * @return the token id
	 */
	protected UUID getId() {
		return id;
	}

	/**
	 * Gets the user name associated with the token.
	 *
	 * @return the user name
	 */
	protected String getUsername() {
		return username;
	}
	
	/**
	 * Update the token's last-used-time, mark as expired if current time is over last used time plus expiration time.
	 *
	 * @param time the time
	 */
	private void updateToken(long time) {
		if(state != false) {
			if(time <= lastUsed + expire) {
				lastUsed = time;
			} else {
				state = false;
			}
		}
	}
	
	/**
	 * Check token status after updating it.
	 *
	 * @return true, if successful
	 */
	protected boolean checkToken() {
		updateToken(System.currentTimeMillis());
		return state;
	}
	
}
