package com.tw.core.service;

import com.tw.core.bean.Person;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

/**
 * Created by marry on 7/10/15.
 */
public class HelloSelectService {
    public List<Person> getPeople(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       // List<Person> people = session.createCriteria(Person.class).list();
        List<Person> people = session.createQuery("from Person").list();
        session.close();
        return people;
    }
    public Person getPersonById(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Person person = (Person)session.get(Person.class,id);
        session.close();
        return person;
    }
}
