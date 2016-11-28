package br.univel.view;

import br.univel.Main;
import br.univel.client.RequestClient;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by felipefrizzo on 15/11/16.
 */
public interface GenericOverviewLayout {

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
     * Called when user clicks in button to create a new Object.
     *
     * @param event
     */
    void handleNew(final ActionEvent event);

    /**
     * Called when user clicks in button to edit a Object.
     *
     * @param event
     */
    void handleEdit(final ActionEvent event);

    /**
     * * Called when user clicks in button to delete a Object.
     *
     * @param event
     */
    void handleDelete(final ActionEvent event);

    /**
     * Show error Message.
     *
     * @param title
     * @param headerText
     * @param contentText
     * @param type
     */
    Optional<ButtonType> showError(final String title, final String headerText, final String contentText, Alert.AlertType type);

}
