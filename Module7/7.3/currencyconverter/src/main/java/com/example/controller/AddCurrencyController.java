package com.example.controller;

import com.example.view.AddCurrencyView;
import com.example.dao.CurrencyDAO;
import com.example.entity.Currency;

public class AddCurrencyController {
    AddCurrencyView addCurrencyView;
    CurrencyDAO currencyDAO;


    public AddCurrencyController(AddCurrencyView addCurrencyView) {
        this.addCurrencyView = addCurrencyView;
        this.currencyDAO = new CurrencyDAO();
    }

    public boolean connectionTest() {
        return currencyDAO.connectionTest();
    }

    public void saveNewCurrency(String abbreviation, String name, double conversionRate) {
        if (abbreviation.isBlank() || name.isBlank()) {
            addCurrencyView.showAlert("Abbreviation and name cannot be empty");
            return;
        }

        if (conversionRate <= 0) {
            addCurrencyView.showAlert("Conversion rate must be greater than 0");
            return;
        }

        if (abbreviation.length() != 3) {
            addCurrencyView.showAlert("Abbreviation must be 3 characters");
            return;
        }

        if (currencyDAO.find(abbreviation) != null) {
            addCurrencyView.showAlert("Currency already exists");
            return;
        }
        
        currencyDAO.persist(new Currency(abbreviation.toUpperCase(), name, conversionRate));
    }
}
