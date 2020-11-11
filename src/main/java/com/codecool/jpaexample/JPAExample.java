package com.codecool.jpaexample;

import com.codecool.jpaexample.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAExample {

    public static void populateDb(EntityManager em) {
       User user = new User("Adrian", "adrian.widlak@codecool.com", "secretpassword");

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println("\n### User saved.\n");

        User user2 = new User("Zosia", "zosia.samosia@gmail.com", "topsecret");

        transaction.begin();
        em.persist(user2);
        transaction.commit();
        System.out.println("\n### User saved.\n");
    }


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexamplePU");
        EntityManager em = emf.createEntityManager();

        populateDb(em);
        em.clear(); //clear hibernate cache - force next statements to read data from db

        User foundUser = em.find(User.class, 1L);
        System.out.println("\n--Found user #1");
        System.out.println("----name----" + foundUser.getName());
        System.out.println("----email----" + foundUser.getEmail());
        System.out.println();

        em.close();
        emf.close();
    }
}
