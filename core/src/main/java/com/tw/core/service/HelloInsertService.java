package com.tw.core.service;

import com.tw.core.bean.Person;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;

public class HelloInsertService {
    public void insertPerson(Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();//开启操作数据库的事务
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }
}