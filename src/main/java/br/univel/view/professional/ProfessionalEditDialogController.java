package br.univel.view.professional;

import br.univel.Main;
import br.univel.client.RequestClient;
import br.univel.client.socket.ClientSocket;
import br.univel.view.GenericEditDialog;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * Created by felipefrizzo on 16/11/16.
 */
public class ProfessionalEditDialogController implements GenericEditDialog {

    private Main main;
    private RequestClient client;

    @FXML
    private TextField textFieldName;

    @FXML
    private DatePicker datePickerBirthday;

    @FXML
    private TextField textFieldUsername;

    @FXML
    private TextField textFieldPassword;

    @Override
    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void setClient(RequestClient client) {
        this.client = client;
    }

    @Override
    @FXML
    public void handleSave() {

    }

    @Override
    @FXML
    public void handleCancel() {

    }

    @Override
    public boolean isInputValid() {
        String errorMessage = "";

        if (textFieldName.getText() == null || textFieldName.getText().length() == 0) {
            errorMessage += "No valid Name! \n";
        }
        if (datePickerBirthday.getValue() == null) {
            errorMessage += "No valid Birthday! \n";
        }
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

    @Override
    public void showError(final String title, final String headerText, final String contentText, final Alert.AlertType type) {
        final Alert alert = new Alert(type);
        alert.initOwner(main.getPrimaryStage());
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }
}
