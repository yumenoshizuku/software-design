package cscie97.asn4.ecommerce.authentication;

import java.util.*;
import java.util.Map.Entry;
import java.util.Iterator;
import java.security.*;

/**
 * The Class Authentication.
 * @author Fanxing Meng
 * @version 2.3 2013/11/20
 */
public class Authentication {

	/** The unique instance. */
	private static Authentication uniqueInstance = new Authentication();

	/**
	 * Instantiates a new authentication.
	 */
	private Authentication() {}

	/**
	 * Gets the single instance of Authentication.
	 *
	 * @return single instance of Authentication
	 */
	public static Authentication getInstance() {
		return uniqueInstance;
	}

	/**
	 * Define service.
	 *
	 * @param newId the new service's id
	 * @param newName the new service's name
	 * @param newDescription the new service's description
	 * @param token the token for defining service
	 * @param permission the permission for defining service
	 * @throws AuthenticationException an authentication exception
	 * @throws InvalidAccessTokenException an invalid access token exception
	 */
	protected void defineService(String newId, String newName, String newDescription, UUID token, String permission) throws AuthenticationException, InvalidAccessTokenException {
		if (checkTokenPermission(token, permission)) {
			if(!ServiceData.getInstance().getServiceMap().containsKey(newId)) {
				Creator creator = new Creator();
				ServiceData.getInstance().getServiceMap().put(newId, creator.createService(newId, newName, newDescription));
			} else {
				throw new AuthenticationException("Service " + newId + " already exists and cannot be added.");
			}
		} else {
			throw new InvalidAccessTokenException(permission);
		}
	}

	/**
	 * Define permission.
	 *
	 * @param serviceId the service id associated with the permission
	 * @param permissionId the new permission's id
	 * @param newName the new permission's name
	 * @param newDescription the new permission's description
	 * @param token the token for defining permission
	 * @param permission the permission for defining permission
	 * @throws AuthenticationException an authentication exception
	 * @throws InvalidAccessTokenException an invalid access token exception
	 */
	protected void definePermission(String serviceId, String permissionId, String newName, String newDescription, UUID token, String permission) throws AuthenticationException, InvalidAccessTokenException {
		if (checkTokenPermission(token, permission)) {
			if(!EntitlementData.getInstance().getEntitlementMap().containsKey(permissionId)) {
				if(ServiceData.getInstance().getServiceMap().containsKey(serviceId)) {
					Creator creator = new Creator();
					EntitlementData.getInstance().getEntitlementMap().put(permissionId, creator.createPermission(permissionId, newName, newDescription, serviceId));
					ServiceData.getInstance().getServiceMap().get(serviceId).addPermission(permissionId);
				} else {
					throw new AuthenticationException("Service " + serviceId + " does not exist, permission could not be attached to it.");
				}
			} else {
				throw new AuthenticationException("Permission " + permissionId + " already exists and cannot be added.");
			}
		} else {
			throw new InvalidAccessTokenException(permission);
		}
	}

	/**
	 * Define role.
	 *
	 * @param newId the new role's id
	 * @param newName the new role's name
	 * @param newDescription the new role's description
	 * @param token the token for defining role
	 * @param permission the permission for defining role
	 * @throws AuthenticationException an authentication exception
	 * @throws InvalidAccessTokenException an invalid access token exception
	 */
	protected void defineRole(String newId, String newName, String newDescription, UUID token, String permission) throws AuthenticationException, InvalidAccessTokenException {
		if (checkTokenPermission(token, permission)) {
			if(!EntitlementData.getInstance().getEntitlementMap().containsKey(newId)) {
				Creator creator = new Creator();
				EntitlementData.getInstance().getEntitlementMap().put(newId, creator.createRole(newId, newName, newDescription));
			} else {
				throw new AuthenticationException("Role " + newId + " already exists and cannot be added.");
			}
		} else {
			throw new InvalidAccessTokenException(permission);
		}
	}

