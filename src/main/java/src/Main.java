package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        loadScene("indexView");
        primaryStage.show();

    }

    public static void loadScene(String view, Object dados) {
        view = view + ".fxml";
        AnchorPane root;
        try {
            root = (AnchorPane) FXMLLoader.load(Main.class.getResource(view));
            Scene scene = new Scene(root);
            if(dados!=null) root.setUserData(dados);
            stage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void loadScene(String view) {
        loadScene(view, null);
    }

    public static void main(String[] args) {
        launch();
    }
}