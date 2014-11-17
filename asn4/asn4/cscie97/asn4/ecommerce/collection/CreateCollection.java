package cscie97.asn4.ecommerce.collection;

/**
 * The Abstract Interface CreateCollection that sets how to create a collection
 * @author Fanxing Meng
 * @version 1.0 2013/10/30
 */
public interface CreateCollection {
	/**
	 * The Abstract method createCollection that uses name and description to create a collection
	 * 
	 * @param newName the new name
	 * @param newDescription the new description
	 */
	abstract Collection createCollection(String newName, String newDescription);
}