	/**
	 * Adds an entitlement to role.
	 *
	 * @param roleId the role's id
	 * @param entitlementId the entitlement's id
	 * @param token the token for adding an entitlement to role
	 * @param permission the permission for adding an entitlement to role
	 * @throws AuthenticationException an authentication exception
	 * @throws InvalidAccessTokenException an invalid access token exception
	 */
	protected void addEntitlementToRole(String roleId, String entitlementId, UUID token, String permission) throws AuthenticationException, InvalidAccessTokenException {
		if (checkTokenPermission(token, permission)) {
			if(EntitlementData.getInstance().getEntitlementMap().containsKey(roleId) && EntitlementData.getInstance().getEntitlementMap().get(roleId) instanceof Role) {
				if(EntitlementData.getInstance().getEntitlementMap().containsKey(entitlementId)) {
					if(!EntitlementData.getInstance().getEntitlementMap().get(roleId).getEntitlement().contains(entitlementId)) {
						EntitlementData.getInstance().getEntitlementMap().get(roleId).addEntitlement(entitlementId);
					} else {
						throw new AuthenticationException("Entitlement " + entitlementId + " already exists in role " + roleId + ".");
					}
				} else {
					throw new AuthenticationException("Entitlement " + entitlementId + " does not exist and cannot be added to " + roleId + ".");
				}
			} else {
				throw new AuthenticationException(roleId + " is not a valid role, " + entitlementId + " cannot be added to it.");
			}
		} else {
			throw new InvalidAccessTokenException(permission);
		}
	}

	/**
	 * Creates a user.
	 *
	 * @param newId the new user's id
	 * @param newName the new user's name
	 * @param token the token for creating a user
	 * @param permission the permission for creating a user
	 * @throws AuthenticationException an authentication exception
	 * @throws InvalidAccessTokenException an invalid access token exception
	 */
	protected void createUser(String newId, String newName, UUID token, String permission) throws AuthenticationException, InvalidAccessTokenException {
		if (checkTokenPermission(token, permission)) {
			if(!UserData.getInstance().getUserMap().containsKey(newId)) {
				Creator creator = new Creator();
				UserData.getInstance().getUserMap().put(newId, creator.createUser(newId, newName));
			} else {
				throw new AuthenticationException("User ID " + newId + " already exists and cannot be added.");
			}
		} else {
			throw new InvalidAccessTokenException(permission);
		}
	}

	/**
	 * Adds credential to a user.
	 *
	 * @param userId the user's id
	 * @param newName the new user name
	 * @param newPassword the new password
	 * @param token the token for adding credential to a user
	 * @param permission the permission for adding credential to a user
	 * @throws AuthenticationException an authentication exception
	 * @throws InvalidAccessTokenException an invalid access token exception
	 */
	protected void addCredential(String userId, String newName, String newPassword, UUID token, String permission) throws AuthenticationException, InvalidAccessTokenException {
		if (checkTokenPermission(token, permission)) {
			if(UserData.getInstance().getUserMap().containsKey(userId)) {
				if(!UserData.getInstance().getUserMap().get(userId).getCredentials().containsKey(newName)) {
					UserData.getInstance().getUserMap().get(userId).addCredential(newName, MD5(newPassword));
				} else {
					throw new AuthenticationException("User name " + newName + " already exists and cannot be added to " + userId + ".");
				}
			} else {
				throw new AuthenticationException("User ID " + userId + " does not exist, " + newName + " cannot be added to it.");
			}
		} else {
			throw new InvalidAccessTokenException(permission);
		}
	}

	/**
	 * Change password for a token's holder.
	 *
	 * @param token the token for changing the holder's password
	 * @param password the new password
	 * @throws InvalidAccessTokenException an invalid access token exception
	 * @throws AccessDeniedException an access denied exception
	 */
	public void changePassword(UUID token, String password) throws InvalidAccessTokenException, AccessDeniedException {
		if (TokenData.getInstance().containsKey(token)) {
			if (TokenData.getInstance().get(token).checkToken()) {
				String username = TokenData.getInstance().get(token).getUsername();
				Iterator<Entry<String, User>> iter = UserData.getInstance().getUserMap().entrySet().iterator();
				while (iter.hasNext()) {
					User user = iter.next().getValue();
					if(user.getCredentials().containsKey(username)) {
						user.getCredentials().put(username, MD5(password));
					}
				}
			} else {
				throw new InvalidAccessTokenException("Expired");
			}
		} else {
			throw new AccessDeniedException("Token " + token + " does not exist.");
		}
	}

	/**
	 * Adds entitlement to a user.
	 *
	 * @param userId the user's id
	 * @param entitlementId the entitlement's id
	 * @param token the token for adding entitlement to a user
	 * @param permission the permission for adding entitlement to a user
	 * @throws AuthenticationException an authentication exception
	 * @throws InvalidAccessTokenException an invalid access token exception
	 */
	protected void addEntitlementToUser(String userId, String entitlementId, UUID token, String permission) throws AuthenticationException, InvalidAccessTokenException {
		if (checkTokenPermission(token, permission)) {
			if(UserData.getInstance().getUserMap().containsKey(userId)) {
				if(EntitlementData.getInstance().getEntitlementMap().containsKey(entitlementId)) {
					if(!UserData.getInstance().getUserMap().get(userId).getEntitlements().contains(entitlementId)) {
						UserData.getInstance().getUserMap().get(userId).addEntitlement(entitlementId);
					} else {
						throw new AuthenticationException("Entitlement " + entitlementId + " already exists for user " + userId + ".");
					}
				} else {
					throw new AuthenticationException("Entitlement " + entitlementId + " does not exist and cannot be added to user " + userId + ".");
				}
			} else {
				throw new AuthenticationException("User " + userId + " does not exist, " + entitlementId + " cannot be added to it.");
			}
		} else {
			throw new InvalidAccessTokenException(permission);
		}
	}

