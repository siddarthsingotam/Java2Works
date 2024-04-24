package com.example.controller;

import com.example.dao.CurrencyDAO;
import com.example.entity.Currency;
import com.example.view.ConverterView;

public class ConverterController {
    CurrencyDAO currencyDAO;
    ConverterView converterView;

    public ConverterController(CurrencyDAO currencyDAO, ConverterView converterView) {
        this.currencyDAO = currencyDAO;
        this.converterView = converterView;
    }

    public boolean connectionTest() {
        return currencyDAO.connectionTest();
    }

    public void persist(String abbreviation, String name, double conversionRate) {
        currencyDAO.persist(new Currency(abbreviation, name, conversionRate));
    }

    public String[] getCurrencies() {
        return currencyDAO.getCurrencies();
    }

    public double getConvertedValue(double amount, String fromCurrency, String toCurrency) {
        double fromRate;
        double toRate;
        try {
            fromRate = currencyDAO.find(fromCurrency).getRate();
            toRate = currencyDAO.find(toCurrency).getRate();
        }
        catch (NumberFormatException exception) {
            return 0.0;
        }
        return amount * (toRate / fromRate);
    }

    public void update(String abbreviation, String name, double conversionRate) {
        currencyDAO.update(new Currency(abbreviation, name, conversionRate));
    }

    public void delete(String abbreviation) {
        currencyDAO.delete(abbreviation);
    }
}
