/* Copyright 2015 Roychoudhury, Abhishek */

package org.codeavengers.main.web;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * TODO
 * 
 * @author abhishek
 * @since 1.0
 */
public abstract class BaseController {
    /**
     * <p>
     * Gets the stack trace from a Throwable as a String.
     * </p>
     *
     * <p>
     * The result of this method vary by JDK version as this method uses
     * {@link Throwable#printStackTrace(java.io.PrintWriter)}. On JDK1.3 and
     * earlier, the cause exception will not be shown unless the specified
     * throwable alters printStackTrace.
     * </p>
     *
     * @param throwable
     *            the <code>Throwable</code> to be examined
     * @return the stack trace as generated by the exception's
     *         <code>printStackTrace(PrintWriter)</code> method
     */
    public String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
}
