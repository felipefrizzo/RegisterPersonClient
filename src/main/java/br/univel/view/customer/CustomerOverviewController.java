package br.univel.view.customer;

import br.univel.Main;
import br.univel.model.Customer;
import br.univel.view.GenericOverviewLayout;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Date;

/**
 * Created by felipefrizzo on 15/11/16.
 */
public class CustomerOverviewController implements GenericOverviewLayout {

    private Main main;

    @FXML
    private TableView<Customer> table;

    @FXML
    private TableColumn<Customer, String> columnName;

    @FXML
    private TableColumn<Customer, Date> columnBirthday;

    @FXML
    private TableColumn<Customer, String> columnCpf;

    @FXML
    private TableColumn<Customer, String> columnRg;

    @Override
    public void setMain(final Main main) {
        this.main = main;
    }

    @Override
    @FXML
    public void handleNew(final ActionEvent event) {

    }

    @Override
    @FXML
    public void handleEdit(final ActionEvent event) {

    }

    @Override
    @FXML
    public void handleDelete(final ActionEvent event) {

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
