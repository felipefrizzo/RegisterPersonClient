package br.univel.view.client;

import br.univel.Main;
import br.univel.model.Client;
import br.univel.view.AbstractOverviewLayout;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Date;

/**
 * Created by felipefrizzo on 15/11/16.
 */
public class ClientOverviewController implements AbstractOverviewLayout {

    private Main main;

    @FXML
    private TableView<Client> table;

    @FXML
    private TableColumn<Client, String> columnName;

    @FXML
    private TableColumn<Client, Date> columnBirthday;

    @FXML
    private TableColumn<Client, String> columnCpf;

    @FXML
    private TableColumn<Client, String> columnRg;

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
