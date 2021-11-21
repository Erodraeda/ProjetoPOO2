module src {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;

    opens src to javafx.fxml;
    opens src.controllers to javafx.graphics, javafx.fxml;
    opens src.models to javafx.base;

    exports src.controllers;
    exports src.models;
    exports src;
}