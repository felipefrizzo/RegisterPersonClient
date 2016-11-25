package br.univel.view.professional;

import br.univel.Main;
import br.univel.client.RequestClient;
import br.univel.enums.OperationType;
import br.univel.model.Professional;
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
    private Professional professional;
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
    public void setMain(final Main main) {
        this.main = main;
    }

    @Override
    public void setClient(final RequestClient client) {
        this.client = client;
    }

    /**
     *
     * @param professional set the Professional instance.
     */
    public void setProfessional(final Professional professional) {
        this.professional = professional;
        showProfessionalDetails();
    }

    private void showProfessionalDetails() {
        if (this.professional != null) {
            textFieldName.setText(this.professional.getName());
            datePickerBirthday.setValue(this.professional.getBirthday());
            textFieldUsername.setText(this.professional.getUsername());
            textFieldPassword.setText(this.professional.getPassword());
        } else {
            textFieldName.setText("");
            textFieldUsername.setText("");
            textFieldPassword.setText("");
            datePickerBirthday.setValue(null);
        }
    }

    @Override
    @FXML
    public void handleSave() {
        if (isInputValid()) {
            if (professional == null) {
                professional = new Professional();
                professional.setOperationType(OperationType.POST);
            } else {
                professional.setOperationType(OperationType.PUT);
            }
            professional.setName(textFieldName.getText());
            professional.setBirthday(datePickerBirthday.getValue());
            professional.setUsername(textFieldUsername.getText());
            professional.setPassword(textFieldPassword.getText());


            this.client.sendObject(professional);
        }
    }

    @Override
    @FXML
    public void handleCancel() {
        this.main.showProfessionalOverview();
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
