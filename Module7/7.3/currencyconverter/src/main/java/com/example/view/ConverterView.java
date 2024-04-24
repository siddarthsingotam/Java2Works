package com.example.view;

import com.example.controller.AddCurrencyController;
import com.example.controller.ConverterController;

import javafx.application.Application;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ConverterView extends Application {
    private ConverterController converterController;

    public void setController(ConverterController converterController) {
        this.converterController = converterController;
    }

    @Override
    public void start(Stage stage) {
        VBox layout = new VBox(10);
        layout.setAlignment(javafx.geometry.Pos.CENTER);

        HBox converter = new HBox(10);
        TextField fromCurrency = new TextField();
        ComboBox<String> fromCurrencyBox = new ComboBox<String>();
        Label equal = new Label("=");
        TextField toCurrency = new TextField();
        ComboBox<String> toCurrencyBox = new ComboBox<String>();
        Button convertButton = new Button("Convert");
        converter.getChildren().addAll(fromCurrency, fromCurrencyBox, equal, toCurrency, toCurrencyBox, convertButton);
        converter.setAlignment(javafx.geometry.Pos.CENTER);
        
        FlowPane addCurrencyPane = new FlowPane();
        Button addCurrencyButton = new Button("Add Currency");
        addCurrencyPane.getChildren().add(addCurrencyButton);
        addCurrencyPane.setAlignment(javafx.geometry.Pos.CENTER);


        VBox text = new VBox(10);
        Label message = new Label();
        Label instruction = new Label("Enter amount and select currencies. Then click convert.");

        fromCurrency.setPromptText("From");
        fromCurrencyBox.setPromptText("XXX");
        toCurrency.setPromptText("To");
        toCurrencyBox.setPromptText("XXX");

        text.getChildren().addAll(message, instruction);
        text.setAlignment(javafx.geometry.Pos.CENTER);


        layout.getChildren().addAll(converter, addCurrencyPane, text);

        // fetch currencies
        try {
            for (String currency : converterController.getCurrencies()) {
                if (currency == null) {
                    message.setText("Error in retrieving currencies from DB");
                }
                fromCurrencyBox.getItems().add(currency);
                toCurrencyBox.getItems().add(currency);
            }
        }
        catch (NullPointerException exception) {
            message.setText("Error in DB communication");
        }

        // convert currency
        convertButton.setOnAction(e -> {
            if (converterController.connectionTest()) {
                message.setText("Error in DB communication");
            }

            double amount;
            String fromCurrencyCode = fromCurrencyBox.getValue();
            String toCurrencyCode = toCurrencyBox.getValue();

            try {
                amount = Double.parseDouble(fromCurrency.getText());
            }
            catch (NumberFormatException exception) {
                message.setText("Please enter a number\n");
                return;
            }

            if (fromCurrencyCode == null || toCurrencyCode == null) {
                message.setText("Please select currencies\n");
                return;
            }

            if (fromCurrencyCode.equals(toCurrencyCode)) {
                message.setText("Please select different currencies\n");
                return;
            }

            double convertedAmount = converterController.getConvertedValue(amount, fromCurrencyCode, toCurrencyCode);

            if (Double.isNaN(convertedAmount)) {
                message.setText("Error in DB communication");
            }
            else {
                toCurrency.setText(String.format("%.2f", convertedAmount));
                message.setText("\n");
            }

        });

        // add currency and trigger a refetch of currencies after adding a new currency
        addCurrencyButton.setOnAction(e -> {
            AddCurrencyView addCurrencyView = new AddCurrencyView();
            AddCurrencyController addCurrencyController = new AddCurrencyController(addCurrencyView);
            addCurrencyView.setController(addCurrencyController);

            Stage addCurrencyStage = new Stage();
            addCurrencyView.start(addCurrencyStage);

            addCurrencyStage.setOnCloseRequest(event -> {
                fromCurrencyBox.getItems().clear();
                toCurrencyBox.getItems().clear();
                try {
                    for (String currency : converterController.getCurrencies()) {
                        if (currency == null) {
                            message.setText("Error in retrieving currencies from DB");
                        }
                        fromCurrencyBox.getItems().add(currency);
                        toCurrencyBox.getItems().add(currency);
                    }
                }
                catch (NullPointerException exception) {
                    message.setText("Error in DB communication");
                }
            });
        });


        

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("view.css").toExternalForm());

        stage.setMinHeight(250);
        stage.setMaxHeight(250);
        stage.setMinWidth(700);
        stage.setMaxWidth(700);
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
