package com.example.dao;

import com.example.entity.Currency;
import com.example.datasource.MariaDBConnection;
import java.sql.*;
import java.util.*;

public class CurrencyDAO {
    public boolean connectionTest() {
        try {
            Connection connection = MariaDBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM currency");
            while (resultSet.next()) {
                continue;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public List<Currency> getAllCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        String query = "SELECT * FROM currency";

        try {
            Connection connection = MariaDBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Currency currency = new Currency(
                    resultSet.getInt("id"),
                    resultSet.getString("abbreviation"),
                    resultSet.getString("name"),
                    resultSet.getDouble("rate"));
                currencies.add(currency);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return currencies;
    }

    public String[] getAllAbbreviations() {
        List<String> abbreviations = new ArrayList<>();
        String query = "SELECT abbreviation FROM currency";

        try {
            Connection connection = MariaDBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                abbreviations.add(resultSet.getString("abbreviation"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return abbreviations.toArray(new String[0]);
    }

    public double getConversionRateByAbbreviation(String abbreviation) {
        double conversionRate = 0.0;
        String query = "SELECT rate FROM currency WHERE abbreviation = ?";
    
        try {
            Connection connection = MariaDBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, abbreviation);
    
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    conversionRate = resultSet.getDouble("rate");
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            return Double.NaN;
        }
    
        return conversionRate;
    }
    
}
