/**
 * 
 */
package cscie97.asn4.ecommerce.authentication;

import java.util.Iterator;

/**
 * The Class PermissionIterator.
 * @author Fanxing Meng
 * @version 1.0 2013/11/13
 */
public class PermissionIterator implements Iterator {

	/**
	 * The next element at the end of entitlement tree, which has none.
	 *
	 * @return the object
	 */
	public Object next() {
		return null;
	}
	
	/**
	 * Whether there is a next element at the end of entitlement tree, which is false.
	 *
	 * @return true, if successful
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
