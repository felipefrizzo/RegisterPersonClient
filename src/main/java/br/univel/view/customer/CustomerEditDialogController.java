package br.univel.view.customer;

import br.univel.Main;
import br.univel.client.RequestClient;
import br.univel.model.Customer;
import br.univel.view.GenericEditDialog;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * Created by felipefrizzo on 16/11/16.
 */
public class CustomerEditDialogController implements GenericEditDialog {

    private Main main;
    private RequestClient client;

    @FXML
    private TextField textFieldName;

    @FXML
    private DatePicker datePickerBirthday;

    @FXML
    private TextField textFieldCpf;

    @FXML
    private TextField textFieldRg;

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
        if (isInputValid()) {
            Customer customer = new Customer();
            customer.setName(textFieldName.getText());
            customer.setBirthday(datePickerBirthday.getValue());
            customer.setCpf(textFieldCpf.getText());
            customer.setRg(textFieldRg.getText());

            this.client.sendObject(customer);
        }
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
        if (textFieldCpf.getText() == null || textFieldCpf.getText().length() == 0) {
            errorMessage += "No valid CPF! \n";
        }
        if (textFieldRg.getText() == null || textFieldRg.getText().length() == 0) {
            errorMessage += "No valid RG! \n";
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
