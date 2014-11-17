package cscie97.asn3.ecommerce.collection;

/**
 * The Class CreateStaticCollection that creates a static collection
 * @author Fanxing Meng
 * @version 1.0 2013/10/30
 */
public class CreateStaticCollection implements CreateCollection {

	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.CreateCollection#createCollection()
	 */
	@Override
	public Collection createCollection(String newName, String newDescription) {
		return new StaticCollection(newName, newDescription);
	}

}
