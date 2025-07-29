package org.example.volodyanoy.dao;


import org.example.volodyanoy.models.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Component
public class BookDAO {
 /*   private final EntityManager entityManager;

    @Autowired
    public BookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional(readOnly = true)
    public void test(){
        Session session = entityManager.unwrap(Session.class);
        Person person = session.get(Person.class, 2);
    }*/
}