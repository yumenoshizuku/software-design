package cscie97.asn3.ecommerce.collection;
import cscie97.asn3.ecommerce.product.*;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 * The Class CollectionData.
 * @author Fanxing Meng
 * @version 1.4 2013/10/29
 */
public class CollectionData {

	/** The singleton collection map. */
	private static Map<String, Collection> collectionMap = new HashMap<String, Collection>();
	
	/**
	 * A check token function that verifies if a user has the privileges 
	 * needed to perform maintenance. It takes a string type token and returns
	 * true on validation and false if it does not match.
	 *
	 * @param token a password that is provided by the user
	 * @return true, if password valid; false, if invalid
	 */
	private static boolean checkToken(String token){
		return true;
	}
	
	/**
	 * Define a collection .
	 *
	 * @param newType the new type
	 * @param newId the new id
	 * @param newName the new name
	 * @param newDescription the new description
	 * @param token the token
	 */
	public static void defineCollection(String newType, String newId, String newName, String newDescription, String token) {
		try {
			if(checkToken(token)) {
				if(collectionMap.containsKey(newId)) {
					throw new Exception("Collection ID " + newId + " already exists.");
				} else if(newType.equalsIgnoreCase("static")) {
					CreateCollection creater = new CreateStaticCollection();
					collectionMap.put(newId, creater.createCollection(newName, newDescription));
				} else if(newType.equalsIgnoreCase("dynamic")) {
					CreateCollection creater = new CreateDynamicCollection();
					collectionMap.put(newId, creater.createCollection(newName, newDescription));
				} else {
					throw new Exception("Collection type " + newType + " is invalid.");
				}
			} else {
				throw new Exception("Invalid access token, collection info not added.");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}
	
	/**
	 * Adds content ID to static collection.
	 *
	 * @param collectionId the collection id
	 * @param contentType the content type
	 * @param contentId the content id
	 * @param token the token
	 */
	public static void addCollectionContent(String collectionId, String contentType, String contentId, String token) {
		try {
			if(checkToken(token)) {
				if(collectionMap.containsKey(collectionId)) {
					if(contentType.equalsIgnoreCase("product") && ProductData.getInstance().containsKey(contentId)) {
						collectionMap.get(collectionId).addContent(contentId);
					} else if(contentType.equalsIgnoreCase("collection") && collectionMap.containsKey(contentId)) {
						collectionMap.get(collectionId).addCollection(contentId);
					} else {
						throw new Exception("Content ID " + contentId + " does not exist or content type " + contentType + " is invalid.");
					}
				} else {
					throw new Exception("Does not have collection " + collectionId + ". Define it first.");
				}
			} else {
				throw new Exception("Invalid access token, collection content not updated.");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}
	
	/**
	 * Sets the search criteria for dynamic collection.
	 *
	 * @param collectionId the collection id
	 * @param newCriteria the new criteria
	 * @param token the token
	 */
	public static void setDynamicCriteria(String collectionId, String newCriteria, String token) {
		try {
			if(checkToken(token)) {
				if(collectionMap.containsKey(collectionId)) {
					collectionMap.get(collectionId).setCriteria(newCriteria);
				} else {
					throw new Exception("Does not have collection " + collectionId + ". Define it first.");
				}
			} else {
				throw new Exception("Invalid access token, collection content not updated.");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}
	
	/**
	 * Gets the single instance of CollectionData.
	 *
	 * @return collectionMap single instance of CollectionData
	 */
	public static Map<String, Collection> getInstance(){
		return collectionMap;
	}
	

	/**
	 * Search for text fields in all collections.
	 *
	 * @param criteria the search criteria
	 * @return the map
	 */
	public static Map<String, Collection> searchCollections(String criteria) {
		System.out.println("Search result for \"" + criteria + "\" with cascaded collections is:");
		Map<String, Collection> result = new HashMap<String, Collection>();
		Iterator iter = collectionMap.entrySet().iterator();
		while (iter.hasNext()) {
    		Map.Entry entry = (Map.Entry) iter.next();
    		String key = (String) entry.getKey();
    		Collection coll = (Collection) entry.getValue();
    		if(coll.getName().toLowerCase().contains(criteria.toLowerCase()) || coll.getDescription().toLowerCase().contains(criteria.toLowerCase())) {
    			result.put(key, coll);
    			coll.printCascade();
    		}
		}
		return result;
	}
	
	/**
	 * Gets the default iterator over all existing collections.
	 *
	 * @return the iterator
	 */
	public static Iterator getIterator() {
		return collectionMap.values().iterator();
	}

}
