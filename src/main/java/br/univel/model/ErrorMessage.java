package br.univel.model;

import java.io.Serializable;

/**
 * Created by felipefrizzo on 27/11/16.
 */
public class ErrorMessage implements Serializable{

    private static final long serialVersionUID = 1L;

    private Boolean error;
    private String errorText;

    /**
     *
     * @return The current value of this Error Message's Error
     */
    public Boolean getError() {
        return error;
    }

    /**
     *
     * @param error New Value for this Error Message's Error
     */
    public void setError(final Boolean error) {
        this.error = error;
    }

    /**
     *
     * @return The current value of this Error Message's Error Text
     */
    public String getErrorText() {
        return errorText;
    }

    /**
     *
     * @param errorText New Value for this Error Message's Error
     */
    public void setErrorText(final String errorText) {
        this.errorText = errorText;
    }
}
