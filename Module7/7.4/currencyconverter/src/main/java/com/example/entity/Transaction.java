package com.example.entity;

import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "source_currency_id")
    private Currency sourceCurrency;

    @ManyToOne
    @JoinColumn(name = "target_currency_id")
    private Currency targetCurrency;

    private double sourceAmount;
    private double targetAmount;

    public Transaction() {}

    public Transaction(Currency sourceCurrency, Currency targetCurrency, double sourceAmount, double targetAmount) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.sourceAmount = sourceAmount;
        this.targetAmount = targetAmount;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public Currency getSourceCurrency() {
        return this.sourceCurrency;
    }

    public Currency getTargetCurrency() {
        return this.targetCurrency;
    }

    public double getSourceAmount() {
        return this.sourceAmount;
    }

    public double getTargetAmount() {
        return this.targetAmount;
    }

    public void setSourceCurrency(Currency sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public void setTargetCurrency(Currency targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public void setSourceAmount(double sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", sourceCurrency=" + sourceCurrency +
                ", targetCurrency=" + targetCurrency +
                ", sourceAmount=" + sourceAmount +
                ", targetAmount=" + targetAmount +
                '}';
    }

}