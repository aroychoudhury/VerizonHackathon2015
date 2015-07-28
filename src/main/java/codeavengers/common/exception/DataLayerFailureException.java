/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.common.exception;

/**
 * This Class encapsulates all Data Layer exceptions. The Layer can be anything
 * like a File based Data Store, a RDBMS compliant Database or even a Cache.
 * 
 * @see java.lang.RuntimeException
 * @author abhishek
 * @since 1.0
 */
public class DataLayerFailureException extends RuntimeException {
    private static final long serialVersionUID = -2835088615510195966L;

    /**
     * @author abhishek
     * @since 1.0
     * @see java.lang.RuntimeException#RuntimeException()
     */
    public DataLayerFailureException() {
        super();
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see java.lang.RuntimeException#RuntimeException(String)
     */
    public DataLayerFailureException(String message) {
        super(message);
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see java.lang.RuntimeException#RuntimeException(String, Throwable)
     */
    public DataLayerFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see java.lang.RuntimeException#RuntimeException(Throwable)
     */
    public DataLayerFailureException(Throwable cause) {
        super(cause);
    }
}
