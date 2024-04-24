package com.example.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MariaDBJPAConnection {
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManager getInstance() {
        // you need to add synchronization if you run in a multi-threaded environment

        if (em == null) {
            try {
                emf = Persistence.createEntityManagerFactory("CurrencyApp");
                em = emf.createEntityManager();
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

