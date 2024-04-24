package com.example.controller;

import com.example.dao.CurrencyDAO;
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

    public String[] getAllCurrencyAbbreviations() {
        return currencyDAO.getAllAbbreviations();
    }

    public double getConvertedValue(double amount, String fromCurrency, String toCurrency) {
        double fromRate;
        double toRate;
        try {
            fromRate = currencyDAO.getConversionRateByAbbreviation(fromCurrency);
            toRate = currencyDAO.getConversionRateByAbbreviation(toCurrency);
        }
        catch (NumberFormatException exception) {
            return 0.0;
        }
        return amount * (toRate / fromRate);
    }
}
