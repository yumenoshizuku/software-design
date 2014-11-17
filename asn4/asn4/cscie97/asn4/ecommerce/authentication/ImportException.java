
package cscie97.asn4.ecommerce.authentication;

/**
 * The Class ImportException.
 * @author Fanxing Meng
 * @version 1.1 2013/11/20
 */
public class ImportException extends Exception {

    /** The error content. */
    private String errorContent;
    
    /** The authentication type. */
    private String authenticationType;
    
    /** The line number. */
    private int lineNumber = 0;

    /**
     * Instantiates a new import exception with an authentication type, a message and a cause.
     *
     * @param authenticationType the authentication type
     * @param message the message
     * @param cause the cause
     */
    public ImportException(String authenticationType, String message, Throwable cause) {
        super(message, cause);
        this.authenticationType = authenticationType;
    }

    /**
     * Instantiates a new import exception with an authentication type and a cause.
     *
     * @param authenticationType the authentication type
     * @param cause the cause
     */
    public ImportException(String authenticationType, Throwable cause) {
        super(cause);
        this.authenticationType = authenticationType;
    }

    /**
     * Instantiates a new import exception with an authentication type and a message.
     *
     * @param authenticationType the authentication type
     * @param message the message
     */
    public ImportException(String authenticationType, String message) {
        super(message);
        this.authenticationType = authenticationType;
    }

    /**
     * Instantiates a new import exception with an authentication type.
     *
     * @param authenticationType the authentication type
     */
    public ImportException(String authenticationType) {
        super();
        this.authenticationType = authenticationType;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#toString()
     */
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append("error importing authentication type: " + authenticationType + " at line number " + lineNumber + " with error authentication " + errorContent);

        if (getCause() != null) {
            message.append(getCause());
        }
        return message.toString();
    }

    /**
     * line that created import exception.
     *
     * @param errorContent the new error content
     */

    public void setErrorContent(String errorContent) {
        this.errorContent = errorContent;
    }

    /**
     * authentication type that generated error.
     *
     * @param authenticationType the new authentication type
     */

    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }

    /**
     * line number where exception occurred.
     *
     * @param lineNumber the new line number
     */

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
