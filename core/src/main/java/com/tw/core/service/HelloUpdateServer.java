package com.tw.core.service;

import com.tw.core.bean.Person;
import com.tw.core.dboperate.DBOperationHelper;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by marry on 7/9/15.
 */
public class HelloUpdateServer {
    public void updatePerson(Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(person);
        session.getTransaction().commit();
        session.close();
    }
}
