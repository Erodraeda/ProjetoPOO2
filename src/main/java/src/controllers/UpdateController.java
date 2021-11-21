package src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import src.DAO.Autor_DAO;
import src.Main;
import src.models.Autor;

import java.io.IOException;

public class UpdateController {

    @FXML
    private AnchorPane index_pane;
    
    @FXML
    private Button atualizar_button;

    @FXML
    private TextField input_idade;

    @FXML
    private TextField input_nome;

    @FXML
    private Button return_button;

    @FXML
    void finishUpdate(ActionEvent event) throws IOException {
        var autor = ((Autor)index_pane.getUserData());

        System.out.println("idade: " + Integer.parseInt(input_idade.getText()));

        System.out.println("autor: " + autor);

        autor.setIdade(Integer.parseInt(input_idade.getText()));

        autor.setNome(input_nome.getText());

        Autor_DAO.update(autor);

        Main.loadScene("index-view");
    }

    @FXML
    void returnPage(ActionEvent event) {
        Main.loadScene("index-view");
    }

}
