package com.example;

import javafx.application.Application;
import javafx.stage.Stage;

import com.example.controller.ConverterController;
import com.example.view.ConverterView;
import com.example.dao.CurrencyDAO;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        CurrencyDAO currencyDAO = new CurrencyDAO();
        ConverterView converterView = new ConverterView();
        ConverterController converterController = new ConverterController(currencyDAO, converterView);

        converterView.setController(converterController);
        converterView.start(stage);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}