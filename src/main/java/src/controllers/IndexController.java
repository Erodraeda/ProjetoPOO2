package src.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import src.DAO.AutorDAO;
import src.Main;
import src.models.Autor;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class IndexController implements Initializable {

    @FXML
    public TableView<Autor> tabAutores;

    public ObservableList<Autor> autores;

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
    private Button voltar_inicio;

    @FXML
    public void handleCreate(ActionEvent event) {
        Main.loadScene("createView");
    }

    @FXML
    public void handleDelete(ActionEvent event) {
        var selected = tabAutores.getSelectionModel().getSelectedItem();
        if (selected != null) {
            var alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("You are about to delete an author!");
            alert.setContentText("Are you sure you want to proceed?");
            alert.setTitle("Warning!");
            var ret = alert.showAndWait();
            if (ret.isPresent() && ret.get() == ButtonType.OK) {
                AutorDAO AutorDAO = new AutorDAO();
                AutorDAO.delete(selected.getId());
                Main.loadScene("autoresView");
            }
        } else {
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("You have nothing selected.");
            alert.setContentText("Select an author you want to delete.");
            alert.setTitle("Oops!");
            alert.showAndWait();
        }
    }

    @FXML
    public void handleUpdate(ActionEvent event) {
        var selected = tabAutores.getSelectionModel().getSelectedItem();
        if (selected == null) {
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("You have nothing selected.");
            alert.setContentText("Select an author you want to update.");
            alert.setTitle("Oops!");
            alert.showAndWait();
        } else {
            Main.loadScene("updateAutorView", selected);
        }
    }

    private void loadTable() throws SQLException {
        AutorDAO aDao = new AutorDAO();
        autores = FXCollections.observableArrayList(aDao.list());
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

    @FXML
    void handleVoltar(ActionEvent event) {
        Main.loadScene("indexView");
    }
}
