package com.example.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.example.entity.Currency;

public class MariaDBJPAConnection {
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    private static void populateCurrencyTable() {
        // populate the currency table if it is empty with usd as the base currency
        if (em.createQuery("SELECT c FROM Currency c", Currency.class).getResultList().isEmpty()) {
            em.getTransaction().begin();
            em.persist(new Currency("USD", "United States Dollar", 1.0));
            em.persist(new Currency("EUR", "Euro", 0.85));
            em.persist(new Currency("GBP", "British Pound", 0.75));
            em.persist(new Currency("JPY", "Japanese Yen", 110.0));
            em.persist(new Currency("CAD", "Canadian Dollar", 1.25));
            em.persist(new Currency("AUD", "Australian Dollar", 1.3));
            em.persist(new Currency("CHF", "Swiss Franc", 0.9));
            em.persist(new Currency("CNY", "Chinese Yuan", 6.5));
            em.persist(new Currency("SEK", "Swedish Krona", 8.5));
            em.persist(new Currency("VND", "Vietnamese Dong", 1.4));
            em.getTransaction().commit();
        }
    }

    public static EntityManager getInstance() {
        // you need to add synchronization if you run in a multi-threaded environment

        if (em == null) {
            try {
                emf = Persistence.createEntityManagerFactory("CurrencyApp");
                em = emf.createEntityManager();

                populateCurrencyTable();
            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error in DB communication");
            }
        }
        return em;
    }

    // Method to close the connection
    public static void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}

