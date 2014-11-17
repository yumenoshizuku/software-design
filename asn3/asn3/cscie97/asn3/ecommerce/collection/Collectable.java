package cscie97.asn3.ecommerce.collection;
import java.net.*;
import java.util.Iterator;

/**
 * @author Fanxing Meng
 * @version 1.3 2013/10/30
 */
public abstract class Collectable {
	
	/**
	 * Get type of product or collection.
	 *
	 * @return the type
	 */
	public String getType(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Get name of product or collection.
	 *
	 * @return the name
	 */
	public String getName(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Get description of product or collection.
	 *
	 * @return the description
	 */
	public String getDescription(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Get author of product.
	 *
	 * @return the author
	 */
	public String getAuthor(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Get rating of product.
	 *
	 * @return the rating
	 */
	public int getRating(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Get categories of product.
	 *
	 * @return the categories
	 */
	public String getCategories(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Get exporting countries of product.
	 *
	 * @return the countries
	 */
	public String getCountries(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Get supported devices of product.
	 *
	 * @return the devices
	 */
	public String getDevices(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Get price of product.
	 *
	 * @return the price
	 */
	public float getPrice(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Get languages of product.
	 *
	 * @return the languages
	 */
	public String getLanguages(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Get image URL of product.
	 *
	 * @return the image URL
	 */
	public URL getImageURL(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Get size of product, -1 for non-apps.
	 *
	 * @return the size
	 */
	public int getSize(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Get text field of product.
	 *
	 * @return the text
	 */
	public String text(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Print formatted string of product or collection information.
	 */
	public void print(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Print formatted string of collection information with all its children.
	 */
	public void printCascade(){
		throw new UnsupportedOperationException();
	}

	/**
	 * Updates static collection by content ID list or dynamic collection by criteria.
	 */
	public void update() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Get iterator of collections and products.
	 *
	 * @return collection iterator for collection; null iterator for product
	 */
	public Iterator getIterator() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Add a child collection to current collection. 
	 *
	 * @param newId collection Id of child collection
	 */
	public void addCollection(String newId) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Add a product ID to current static collection.
	 *
	 * @param newId content Id of belonging product
	 */
	public void addContent(String newId) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Set the search criteria for current dynamic collection.
	 *
	 * @param newCriteria new search criteria
	 */
	public void setCriteria(String newCriteria) {
		throw new UnsupportedOperationException();
	}
}
