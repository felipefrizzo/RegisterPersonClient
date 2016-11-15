package br.univel;

import br.univel.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Objects.requireNonNull(primaryStage, "Stage cannot be null");

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Register Person Application");

        initRootLayout();
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));

            rootLayout = loader.load();

            primaryStage.setScene(new Scene(rootLayout));

            RootLayoutController controller = loader.getController();
            controller.setMain(this);

            primaryStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
