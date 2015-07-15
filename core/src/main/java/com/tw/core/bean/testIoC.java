package com.tw.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by marry on 7/14/15.
 */
public class testIoC {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;

    }
    @PostConstruct
    public void postConstruct1(){
        System.out.println("postConstruct1");
    }

    @PreDestroy
    public void preDestroy1(){
        System.out.println("preDestroy1");
    }

    public static void main(String[] args){

//        标注了 @PostConstruct 的 postConstruct1() 方法将在 Spring 容器启动时，创建 testIoC Bean 的时候被触发执行，
//         而标注了 @PreDestroy 注释的 preDestroy1() 方法将在 Spring 容器关闭前销毁 testIoC Bean 的时候被触发执行。

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/tw/beans/Person.beans.xml");
//        testIoC testIoC1 = (testIoC)context.getBean("testIoC");
//        System.out.println(testIoC1);
//        context.destroy();// 关闭 Spring 容器，以触发 Bean 销毁方法的执行

    }
}
