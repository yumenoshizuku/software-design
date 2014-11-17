package cscie97.asn3.ecommerce.collection;
import cscie97.asn3.ecommerce.product.*;

import java.util.Map;
import java.util.Iterator;

/**
 * The Class DynamicCollection that overrides operations specific to dynamic collections 
 * @author Fanxing Meng
 * @version 2.4 2013/10/30
 */
public class DynamicCollection extends Collection {
	
	/** The search criteria for a dynamic collection. */
	private String searchCriteria;
	
	/**
	 * Instantiates a new dynamic collection.
	 *
	 * @param newName the new name
	 * @param newDescription the new description
	 */
	public DynamicCollection(String newName, String newDescription) {
		name = newName;
		description = newDescription;
		type = "Dynamic";
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#setCriteria(java.lang.String)
	 */
	public void setCriteria(String newCriteria) {
		searchCriteria = newCriteria;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#update()
	 */
	public void update() {
		allChild.clear();
		for(String collection : childCollections) {
			allChild.put(collection, CollectionData.getInstance().get(collection));
		}
		Map<String, Product> queryResult = QueryEngine.executeQuery(searchCriteria, CountryData.getInstance(), DeviceData.getInstance(), ProductData.getInstance());
		allChild.putAll(queryResult);
	}
	
}
