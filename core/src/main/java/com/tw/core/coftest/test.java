package com.tw.core.coftest;

import com.tw.core.bean.Person;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by marry on 7/12/15.
 */
public class test {
    private DetachedCriteria detachedCriteria;
    public void tests(){
    Session session = HibernateUtil.getSessionFactory().openSession();
        try {
          //  Class<?> clazz = Class.forName("person");
//            detachedCriteria = DetachedCriteria.forClass(Person.class);
//            System.out.println("session======" + HibernateUtil.getSessionFactory().openSession());
//            System.out.println("session1======" + HibernateUtil.getSessionFactory().getCurrentSession());
//            System.out.println("session2======" + HibernateUtil.getSessionFactory().getCurrentSession().close());
            Criteria criteria = detachedCriteria.getExecutableCriteria(session);
            detachedCriteria.add(Restrictions.eq("name","aiaia"));
            List<Person> people = criteria.list();
            System.out.println(people.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

public static void main(String[] args){
    ApplicationContext context = new ClassPathXmlApplicationContext("com/tw/beans/Person.beans.xml");// pay attention to the path
    Person person = (Person)context.getBean("person");
    System.out.println(person.getId());


//    Class<Person> classType = Person.class;
//    Object obj = classType.newInstance();

//    Person person1 = new Person();
//    Person person2 = person1.getClass().newInstance();

//    Object owner = new Object();
//
//    Class ownerClass = owner.getClass();
//
//    Field field = null;
//    try {
//        field = ownerClass.getField("name");
//    } catch (NoSuchFieldException e) {
//        e.printStackTrace();
//    }
//
//    Object property = field.get(owner);
//    test t = new test();
//    t.tests();


}
}
