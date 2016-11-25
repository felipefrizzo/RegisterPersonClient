package br.univel.view.professional;

import br.univel.Main;
import br.univel.client.RequestClient;
import br.univel.enums.OperationType;
import br.univel.model.Professional;
import br.univel.view.GenericOverviewLayout;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Date;

/**
 * Created by felipefrizzo on 16/11/16.
 */
public class ProfessionalOverviewController implements GenericOverviewLayout {

    private Main main;
    private RequestClient client;

    @FXML
    private TableView<Professional> table;

    @FXML
    private TableColumn<Professional, String> columnName;

    @FXML
    private TableColumn<Professional, Date> columnBirthday;

    @FXML
    private TableColumn<Professional, String> columnUsername;

    @Override
    public void setMain(final Main main) {
        this.main = main;
    }

    @Override
    public void setClient(RequestClient client) {
        this.client = client;
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
            this.client.sendObject(professionalSelected);
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
    public void showError(final String title, final String headerText, final String contentText, final Alert.AlertType type) {
        final Alert alert = new Alert(type);
        alert.initOwner(main.getPrimaryStage());
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }
}
