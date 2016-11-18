package br.univel.view;

import br.univel.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

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
    void showError(final String title, final String headerText, final String contentText, Alert.AlertType type);

}
