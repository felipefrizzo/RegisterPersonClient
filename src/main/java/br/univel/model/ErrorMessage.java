package br.univel.model;

import java.io.Serializable;

/**
 * Created by felipefrizzo on 27/11/16.
 */
public class ErrorMessage implements Serializable{

    private static final long serialVersionUID = 1L;

    private Boolean error;
    private String errorText;

    public Boolean getError() {
        return error;
    }

    public void setError(final Boolean error) {
        this.error = error;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(final String errorText) {
        this.errorText = errorText;
    }
}
