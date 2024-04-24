package com.example.view;

import com.example.controller.AddCurrencyController;

import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddCurrencyView {
    private AddCurrencyController addCurrencyController;

    public void setController(AddCurrencyController controller) {
        this.addCurrencyController = controller;
    }

    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void start(Stage stage) {
        VBox layout = new VBox(10);
        layout.setAlignment(javafx.geometry.Pos.CENTER);

        Label abbreviationLabel = new Label("Abbreviation:");
        TextField abbreviationTF = new TextField();
        Label nameLabel = new Label("Name:");
        TextField nameTF = new TextField();
        Label conversionRateLabel = new Label("Conversion Rate:");
        TextField conversionRateTF = new TextField();

        Button saveButton = new Button("Save");

        abbreviationTF.setMaxWidth(200);
        nameTF.setMaxWidth(200);
        conversionRateTF.setMaxWidth(200);

        layout.getChildren().addAll(abbreviationLabel, abbreviationTF, nameLabel, nameTF, conversionRateLabel, conversionRateTF, saveButton);

        saveButton.setOnAction((event) -> {
            String abbreviation = abbreviationTF.getText();
            String name = nameTF.getText();
            try {
                Double.parseDouble(conversionRateTF.getText());
            } catch (NumberFormatException e) {
                showAlert("Conversion rate must be a number");
                return;
            }
            double conversionRate = Double.parseDouble(conversionRateTF.getText());
            addCurrencyController.saveNewCurrency(abbreviation, name, conversionRate);
        });

        Scene scene = new Scene(layout, 300, 300);
        stage.setTitle("Add Currency");
        scene.getStylesheets().add(getClass().getResource("view.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
