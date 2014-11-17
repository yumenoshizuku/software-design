package cscie97.asn4.ecommerce.collection;

/**
 * The Class CreateDynamicCollection that creates a dynamic collection
 * @author Fanxing Meng
 * @version 1.0 2013/10/30
 */
public class CreateDynamicCollection implements CreateCollection {

	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.CreateCollection#createCollection(java.lang.String, java.lang.String)
	 */
	@Override
	public Collection createCollection(String newName, String newDescription) {
		return new DynamicCollection(newName, newDescription);
	}

}
