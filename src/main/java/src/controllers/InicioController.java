package src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import src.Main;

public class InicioController {

    @FXML
    private AnchorPane index_pane;

    @FXML
    private Button show_autor;

    @FXML
    private Button show_livro;

    @FXML
    void handleShowAutores(ActionEvent event) {
        Main.loadScene("autoresView");
    }

    @FXML
    void handleShowLivros(ActionEvent event) {
        Main.loadScene("livrosView");
    }

}