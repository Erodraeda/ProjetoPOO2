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
    private ComboBox<String> input_autores;

    @FXML
    private Button return_button;

    private ObservableList<Autor> autores;

    private ObservableList<String> autoresDisponiveis;

    private void loadTable() throws SQLException, IOException {
        AutorDAO aDao = new AutorDAO();
        // TODO: show name instead of object
        autores = FXCollections.observableArrayList(aDao.list());
        ArrayList<String> nomes = new ArrayList<>();
        for (var i = 0; i < autores.size(); i++) {
            nomes.add(this.autores.get(i).getId() + ", " + this.autores.get(i).getNome());
        }
        autoresDisponiveis = FXCollections.observableArrayList(nomes);
        input_autores.setItems(this.autoresDisponiveis);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            loadTable();
            input_autores.setItems(autoresDisponiveis);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void finishCreate(ActionEvent event) throws SQLException, IOException {

        String autorValue = input_autores.getValue();

        String[] idAutores = autorValue.split(", ");

        AutorDAO autorDAO = new AutorDAO();

        Autor author = autorDAO.get(Integer.parseInt(idAutores[0]));

        Autor autor = new Autor(author.getNome(), author.getIdade(), Integer.parseInt(idAutores[0]));

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
