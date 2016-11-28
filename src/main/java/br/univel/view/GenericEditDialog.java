package br.univel.view;

import br.univel.Main;
import br.univel.client.RequestClient;
import javafx.scene.control.Alert;

/**
 * Created by felipefrizzo on 16/11/16.
 */
public interface GenericEditDialog {

    /**
     *
     * @param main set the Main instance.
     */
    void setMain(final Main main);

    /**
     *
     * @param client set the ClientSocket instance.
     */
    void setClient(final RequestClient client);

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
     * Show server validation or back to Overview.
     *
     * @param object
     */
    void serverValidation(Object object);

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
