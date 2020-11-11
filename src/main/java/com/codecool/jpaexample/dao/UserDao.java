package com.codecool.jpaexample.dao;

import com.codecool.jpaexample.model.User;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {
    //persistence name unit you can find in persistence.xml configuration
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexamplePU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    public List<User> getUsers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        TypedQuery<User> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
}
