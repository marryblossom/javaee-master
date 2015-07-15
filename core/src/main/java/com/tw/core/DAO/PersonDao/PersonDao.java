package com.tw.core.DAO.PersonDao;

import com.tw.core.beanNoUse.Person;
import com.tw.core.service.baseservice.IBaseInterface;
import com.tw.core.service.baseservice.impl.IBaseInterfaceImplement;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by marry on 7/15/15.
 */
public class PersonDao implements IPersonDao {
    Session session = HibernateUtil.getSessionFactory().openSession();
    public void deleltePerson(String id){
        session.beginTransaction();//开启操作数据库的事务
        Person person = new Person(id);
        person.setId(id);
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }
    public void insertPerson(Person person){
        session.beginTransaction();//开启操作数据库的事务
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }
    public List<Person> getPeople(){
        IBaseInterface baseInterface = new IBaseInterfaceImplement();
        List<Person> people = baseInterface.queryAll(Person.class);
        baseInterface.closeCurrentSession(baseInterface.getCurrentSession());
        return people;
    }
    public Person getPersonById(String id){
        session.beginTransaction();
        Person person = (Person)session.get(Person.class,id);
        session.close();
        return person;
    }
    public void updatePerson(Person person){
        session.beginTransaction();
        session.update(person);
        session.getTransaction().commit();
        session.close();
    }
}
