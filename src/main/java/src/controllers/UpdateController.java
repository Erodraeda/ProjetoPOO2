package src.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import src.DAO.AutorDAO;
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

        AutorDAO AutorDAO = new AutorDAO();

        AutorDAO.update(autor);

        Main.loadScene("autoresView");
    }

    @FXML
    void returnPage(ActionEvent event) {
        Main.loadScene("autoresView");
    }

//    private void loadTexts() throws SQLException {
//        var autor = ((Autor)index_pane.getUserData());
//        System.out.println("Autor: " + autor);
//        input_nome.setText(autor.getNome());
//        input_idade.setText(String.valueOf(autor.getIdade()));
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//        try {
//            loadTexts();
//            input_nome.setText(("nome"));
//            input_idade.setText(("idade"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
}
