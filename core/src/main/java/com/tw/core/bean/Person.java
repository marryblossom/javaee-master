package com.tw.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

//@Entity
//@Table(name = "user")
public class Person {
    private String id;
    private String name;
    private String password;
    private String gender;
    private String email;
    private int  age;
//    @Autowired//自动注入类型为testIoC的bean
//    @Qualifier("testIoC")//指将容器中id为testIoC作为对象注入，@Qualifier 对方法签名中入参进行注释会降低代码的可读性，而对成员变量注释则相对好一些。
//
//    //@Resource(name = "office")// 自动注入 bean 名称为 office 的 Bean
//    private testIoC testIoC;
  //  @Id
  //  @Column(name = "id")
  public Person(){

  }
   // public Person(testIoC testIoC){this.testIoC = testIoC;}
    public Person(String id){
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }
   // @Column(name = "name")
    public String getName(){
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

}
