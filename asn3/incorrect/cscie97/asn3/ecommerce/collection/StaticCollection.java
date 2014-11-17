package cscie97.asn3.ecommerce.collection;

import java.util.ArrayList;
import java.util.List;

import cscie97.asn3.ecommerce.product.ProductData;

/**
 * The Class StaticCollection that overrides operations specific to static collections 
 * @author Fanxing Meng
 * @version 2.3 2013/10/30
 */
public class StaticCollection extends Collection {
	
	/** The content IDs of a static collection. */
	private List<String> contentIds = new ArrayList<String>();
	
	/**
	 * Instantiates a new static collection.
	 *
	 * @param newName the new name
	 * @param newDescription the new description
	 */
	public StaticCollection(String newName, String newDescription) {
		name = newName;
		description = newDescription;
		type = "Static";
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#addContent(java.lang.String)
	 */
	public void addContent(String newId) {
		try {
			if(!contentIds.contains(newId)) {
				if(ProductData.getInstance().containsKey(newId)) {
					contentIds.add(newId);
				} else {
					throw new Exception("Product " + newId + " does not exist.");
				}
			} else {
				throw new Exception("Product " + newId + " already exists in " + name + ".");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#update()
	 */
	public void update() {
		allChild.clear();
		for(String collection : childCollections) {
			allChild.put(collection, CollectionData.getInstance().get(collection));
		}
		try {
			for(String product : contentIds) {
				if(ProductData.getInstance().containsKey(product)) {
					allChild.put(product, ProductData.getInstance().get(product));
				} else {
					throw new Exception("Product " + product + " no longer exists.");
				}
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}
}
