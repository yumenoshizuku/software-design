/**
 * 
 */
package cscie97.asn4.ecommerce.authentication;

import java.util.Iterator;
import java.util.Stack;

/**
 * The Class RoleIterator.
 * @author Fanxing Meng
 * @version 1.0 2013/11/13
 */
public class RoleIterator implements Iterator {
	
	/** The stack of iterators. */
	Stack stack = new Stack();
	
	/**
	 * Instantiates a new role iterator by putting a top level iterator
	 * onto the stack.
	 *
	 * @param iter the iter
	 */
	public RoleIterator(Iterator iter) {
		stack.push(iter);
	}
	
	/**
	 * The next element at a node of the entitlement tree. Call hasNext()
	 * to see if there is one. If so, get the next element of the top iterator.
	 * If this element is a role, put its child iterator onto the stack.
	 *
	 * @return the object
	 */
	public Object next() {
		if(hasNext()) {
			Iterator iter = (Iterator) stack.peek();
			Entitlement ent = (Entitlement) iter.next();
			if (ent instanceof Role) {
				stack.push(ent.getIterator());
			}
			return ent;
		} else {
			return null;
		}
	}
	
	/**
	 * Whether there is a next element at a node of the entitlement tree.
	 * Test the top of the stack for existence of non-traversed elements.
	 * If there is, get the top iterator and see if it has a next element.
	 * If not, pop it out and call hasNext() recursively until reaches a
	 * next element.
	 *
	 * @return true, if successful
	 */
	public boolean hasNext() {
		if(stack.empty()) {
			return false;
		} else {
			Iterator iter = (Iterator) stack.peek();
			if(!iter.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}
	
	/**
	 * Remove operation is not supported.
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
