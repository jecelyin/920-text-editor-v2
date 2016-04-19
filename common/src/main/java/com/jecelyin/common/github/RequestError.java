
package com.jecelyin.common.github;

import java.io.Serializable;
import java.util.List;

/**
 * GitHub request error class
 */
public class RequestError implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7842670602124573940L;

    // This field is required for legacy v2 error support
    private String error;

    private String message;

    private List<FieldError> errors;

    /**
     * @return message
     */
    public String getMessage() {
        return message != null ? message : error;
    }

    /**
     * Get errors
     *
     * @return list of errors
     */
    public List<FieldError> getErrors() {
        return errors;
    }
}
