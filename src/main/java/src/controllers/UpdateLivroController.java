package src.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import src.DAO.LivroDAO;
import src.Main;
import src.models.Livro;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UpdateLivroController implements Initializable {

    @FXML
    private Button atualizar_button;

    @FXML
    private AnchorPane index_pane;

    @FXML
    private TextField input_nome;

    @FXML
    private TextField input_paginas;

    @FXML
    private Button return_button;

    @FXML
    void finishUpdate(ActionEvent event) {
        Livro livro = ((Livro)index_pane.getUserData());

        livro.setPaginas(Integer.parseInt(input_paginas.getText()));

        livro.setNome(input_nome.getText());

        LivroDAO livroDAO = new LivroDAO();

        livroDAO.update(livro);

        Main.loadScene("livrosView");
    }

    @FXML
    void returnPage(ActionEvent event) {
        Main.loadScene("livrosView");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            loadTable();
            input_nome.setText(String.valueOf(new PropertyValueFactory("nomeLivro")));
            input_paginas.setText(String.valueOf(new PropertyValueFactory("paginasLivro")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void loadTable() throws SQLException {
        Livro livro = ((Livro)index_pane.getUserData());
        System.out.println("livro: " + livro);
        var nomeLivro = livro.getNome();
        var paginasLivro = livro.getPaginas();
        input_nome.setText(nomeLivro);
        input_paginas.setText(String.valueOf(paginasLivro));
    }

}