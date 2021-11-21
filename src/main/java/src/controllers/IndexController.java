package src.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.DAO.Autor_DAO;
import src.Main;
import src.models.Autor;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class IndexController implements Initializable {

    @FXML
    public TableView<Autor> tabAutores;

    public ObservableList<Autor> autores;

    private void loadTable() throws SQLException {
        Autor_DAO cDao = new Autor_DAO();
        autores = FXCollections.observableArrayList(cDao.list());
        tabAutores.setItems(this.autores);
    }

    @FXML
    public TableColumn<?, ?> id_autor;

    @FXML
    public TableColumn<?, ?> idade_autor;

    @FXML
    public TableColumn<?, ?> nome_autor;

    @FXML
    public Button create_autor;

    @FXML
    public Button delete_autor;

    @FXML
    public Button update_autor;

    @FXML
    public void handleCreate(ActionEvent event) {
        Main.loadScene("create-view");
    }

    @FXML
    public void handleDelete(ActionEvent event) {
        var selected = tabAutores.getSelectionModel().getSelectedItem();
        Autor_DAO.delete(selected.getId());
        Main.loadScene("index-view");
    }

    @FXML
    public void handleUpdate(ActionEvent event) {
        var selected = tabAutores.getSelectionModel().getSelectedItem();
        Main.loadScene("update-view", selected);
    }

    private void loadPage() {

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
