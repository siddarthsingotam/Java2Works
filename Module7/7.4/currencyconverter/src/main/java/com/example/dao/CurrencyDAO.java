package com.example.dao;

import com.example.entity.Currency;
import com.example.datasource.MariaDBJPAConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CurrencyDAO {
    public boolean connectionTest() {
        EntityManager em = MariaDBJPAConnection.getInstance();
        return em != null;
    }
    
    public void persist(Currency currency) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
    }

    public Currency find(String abbreviation) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        TypedQuery<Currency> query = em.createQuery(
            "SELECT c FROM Currency c WHERE c.abbreviation = :abbr", 
            Currency.class
        );
        query.setParameter("abbr", abbreviation);
        
        List<Currency> currencies = query.getResultList();
        return currencies.isEmpty() ? null : currencies.get(0);
    }

    public void update(Currency currency) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        em.getTransaction().begin();
        em.merge(currency);
        em.getTransaction().commit();
    }

    public void delete(String abbreviation) {
        EntityManager em = MariaDBJPAConnection.getInstance();
        Currency currency = em.find(Currency.class, abbreviation);
        em.getTransaction().begin();
        em.remove(currency);
        em.getTransaction().commit();
    }

    public String[] getCurrencies() {
        EntityManager em = MariaDBJPAConnection.getInstance();
        return em.createQuery("SELECT c.abbreviation FROM Currency c", String.class).getResultList().toArray(new String[0]);
    }
}
