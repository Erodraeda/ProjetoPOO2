package src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import src.DAO.Autor_DAO;
import src.Main;
import src.models.Autor;

import java.io.IOException;
import java.sql.SQLException;

public class CadastroController {

    @FXML
    public Button cadastrar_button;

    @FXML
    public Button return_button;

    @FXML
    public TextField input_idade;

    @FXML
    public TextField input_nome;

    @FXML
    void finishCreate(ActionEvent event) throws SQLException, IOException {
        Autor autor = new Autor(input_nome.getText(), Integer.parseInt(input_idade.getText()));

        Autor_DAO.insert(autor);

        Main.loadScene("index-view");
    }

    @FXML
    void returnPage(ActionEvent event) {
        Main.loadScene("index-view");
    }

}
