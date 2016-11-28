package br.univel.view.customer;

import br.univel.Main;
import br.univel.client.RequestClient;
import br.univel.enums.OperationType;
import br.univel.model.Customer;
import br.univel.model.ErrorMessage;
import br.univel.view.GenericEditDialog;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.Objects;

/**
 * Created by felipefrizzo on 16/11/16.
 */
public class CustomerEditDialogController implements GenericEditDialog {

    private Main main;
    private Customer customer;
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
    public void setMain(final Main main) {
        this.main = main;
    }

    @Override
    public void setClient(final RequestClient client) {
        this.client = client;
    }

    /**
     *
     * @param customer set the Customer instance.
     */
    public void setCustomer(final Customer customer) {
        this.customer = customer;
        showCustomerDetails();
    }

    private void showCustomerDetails() {
        if (this.customer != null) {
            textFieldName.setText(this.customer.getName());
            datePickerBirthday.setValue(this.customer.getBirthday());
            textFieldCpf.setText(this.customer.getCpf());
            textFieldRg.setText(this.customer.getRg());
        } else {
            textFieldName.setText("");
            textFieldCpf.setText("");
            textFieldRg.setText("");
            datePickerBirthday.setValue(null);
        }
    }

    @Override
    @FXML
    public void handleSave() {
        if (isInputValid()) {
            if (customer == null) {
                customer = new Customer();
                customer.setOperationType(OperationType.POST);
            } else {
                customer.setOperationType(OperationType.PUT);
            }
            customer.setName(textFieldName.getText());
            customer.setBirthday(datePickerBirthday.getValue());
            customer.setCpf(textFieldCpf.getText());
            customer.setRg(textFieldRg.getText());


            Object object = this.client.sendObject(customer);
            serverValidation(object);
        }
    }

    @Override
    @FXML
    public void handleCancel() {
        this.main.showCustomerOverview();
    }

    @Override
    public boolean isInputValid() {
        StringBuilder errorMessage = new StringBuilder();

        if (textFieldName.getText() == null || textFieldName.getText().length() == 0) {
            errorMessage.append("No valid Name! \n");
        }
        if (datePickerBirthday.getValue() == null) {
            errorMessage.append("No valid Birthday! \n");
        }
        if (textFieldCpf.getText() == null || textFieldCpf.getText().length() == 0) {
            errorMessage.append("No valid CPF! \n");
        }
        if (textFieldRg.getText() == null || textFieldRg.getText().length() == 0) {
            errorMessage.append("No valid RG! \n");
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

    @Override
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
                this.main.showCustomerOverview();
            }
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
