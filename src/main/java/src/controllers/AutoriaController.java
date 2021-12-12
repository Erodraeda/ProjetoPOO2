package src.controllers;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import src.DAO.AutorDAO;
import src.DAO.LivroDAO;
import src.Main;
import src.models.Autor;
import src.models.Livro;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AutoriaController implements Initializable {

    private boolean updatePage;

    public ObservableList<Autor> autores;

    public ObservableList<String> dispAutores;

    public ObservableList<Autor> autoresDisponiveis;

    @FXML
    private Button create_autoria;

    @FXML
    private Button delete_autoria;

    @FXML
    private TableColumn<?, ?> id_autor;

    @FXML
    private AnchorPane index_pane;

    @FXML
    private ComboBox<String> list_autores;

    @FXML
    private TableColumn<?, ?> nome_autor;

    @FXML
    private TableView<Autor> tabAutorias;

    @FXML
    private Button voltar_inicio;

    @FXML
    void handleCreate(ActionEvent event) {
        var livro = ((Integer)index_pane.getUserData());
        var selected = list_autores.getValue();

        if (selected != null) {
            String[] selectedId = selected.split(", ");
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.insertAutoria(Integer.parseInt(selectedId[0]), livro);
            Main.loadScene("autoriaView", livro);
        } else {
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("You have nothing selected.");
            alert.setContentText("Select a book's author you want to delete.");
            alert.setTitle("Oops!");
            alert.showAndWait();
        }

    }

    @FXML
    void handleDelete(ActionEvent event) {
        var selected = tabAutorias.getSelectionModel().getSelectedItem();
        var livro = ((Integer)index_pane.getUserData());

        System.out.println("Livro: " + livro);
        if (selected != null) {
            var alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("You are about to delete a book's author!");
            alert.setContentText("Are you sure you want to proceed?");
            alert.setTitle("Warning!");
            var ret = alert.showAndWait();
            if (ret.isPresent() && ret.get() == ButtonType.OK) {
                LivroDAO livroDAO = new LivroDAO();
                livroDAO.deleteAutoria(livro, selected.getId());
                Main.loadScene("autoriaView", livro);
            }
        } else {
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("You have nothing selected.");
            alert.setContentText("Select a book's author you want to delete.");
            alert.setTitle("Oops!");
            alert.showAndWait();
        }
    }

    @FXML
    void handleVoltar(ActionEvent event) {
        Main.loadScene("livrosView");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Platform.runLater(()-> {
            try {
                loadTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        id_autor.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome_autor.setCellValueFactory(new PropertyValueFactory<>("nome"));
        list_autores.setItems(dispAutores);

    }

    private void loadTable() throws SQLException {
        var livro = ((Integer)this.index_pane.getUserData());
        AutorDAO aDao = new AutorDAO();
        autores = FXCollections.observableArrayList(aDao.listAutores(livro));
        tabAutorias.setItems(this.autores);
        autoresDisponiveis = FXCollections.observableArrayList(aDao.list());
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<String> nomesAtuais = new ArrayList<>();
        for (var i = 0; i < autoresDisponiveis.size(); i++) {
            nomes.add(this.autoresDisponiveis.get(i).getId() + ", " + this.autoresDisponiveis.get(i).getNome());
        }
        for (var i = 0; i < autores.size(); i++) {
            nomesAtuais.add(this.autores.get(i).getId() + ", " + this.autores.get(i).getNome());
        }
        nomes.removeAll(nomesAtuais);
        dispAutores = FXCollections.observableArrayList(nomes);
        list_autores.setItems(this.dispAutores);
    }

}
