
package com.jecelyin.common.github;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;


/**
 * Request exception class that wraps a {@link RequestError} object.
 */
public class RequestException extends IOException {

    private static final String FIELD_INVALID_WITH_VALUE = "Invalid value of ''{0}'' for ''{1}'' field"; //$NON-NLS-1$

    private static final String FIELD_INVALID = "Invalid value for ''{0}'' field"; //$NON-NLS-1$

    private static final String FIELD_MISSING = "Missing required ''{0}'' field"; //$NON-NLS-1$

    private static final String FIELD_ERROR = "Error with ''{0}'' field in {1} resource"; //$NON-NLS-1$

    private static final String FIELD_EXISTS = "{0} resource with ''{1}'' field already exists"; //$NON-NLS-1$

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1197051396535284852L;

    private final RequestError error;
    private final int status;

    /**
     * Create request exception
     *
     * @param error
     * @param status
     */
    public RequestException(RequestError error, int status) {
        super();
        this.error = error;
        this.status = status;
    }

    public String getMessage() {
        return error != null ? formatErrors() : super.getMessage();
    }

    /**
     * Get error
     *
     * @return error
     */
    public RequestError getError() {
        return error;
    }

    /**
     * Get status
     *
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Format field error into human-readable message
     *
     * @param error
     * @return formatted field error
     */
    protected String format(FieldError error) {
        String code = error.getCode();
        String value = error.getValue();
        String field = error.getField();

        if (FieldError.CODE_INVALID.equals(code))
            if (value != null)
                return MessageFormat.format(FIELD_INVALID_WITH_VALUE, value,
                        field);
            else
                return MessageFormat.format(FIELD_INVALID, field);

        if (FieldError.CODE_MISSING_FIELD.equals(code))
            return MessageFormat.format(FIELD_MISSING, field);

        if (FieldError.CODE_ALREADY_EXISTS.equals(code))
            return MessageFormat.format(FIELD_EXISTS, error.getResource(),
                    field);

        // Use field error message as is if custom code
        if (FieldError.CODE_CUSTOM.equals(code)) {
            String message = error.getMessage();
            if (message != null && message.length() > 0)
                return message;
        }

        return MessageFormat.format(FIELD_ERROR, field, error.getResource());
    }

    /**
     * Format all field errors into single human-readable message.
     *
     * @return formatted message
     */
    public String formatErrors() {
        String errorMessage = error.getMessage();
        if (errorMessage == null)
            errorMessage = ""; //$NON-NLS-1$
        StringBuilder message = new StringBuilder(errorMessage);
        if (message.length() > 0)
            message.append(' ').append('(').append(status).append(')');
        else
            message.append(status);
        List<FieldError> errors = error.getErrors();
        if (errors != null && errors.size() > 0) {
            message.append(':');
            for (FieldError fieldError : errors)
                message.append(' ').append(format(fieldError)).append(',');
            message.deleteCharAt(message.length() - 1);
        }
        return message.toString();
    }
}
