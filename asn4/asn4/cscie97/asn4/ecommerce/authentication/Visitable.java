package cscie97.asn4.ecommerce.authentication;

/**
 * The Interface Visitable.
 * @author Fanxing Meng
 * @version 1.0 2013/11/20
 */
public interface Visitable {
	
	/**
	 * Accept a visitor, to be implemented by all visitable classes.
	 *
	 * @param visitor the visitor to be passed into each object
	 */
	public void accept(Visitor visitor);
}
