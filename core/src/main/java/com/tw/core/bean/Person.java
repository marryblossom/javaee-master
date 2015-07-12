package com.tw.core.bean;

//@Entity
//@Table(name = "user")
public class Person {
    private String id;
    private String name;
    private String gender;
    private String email;
    private int  age;
  //  @Id
  //  @Column(name = "id")
  public Person(){

  }
    public Person(String id){
        this.id = id;
    }
    public String getId() {
        return id;
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
