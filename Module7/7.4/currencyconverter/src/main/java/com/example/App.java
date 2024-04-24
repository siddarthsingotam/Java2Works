package com.example;

import javafx.application.Application;
import javafx.stage.Stage;

import com.example.controller.ConverterController;
import com.example.view.ConverterView;
import com.example.dao.CurrencyDAO;
import com.example.dao.TransactionDAO;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        CurrencyDAO currencyDAO = new CurrencyDAO();
        TransactionDAO transactionDAO = new TransactionDAO();
        ConverterView converterView = new ConverterView();
        ConverterController converterController = new ConverterController(currencyDAO, transactionDAO, converterView);

        converterView.setController(converterController);
        converterView.start(stage);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}