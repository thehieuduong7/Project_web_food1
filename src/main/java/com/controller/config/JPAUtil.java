package com.controller.config;

import javax.persistence.EntityManagerFactory;


import javax.persistence.*;

public class JPAUtil {
	public static void main(String[] agrs) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        System.out.print(emf);
    }
}
