module com.example {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.sql;

    opens com.example to javafx.fxml;
    exports com.example;
    exports com.example.controller;
    exports com.example.dao;
    exports com.example.entity;
    exports com.example.datasource;
    exports com.example.view;
}
