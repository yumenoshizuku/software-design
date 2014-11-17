package cscie97.asn4.ecommerce.authentication;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * The Class TokenData.
 * @author Fanxing Meng
 * @version 1.0 2013/11/18
 */
public class TokenData {
	
	/** The unique instance. */
	private static TokenData uniqueInstance = new TokenData();

	/** The token map. */
	private Map<UUID, Token> tokenMap;
	
	/**
	 * Instantiates a new token data with empty token map.
	 */
	private TokenData() {
		tokenMap = new HashMap<UUID, Token>();
	}

	/**
	 * Gets the single instance of TokenData.
	 *
	 * @return single instance of TokenData
	 */
	public static Map<UUID, Token> getInstance() {
		return uniqueInstance.tokenMap;
	}
}
