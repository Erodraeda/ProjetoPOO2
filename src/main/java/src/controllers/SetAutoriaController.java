package src.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import src.DAO.AutorDAO;
import src.DAO.LivroDAO;
import src.Main;
import src.models.Autor;
import src.models.Livro;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SetAutoriaController implements Initializable {

    @FXML
    private Button add_autor;

    @FXML
    private TableColumn<?, ?> id_autor;

    @FXML
    private TableColumn<?, ?> idade_autor;

    @FXML
    private AnchorPane index_pane;

    @FXML
    private TableColumn<?, ?> nome_autor;

    @FXML
    private Button voltar;

    @FXML
    public TableView<Autor> tabAutores;

    public ObservableList<Autor> autores;

    @FXML
    void adicionarAutorHandle(ActionEvent event) {
        var selected = tabAutores.getSelectionModel().getSelectedItem();
        Livro livro = ((Livro)index_pane.getUserData());

        LivroDAO livroDAO = new LivroDAO();

        livroDAO.insert(selected.getId(), livro.getId());

        Main.loadScene("livrosView");
    }

    @FXML
    void voltarHandle(ActionEvent event) {
        Main.loadScene("livrosView");
    }

    private void loadTable() throws SQLException {
        AutorDAO cDao = new AutorDAO();
        autores = FXCollections.observableArrayList(cDao.list());
        tabAutores.setItems(this.autores);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            loadTable();
            id_autor.setCellValueFactory(new PropertyValueFactory<>("id"));
            nome_autor.setCellValueFactory(new PropertyValueFactory<>("nome"));
            idade_autor.setCellValueFactory(new PropertyValueFactory<>("idade"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
