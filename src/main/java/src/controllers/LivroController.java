package src.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import src.DAO.LivroDAO;
import src.Main;
import src.models.Livro;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LivroController implements Initializable {

    public ObservableList<Livro> livros;

    @FXML
    private Button create_livro;

    @FXML
    private Button delete_livro;

    @FXML
    private TableColumn<?, ?> id_livro;

    @FXML
    private AnchorPane index_pane;

    @FXML
    private TableColumn<?, ?> autores_livro;

    @FXML
    private TableColumn<?, ?> nome_livro;

    @FXML
    private TableColumn<?, ?> paginas_livro;

    @FXML
    private TableView<Livro> tabLivros;

    @FXML
    private Button update_livro;

    @FXML
    private Button voltar_inicio;

    @FXML
    private Button add_autor;

    @FXML
    void handleCreate(ActionEvent event) {
        Main.loadScene("createLivroView");
    }

    @FXML
    void handleDelete(ActionEvent event) {
        var selected = tabLivros.getSelectionModel().getSelectedItem();
        if (selected != null) {
            var alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("You are about to delete a book!");
            alert.setContentText("Are you sure you want to proceed?");
            alert.setTitle("Warning!");
            var ret = alert.showAndWait();
            if (ret.isPresent() && ret.get() == ButtonType.OK) {
                LivroDAO livroDAO = new LivroDAO();
                livroDAO.delete(selected.getId());
                Main.loadScene("livrosView");
            }
        } else {
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("You have nothing selected.");
            alert.setContentText("Select a book you want to delete.");
            alert.setTitle("Oops!");
            alert.showAndWait();
        }
    }

    @FXML
    void handleUpdate(ActionEvent event) {
        var selected = tabLivros.getSelectionModel().getSelectedItem();
        if (selected == null) {
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("You have nothing selected.");
            alert.setContentText("Select a book you want to update.");
            alert.setTitle("Oops!");
            alert.showAndWait();
        } else {
            Main.loadScene("updateLivroView", selected);
        }
    }

    @FXML
    void handleVoltar(ActionEvent event) {
        Main.loadScene("indexView");
    }

    @FXML
    void handleAddAutoria(ActionEvent event) {
        var selected = tabLivros.getSelectionModel().getSelectedItem();

        Main.loadScene("setAutoresView", selected);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            loadTable();
            id_livro.setCellValueFactory(new PropertyValueFactory<>("id"));
            nome_livro.setCellValueFactory(new PropertyValueFactory<>("nome"));
            paginas_livro.setCellValueFactory(new PropertyValueFactory<>("paginas"));
//            autores_livro.setCellValueFactory(new PropertyValueFactory<>("autores"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void loadTable() throws SQLException {
        LivroDAO cDao = new LivroDAO();
        livros = FXCollections.observableArrayList(cDao.list());
        tabLivros.setItems(this.livros);
    }
}
