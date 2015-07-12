package com.tw.core.service;

import com.tw.core.bean.Person;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;

public class HelloDeleteService {
    public void deleltePerson(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();//开启操作数据库的事务
        Person person = new Person(id);
        person.setId(id);
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }
}
