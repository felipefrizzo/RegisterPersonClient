package br.univel;

import br.univel.client.RequestClient;
import br.univel.client.socket.ClientSocket;
import br.univel.view.MainLayoutController;
import br.univel.view.customer.CustomerEditDialogController;
import br.univel.view.customer.CustomerOverviewController;
import br.univel.view.login.LoginLayoutController;
import br.univel.view.professional.ProfessionalEditDialogController;
import br.univel.view.professional.ProfessionalOverviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by felipefrizzo on 15/11/16.
 */
public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private final RequestClient client = new ClientSocket();

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Objects.requireNonNull(primaryStage, "Stage cannot be null");

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Register Person Application");

        initRootLayout();
        showMainLayout();
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));

            rootLayout = loader.load();

            primaryStage.setScene(new Scene(rootLayout));
            primaryStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showLoginLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/login/LoginLayout.fxml"));

            AnchorPane layout = loader.load();
            rootLayout.setCenter(layout);

            LoginLayoutController controller = loader.getController();

            controller.setMain(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showMainLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainLayout.fxml"));

            AnchorPane layout = loader.load();
            rootLayout.setCenter(layout);

            MainLayoutController controller = loader.getController();

            controller.setMain(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showCustomerOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/customer/CustomerOverviewLayout.fxml"));

            AnchorPane layout = loader.load();
            rootLayout.setCenter(layout);

            CustomerOverviewController controller = loader.getController();

            controller.setMain(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showCustomerEditDialog() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/customer/CustomerEditDialog.fxml"));

            AnchorPane layout = loader.load();
            rootLayout.setCenter(layout);

            CustomerEditDialogController controller = loader.getController();

            controller.setMain(this);
            controller.setClient(client);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showProfessionalOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/professional/ProfessionalOverviewLayout.fxml"));

            AnchorPane layout = loader.load();
            rootLayout.setCenter(layout);

            ProfessionalOverviewController controller = loader.getController();

            controller.setMain(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showProfessionalEditDialog() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/professional/ProfessionalEditDialog.fxml"));

            AnchorPane layout = loader.load();
            rootLayout.setCenter(layout);

            ProfessionalEditDialogController controller = loader.getController();

            controller.setMain(this);
            controller.setClient(client);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
