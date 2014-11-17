
package cscie97.asn4.ecommerce.authentication;

/**
 * The Class AuthenticationException.
 * @author Fanxing Meng
 * @version 1.1 2013/11/20
 */
public class AuthenticationException extends Exception {

    /**
     * Instantiates a new authentication exception.
     */
    public AuthenticationException() {

    }

    /**
     * Instantiates a new authentication exception with a message.
     *
     * @param message the message
     */
    public AuthenticationException(String message) {
        super(message);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Throwable#toString()
     */
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append("Authentication Exception: ");

        if (getCause() != null) {
            message.append(getCause());
        }
        return message.toString();
    }
}
