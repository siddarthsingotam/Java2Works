module com.example {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.sql;
    requires transitive jakarta.persistence;
    requires org.hibernate.orm.core;

    opens com.example;
    opens com.example.entity;
    exports com.example;
    exports com.example.controller;
    exports com.example.dao;
    exports com.example.entity;
    exports com.example.datasource;
    exports com.example.view;
}
