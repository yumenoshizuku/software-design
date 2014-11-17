package cscie97.asn4.ecommerce.collection;

import java.util.Iterator;

/**
 * The Class NullIterator.
 * @author Fanxing Meng
 * @version 1.0 2013/10/28
 */
public class NullIterator implements Iterator {

	/**
	 * The next element at the end of collectable tree, which has none. 
	 */
	public Object next() {
		return null;
	}
	
	/**
	 * Whether there is a next element at the end of collectable tree, which is false. 
	 */
	public boolean hasNext() {
		return false;
	}
	
	/**
	 * Remove operation is not supported.
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
