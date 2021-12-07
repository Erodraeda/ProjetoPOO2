package src.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import src.DAO.AutorDAO;
import src.DAO.LivroDAO;
import src.Main;
import src.models.Autor;
import src.models.Livro;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CadastroLivroController implements Initializable {

    public ArrayList<Autor> autoresObj;

    @FXML
    private Button cadastrar_button;

    @FXML
    private AnchorPane index_pane;

    @FXML
    private TextField input_nome;

    @FXML
    private TextField input_paginas;

    @FXML
    private ComboBox<Autor> input_autores;

    @FXML
    private Button return_button;

    private ObservableList<Autor> autores;

    private void loadTable() throws SQLException, IOException {
        AutorDAO cDao = new AutorDAO();
        // TODO: show name instead of object
        autores = FXCollections.observableArrayList(cDao.list());
        input_autores.setItems(this.autores);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            loadTable();
            input_autores.setItems(autores);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void finishCreate(ActionEvent event) throws SQLException, IOException {

        Autor autor = new Autor(input_autores.getValue().getNome(), input_autores.getValue().getIdade(), input_autores.getValue().getId());

        System.out.println("input: " + input_autores.getValue());

        Livro livro = new Livro(input_nome.getText(), Integer.parseInt(input_paginas.getText()));

        LivroDAO livroDAO = new LivroDAO();

        livroDAO.insert(livro);

        livroDAO.insert(autor.getId());

        Main.loadScene("livrosView");
    }

    @FXML
    void returnPage(ActionEvent event) {
        Main.loadScene("livrosView");
    }



}
