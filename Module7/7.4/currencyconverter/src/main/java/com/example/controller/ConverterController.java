package com.example.controller;

import com.example.dao.CurrencyDAO;
import com.example.dao.TransactionDAO;
import com.example.entity.Currency;
import com.example.entity.Transaction;
import com.example.view.ConverterView;

public class ConverterController {
    CurrencyDAO currencyDAO;
    TransactionDAO transactionDAO;
    ConverterView converterView;

    public ConverterController(CurrencyDAO currencyDAO, TransactionDAO transactionDAO, ConverterView converterView) {
        this.currencyDAO = currencyDAO;
        this.transactionDAO = transactionDAO;
        this.converterView = converterView;
    }

    public boolean connectionTest() {
        if (!currencyDAO.connectionTest() || !transactionDAO.connectionTest()) {
            return false;
        }
        return true;
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

    public void handleConversion(String fromCurrency, String toCurrency, double amount, double convertedAmount) {
        Currency sourceCurrency = currencyDAO.find(fromCurrency);
        Currency targetCurrency = currencyDAO.find(toCurrency);
    
        Transaction transaction = new Transaction();
        transaction.setSourceCurrency(sourceCurrency);
        transaction.setTargetCurrency(targetCurrency);
        transaction.setSourceAmount(amount);
        transaction.setTargetAmount(convertedAmount); 
    
        transactionDAO.persist(transaction);
    }
}
