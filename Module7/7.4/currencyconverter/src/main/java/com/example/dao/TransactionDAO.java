package com.example.dao;

import com.example.datasource.MariaDBJPAConnection;
import com.example.entity.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDAO {
    public boolean connectionTest() {
        EntityManager em = MariaDBJPAConnection.getInstance();
        return em != null;
    }
    public void persist(Transaction transaction) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        em.getTransaction().begin();
        em.persist(transaction);
        em.getTransaction().commit();
    }

    public void update(Transaction transaction) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        em.getTransaction().begin();
        em.merge(transaction);
        em.getTransaction().commit();
    }

    public void delete(Long transactionId) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        em.getTransaction().begin();
        Transaction transaction = em.find(Transaction.class, transactionId);
        em.remove(transaction);
        em.getTransaction().commit();
    }

    public Transaction find(Long transactionId) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        return em.find(Transaction.class, transactionId);
    }

    public Transaction[] findAll() {
        EntityManager em = MariaDBJPAConnection.getInstance();
        return em.createQuery("SELECT t FROM Transaction t", Transaction.class).getResultList().toArray(new Transaction[0]);
    }

    public Transaction[] findBySourceCurrency(String sourceCurrency) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        return em.createQuery("SELECT t FROM Transaction t WHERE t.sourceCurrency.abbreviation = :sourceCurrency", Transaction.class).setParameter("sourceCurrency", sourceCurrency).getResultList().toArray(new Transaction[0]);
    }

    public Transaction[] findByTargetCurrency(String targetCurrency) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        return em.createQuery("SELECT t FROM Transaction t WHERE t.targetCurrency.abbreviation = :targetCurrency", Transaction.class).setParameter("targetCurrency", targetCurrency).getResultList().toArray(new Transaction[0]);
    }

    public Transaction[] findBySourceAmount(double sourceAmount) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        return em.createQuery("SELECT t FROM Transaction t WHERE t.sourceAmount = :sourceAmount", Transaction.class).setParameter("sourceAmount", sourceAmount).getResultList().toArray(new Transaction[0]);
    }

    public Transaction[] findByTargetAmount(double targetAmount) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        return em.createQuery("SELECT t FROM Transaction t WHERE t.targetAmount = :targetAmount", Transaction.class).setParameter("targetAmount", targetAmount).getResultList().toArray(new Transaction[0]);
    }

    public Transaction[] findBySourceCurrencyAndTargetCurrency(String sourceCurrency, String targetCurrency) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        return em.createQuery("SELECT t FROM Transaction t WHERE t.sourceCurrency.abbreviation = :sourceCurrency AND t.targetCurrency.abbreviation = :targetCurrency", Transaction.class).setParameter("sourceCurrency", sourceCurrency).setParameter("targetCurrency", targetCurrency).getResultList().toArray(new Transaction[0]);
    }
}
