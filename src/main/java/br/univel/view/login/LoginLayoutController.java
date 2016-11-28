package br.univel.view.login;

import br.univel.Main;
import br.univel.client.RequestClient;
import br.univel.enums.OperationType;
import br.univel.model.ErrorMessage;
import br.univel.model.Professional;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.Objects;

/**
 * Created by felipefrizzo on 16/11/16.
 */
public class LoginLayoutController {

    private Main main;
    private RequestClient client;

    @FXML
    private TextField textFieldUsername;

    @FXML
    private TextField textFieldPassword;

    /**
     *
     * @param main the main instance to set.
     */
    public void setMain(final Main main) {
        Objects.requireNonNull(main, "Main cannot be null");

        this.main = main;
    }

    public void setClient(final RequestClient client) {
        Objects.requireNonNull(client, "Client cannot be null");
        this.client = client;
    }

    @FXML
    void handleLogin() {
        if (isInputValid()) {
            Professional professional = new Professional();
            professional.setOperationType(OperationType.LOGIN);
            professional.setUsername(textFieldUsername.getText());
            professional.setPassword(textFieldPassword.getText());

            Object object = this.client.sendObject(professional);

            serverValidation(object);
        }
    }

    private boolean isInputValid() {
        StringBuilder errorMessage = new StringBuilder();

        if (textFieldUsername.getText() == null || textFieldUsername.getText().length() == 0) {
            errorMessage.append("No valid Username! \n");
        }
        if (textFieldPassword.getText() == null || textFieldPassword.getText().length() == 0) {
            errorMessage.append("No valid Password! \n");
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            showError(
                "Invalid Fields",
                "Please correct invalid fields.",
                errorMessage.toString(),
                Alert.AlertType.ERROR
            );

            return false;
        }
    }

    public void serverValidation(final Object object) {
        Objects.requireNonNull(object, "Object cannot be null");

        if (object instanceof ErrorMessage) {
            ErrorMessage errorMessage = (ErrorMessage) object;
            if (errorMessage.getError()) {
                showError(
                    "Server Validation",
                    "Please correct invalid fields",
                    errorMessage.getErrorText(),
                    Alert.AlertType.ERROR
                );
            } else {
                this.main.showMainLayout();
            }
        }
    }

    private void showError(final String title, final String headerText, final String contentText, final Alert.AlertType type) {
        Objects.requireNonNull(title, "Title cannot be null");
        Objects.requireNonNull(headerText, "Header Text cannot be null");
        Objects.requireNonNull(contentText, "Content Text cannot be null");
        Objects.requireNonNull(type, "Type cannot be null");

        final Alert alert = new Alert(type);
        alert.initOwner(main.getPrimaryStage());
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }
}
