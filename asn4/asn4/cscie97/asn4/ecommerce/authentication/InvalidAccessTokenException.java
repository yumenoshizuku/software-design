package cscie97.asn4.ecommerce.authentication;

/**
 * The Class InvalidAccessTokenException.
 * @author Fanxing Meng
 * @version 1.1 2013/11/20
 */
public class InvalidAccessTokenException extends Exception {
	
    /** The error content. */
    private String errorContent;
    
    /**
     * Instantiates a new invalid access token exception.
     */
    public InvalidAccessTokenException() {

    }

    /**
     * Instantiates a new invalid access token exception with a message.
     *
     * @param message the message
     */
    public InvalidAccessTokenException(String message) {
        super(message);
        errorContent = message;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Throwable#toString()
     */
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append("Invalid access token for: " + errorContent);

        if (getCause() != null) {
            message.append(getCause());
        }
        return message.toString();
    }
}
