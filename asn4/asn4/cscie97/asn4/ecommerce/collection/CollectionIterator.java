package cscie97.asn4.ecommerce.collection;

import java.util.*;

/**
 * The Class CollectionIterator.
 * @author Fanxing Meng
 * @version 1.2 2013/10/28
 */
public class CollectionIterator implements Iterator {
	
	/** The stack of iterators. */
	Stack stack = new Stack();
	
	/**
	 * Instantiates a new collection iterator by putting a top level iterator
	 * onto the stack.
	 *
	 * @param iter the iter
	 */
	public CollectionIterator(Iterator iter) {
		stack.push(iter);
	}
	
	/**
	 * The next element at a node of the collectable tree. Call hasNext()
	 * to see if there is one. If so, get the next element of the top iterator.
	 * If this element is a collection, put its child iterator onto the stack.
	 */
	public Object next() {
		if(hasNext()) {
			Iterator iter = (Iterator) stack.peek();
			Collectable coll = (Collectable) iter.next();
			if (coll instanceof Collection) {
				stack.push(coll.getIterator());
			}
			return coll;
		} else {
			return null;
		}
	}
	
	/**
	 * Whether there is a next element at a node of the collectable tree.
	 * Test the top of the stack for existence of non-traversed elements.
	 * If there is, get the top iterator and see if it has a next element.
	 * If not, pop it out and call hasNext() recursively until reaches a
	 * next element.
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
