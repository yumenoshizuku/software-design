
package cscie97.asn4.ecommerce.authentication;

/**
 * The Class AccessDeniedException.
 * @author Fanxing Meng
 * @version 1.1 2013/11/20
 */
public class AccessDeniedException extends Exception {
	
    /**
     * Instantiates a new access denied exception.
     */
    public AccessDeniedException() {

    }

    /**
     * Instantiates a new access denied exception with a message.
     *
     * @param message the message
     */
    public AccessDeniedException(String message) {
        super(message);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Throwable#toString()
     */
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append("Access Denied: ");

        if (getCause() != null) {
            message.append(getCause());
        }
        return message.toString();
    }
}
