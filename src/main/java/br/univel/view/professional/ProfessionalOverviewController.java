package br.univel.view.professional;

import br.univel.Main;
import br.univel.client.RequestClient;
import br.univel.enums.OperationType;
import br.univel.model.ErrorMessage;
import br.univel.model.Professional;
import br.univel.view.GenericOverviewLayout;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by felipefrizzo on 16/11/16.
 */
public class ProfessionalOverviewController implements GenericOverviewLayout {

    private Main main;
    private RequestClient client;

    @FXML
    public void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<Professional, String>("name"));
        columnBirthday.setCellValueFactory(new PropertyValueFactory<Professional, LocalDate>("birthday"));
        columnUsername.setCellValueFactory(new PropertyValueFactory<Professional, String>("username"));
    }

    @FXML
    private TableView<Professional> table;

    @FXML
    private TableColumn<Professional, String> columnName;

    @FXML
    private TableColumn<Professional, LocalDate> columnBirthday;

    @FXML
    private TableColumn<Professional, String> columnUsername;

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
        table.setItems(new GetProfessionals(this.client).getList());
    }

    @Override
    @FXML
    public void handleNew(final ActionEvent event) {
        this.main.showProfessionalEditDialog(null);
    }

    @Override
    @FXML
    public void handleEdit(final ActionEvent event) {
        Professional professionalSelected = table.getSelectionModel().getSelectedItem();

        if (professionalSelected != null) {
            this.main.showProfessionalEditDialog(professionalSelected);
        } else {
            showError(
                "No selected professional",
                "No selected professional",
                "Please select a professional",
                Alert.AlertType.ERROR
            );
        }
    }

    @Override
    @FXML
    public void handleDelete(final ActionEvent event) {
        Professional professionalSelected = table.getSelectionModel().getSelectedItem();

        if (professionalSelected != null) {
            professionalSelected.setOperationType(OperationType.DELETE);

            Optional<ButtonType> result = showError(
                "You want to delete",
                "You want to delete this Customer ?",
                "If you want to delete click OK",
                Alert.AlertType.CONFIRMATION
            );

            if (result.get() == ButtonType.OK) {
                Object object = this.client.sendObject(professionalSelected);

                if (object instanceof ErrorMessage) {
                    ErrorMessage errorMessage = (ErrorMessage) object;
                    if (!errorMessage.getError()) {
                        getItemsTable();
                    }
                }
            }


        } else {
            showError(
                "No selected professional",
                "No selected professional",
                "Please select a professional",
                Alert.AlertType.ERROR
            );
        }
    }

    @Override
    public Optional<ButtonType> showError(final String title, final String headerText, final String contentText, final Alert.AlertType type) {
        final Alert alert = new Alert(type);
        alert.initOwner(main.getPrimaryStage());
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        return alert.showAndWait();
    }
}
