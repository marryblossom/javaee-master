package com.tw.core.aopRealization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by marry on 7/15/15.
 */
public class BeanTest {
    public static void main(String[] args) {
        // 创建 Spring 容器
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("com/tw/beans/Chinese.beans.xml");
        Chinese p = ctx.getBean("chinese", Chinese.class);
        System.out.println(p.sayHello("张三"));
        p.eat("西瓜");
    }
}
