package br.univel.view.customer;

import br.univel.Main;
import br.univel.client.RequestClient;
import br.univel.enums.OperationType;
import br.univel.model.Customer;
import br.univel.view.GenericOverviewLayout;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by felipefrizzo on 15/11/16.
 */
public class CustomerOverviewController implements GenericOverviewLayout {

    private Main main;
    private RequestClient client;

    @FXML
    public void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        columnBirthday.setCellValueFactory(new PropertyValueFactory<Customer, LocalDate>("birthday"));
        columnCpf.setCellValueFactory(new PropertyValueFactory<Customer, String>("cpf"));
        columnRg.setCellValueFactory(new PropertyValueFactory<Customer, String>("rg"));
    }
    @FXML
    private TableView<Customer> table;

    @FXML
    private TableColumn<Customer, String> columnName;

    @FXML
    private TableColumn<Customer, LocalDate> columnBirthday;

    @FXML
    private TableColumn<Customer, String> columnCpf;

    @FXML
    private TableColumn<Customer, String> columnRg;

    @Override
    public void setMain(final Main main) {
        Objects.requireNonNull(main, "Main class cannot be null");
        this.main = main;
    }

    @Override
    public void setClient(final RequestClient client) {
        Objects.requireNonNull(client, "Client cannot be null");
        this.client = client;

        getItemsTable();
    }

    public void getItemsTable() {
        table.setItems(new GetCustomers(this.client).getList());
    }

    @Override
    @FXML
    public void handleNew(final ActionEvent event) {
        this.main.showCustomerEditDialog(null);
    }

    @Override
    @FXML
    public void handleEdit(final ActionEvent event) {
        Customer customerSelected = table.getSelectionModel().getSelectedItem();

        if (customerSelected != null) {
            this.main.showCustomerEditDialog(customerSelected);
        } else {
            showError(
                "No selected customer",
                "No selected customer",
                "Please select a customer",
                Alert.AlertType.ERROR
            );
        }
    }

    @Override
    @FXML
    public void handleDelete(final ActionEvent event) {
        Customer customerSelected = table.getSelectionModel().getSelectedItem();

        if (customerSelected != null) {
            customerSelected.setOperationType(OperationType.DELETE);
            this.client.sendObject(customerSelected);
        } else {
            showError(
                "No selected customer",
                "No selected customer",
                "Please select a customer",
                Alert.AlertType.ERROR
            );
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
