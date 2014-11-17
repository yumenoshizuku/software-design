package cscie97.asn4.ecommerce.collection;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Class Collection.
 * @author Fanxing Meng
 * @version 3.4 2013/10/30
 */
public abstract class Collection extends Collectable {
	
	/** The name. */
	protected String name;
	
	/** The description. */
	protected String description;
	
	/** The type. */
	protected String type;
	
	/** The child collections. */
	protected List<String> childCollections = new ArrayList<String>();
	
	/** All child elements including collections and static content / dynamic searched results. */
	protected Map<String, Collectable> allChild = new HashMap<String, Collectable>();
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#addCollection(java.lang.String)
	 */
	public void addCollection(String newId) {
		try {
			if(!childCollections.contains(newId) && !name.equalsIgnoreCase(newId)) {
				childCollections.add(newId);
			} else {
				throw new Exception("Collection content " + newId + " already exists in " + name + ".");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#print()
	 */
	public void print() {
		System.out.println("--------------------");
		System.out.println(type + " Collection: " + name + "\n" + description);
		System.out.println("--------------------");
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#printCascade()
	 */
	public void printCascade() {
		System.out.println("--------------------");
		System.out.println(type + " Collection: " + name + "\n" + description);
		System.out.println("--------------------");
		update();
		Iterator iterator = allChild.values().iterator();
		while (iterator.hasNext()) {
			Collectable coll = (Collectable)iterator.next();
			coll.printCascade();
		}
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getDescription()
	 */
	public String getDescription() {
		return description;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getType()
	 */
	public String getType() {
		return type;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getIterator()
	 */
	public Iterator getIterator() {
		update();
		return new CollectionIterator(allChild.values().iterator());
	}
}
