
package com.jecelyin.common.github;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Exception class to be thrown when iterating over pages fails. This exception
 * wraps an {@link IOException} that is the actual exception that occurred when
 * the page request was made.
 */
public class NoSuchPageException extends NoSuchElementException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6795637952359586293L;

    /**
     * Cause exception
     */
    protected final IOException cause;

    /**
     * Create no such page exception
     *
     * @param cause
     */
    public NoSuchPageException(IOException cause) {
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return cause != null ? cause.getMessage() : super.getMessage();
    }

    @Override
    public IOException getCause() {
        return cause;
    }
}
