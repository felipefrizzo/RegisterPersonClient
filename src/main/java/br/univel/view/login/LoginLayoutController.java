package br.univel.view.login;

import br.univel.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * Created by felipefrizzo on 16/11/16.
 */
public class LoginLayoutController {

    private Main main;

    @FXML
    private TextField textFieldUsername;

    @FXML
    private TextField textFieldPassword;

    public void setMain(final Main main) {
        this.main = main;
    }

    @FXML
    void handleLogin(final ActionEvent event) {

    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (textFieldUsername.getText() == null || textFieldUsername.getText().length() == 0) {
            errorMessage += "No valid Username! \n";
        }
        if (textFieldPassword.getText() == null || textFieldPassword.getText().length() == 0) {
            errorMessage += "No valid Password! \n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            showError(
                "Invalid Fields",
                "Please correct invalid fields.",
                errorMessage,
                Alert.AlertType.ERROR
            );

            return false;
        }
    }

    public void showError(final String title, final String headerText, final String contentText, final Alert.AlertType type) {
        final Alert alert = new Alert(type);
        alert.initOwner(main.getPrimaryStage());
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }
}