	/**
	 * Login using a user name and a password.
	 *
	 * @param username the user name
	 * @param password the password
	 * @return the uuid token
	 * @throws AccessDeniedException an access denied exception
	 */
	public UUID login(String username, String password) throws AccessDeniedException {
		UUID token = null;
		Iterator<Entry<String, User>> iter = UserData.getInstance().getUserMap().entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, User> entry = iter.next();
			User user = entry.getValue();
			if(user.getCredentials().containsKey(username)) {
				if(user.getCredentials().get(username).equals(MD5(password))) {
					token = UUID.randomUUID();
					Creator creator = new Creator();						
					TokenData.getInstance().put(token, creator.createToken(token, username, System.currentTimeMillis()));
					return token;
				} else {
					throw new AccessDeniedException("Password for " + username + " is incorrect.");
				}
			}
		}
		if(token == null) {
			throw new AccessDeniedException("User name " + username + " does not exist.");
		}
		return token;
	}

	/**
	 * Logout from a user name.
	 *
	 * @param username the user name to be logged out
	 * @throws AccessDeniedException an access denied exception
	 */
	public void logout(String username) throws AccessDeniedException {
		int found = 0;
		Iterator<Entry<String, User>> iter = UserData.getInstance().getUserMap().entrySet().iterator();
		while (iter.hasNext()) {
			User user = iter.next().getValue();
			if (user.getCredentials().containsKey(username)) {
				found++;
				Iterator<Entry<UUID, Token>> iterator = TokenData.getInstance().entrySet().iterator();
				while (iterator.hasNext()) {
					Token tokenInfo = iterator.next().getValue();
					if (tokenInfo.getUsername().equals(username)) {
						iterator.remove();
					}
				}
			}
		}
		if(found == 0) {
			throw new AccessDeniedException("User name " + username + " does not exist.");
		}
	}

	/**
	 * Gets a token's permissions.
	 *
	 * @param token the token
	 * @return the token's permissions
	 */
	private List<String> getTokenPermissions(UUID token) {
		List<String> permissions = new ArrayList<String>();
		String username = TokenData.getInstance().get(token).getUsername();
		Iterator<Entry<String, User>> iter = UserData.getInstance().getUserMap().entrySet().iterator();
		while (iter.hasNext()) {
			User user = iter.next().getValue();
			if(user.getCredentials().containsKey(username)) {
				for(String entitlement : user.getEntitlements()) {
					Iterator iterator = EntitlementData.getInstance().getEntitlementMap().get(entitlement).getIterator();
					while (iterator.hasNext()) {
						Entitlement ent = (Entitlement)iterator.next();
						if(ent instanceof Permission) {
							if(!permissions.contains(ent.getId())) {
								permissions.add(ent.getId());
							}
						}
					}
				}
				break;
			}
		}
		return permissions;
	}

	/**
	 * Check a token with respect to a permission.
	 *
	 * @param token the token to be checked
	 * @param permission the permission needed
	 * @return true, if token has such permission
	 */
	public boolean checkTokenPermission(UUID token, String permission) {
		List<String> permissions = new ArrayList<String>();
		try {
			if (TokenData.getInstance().containsKey(token)) {
				if (TokenData.getInstance().get(token).checkToken()) {
					permissions = getTokenPermissions(token);
					if (permissions.contains(permission) || permissions.contains("root")) {
						return true;
					} else {
						return false;
					}
				} else {
					throw new InvalidAccessTokenException("Expired");
				}
			} else {
				throw new AccessDeniedException("Token " + token + " does not exist.");
			}
		} catch(InvalidAccessTokenException ex) {
			System.out.println(ex);
		} catch(AccessDeniedException ex) {
			System.out.println(ex);
		}
		return false;
	}

	/**
	 * Compute MD5 value from a string, taken from http://stackoverflow.com/questions/415953/generate-md5-hash-in-java
	 * by dac2009
	 *
	 * @param md5 the string to be hashed
	 * @return the MD5sum string
	 */
	protected String MD5(String md5) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}
		return null;
	}
}
