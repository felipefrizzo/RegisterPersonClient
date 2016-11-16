package br.univel.view;

import br.univel.Main;
import javafx.scene.control.Alert;

/**
 * Created by felipefrizzo on 16/11/16.
 */
public interface AbstractEditDialog {

    void setMain(final Main main);

    /**
     * Called when user clicks in Save.
     */
    void handleSave();

    /**
     * Called when user clicks Cancel.
     */
    void handleCancel();

    /**
     * Validate the user input in the Text Fields.
     *
     * @return true if input is valid
     */
    boolean isInputValid();

    /**
     * Show the error Message.
     *
     * @param title
     * @param headerText
     * @param contentText
     * @param type
     */
    void showError(final String title, final String headerText, final String contentText, Alert.AlertType type);

}
