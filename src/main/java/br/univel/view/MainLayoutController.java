package br.univel.view;

import br.univel.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.Objects;

/**
 * Created by felipefrizzo on 15/11/16.
 */
public class MainLayoutController {
    private Main main;

    /**
     *
     * @param main set the Main instance.
     */
    public void setMain(final Main main) {
        Objects.requireNonNull(main, "Main class cannot be null");

        this.main = main;
    }

    @FXML
    void showCustomerOverview(ActionEvent event) {
        this.main.showCustomerOverview();
    }

    @FXML
    void showProfessionalOverview(ActionEvent event) {
        this.main.showProfessionalOverview();
    }
}
