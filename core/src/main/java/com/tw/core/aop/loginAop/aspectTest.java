package com.tw.core.aop.loginAop;

/**
 * Created by marry on 7/15/15.
 */
public class aspectTest {
    public static void main(String[] args){
//        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring-servlet.beans.xml");// pay attention to the path
//        Person person = (Person)context.getBean("permission");
//        System.out.println(person.getId());
        aspectNeed aspectNeed = new aspectNeed();
        aspectNeed.system();


    }
}
