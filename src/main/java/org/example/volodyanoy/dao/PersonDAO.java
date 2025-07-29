package org.example.volodyanoy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;


@Component
public class PersonDAO {
 /*   private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void test(){
        Session session = entityManager.unwrap(Session.class);
        Person person = session.get(Person.class, 2);
    }*/
}