package com.tw.core.controller;


import com.tw.core.service.personservice.PersonService;
import com.tw.core.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by marry on 7/15/15.
 */
//@Controller
////@RequestMapping("/userOperate")
public class UserOperateController {
//    PersonService personService = new PersonService();
//    Map<String,Object> data = new HashMap<String,Object>();
//    @RequestMapping("/")
//    public ModelAndView indexPage(){
//        return helloWorld();
//    }
//
//    @RequestMapping("/hello")
//    //@RequestMapping(params = "method=helloWorld")
//    //@RequestMapping(params = "method=helloWorld",method = RequestMethod.POST)   //它可以让 Controller 方法处理特定 HTTP 请求方式的请求，
//    //这样前端的请求方式必须写为/hello?method=helloWorld    。。。如果方法需要获取参数则请求方式后面加上：例&data=33，
//    //这样Spring 不但让 helloWorld() 方法处理这个请求，而且还将data 请求参数在类型转换后绑定到 helloWorld() 方法的data 入参上。
//    public ModelAndView helloWorld() {
//        List<Person> people = personService.getPeople();
//        data.put("people", people);
//        return new ModelAndView("index", data);
//
//    }
//    @RequestMapping("/delete")
//    // @UserAccessAnnotation(isLogin= ISLOGIN.YES)
//    public ModelAndView helloWorld(@RequestParam("id")String id,@CookieValue(value="personid", defaultValue="") String personIdInCookie) {
//        if (!(personIdInCookie.equals(""))){
//            personService.deleltePerson(id);
//            return new ModelAndView("redirect:/hello");
//        }else {
//            return new ModelAndView("login");
//        }
//    }
//    @RequestMapping("/insert")
//    public ModelAndView addTest(@RequestParam("name")String name,
//                                @RequestParam("password")String password,
//                                @RequestParam("gender")String gender,
//                                @RequestParam("age")String age,
//                                @RequestParam("email")String email,
//                                @CookieValue(value="personid", defaultValue="") String personIdInCookie) {
//        UUID personId = new UUID(6,6);
//        Person person = new Person(personId.randomUUID().toString());
//        password = MD5Util.GetMD5Code(password);
//        if (!(personIdInCookie.equals(""))){
//            person.setAge(new Integer(age));
//            person.setName(name);
//            person.setPassword(password);
//            person.setGender(gender);
//            person.setEmail(email);
//            personService.insertPerson(person);
//            return new ModelAndView("redirect:/hello");
//        }else {
//            return new ModelAndView("login");
//        }
//
//
//    }
//    @RequestMapping("/goToUpdate")
//    public ModelAndView goToUpdate(@RequestParam("id")String id,
//                                   @CookieValue(value="personid", defaultValue="") String personIdInCookie) {
//        if (!(personIdInCookie.equals(""))){
//            Person person = personService.getPersonById(id);
//            data.put("person",person);
//            return new ModelAndView("person", data);
//        }
//        else {
//            return new ModelAndView("login");
//        }
//    }
//    @RequestMapping("/update")
//    public ModelAndView update(@RequestParam("id")String id,
//                               @RequestParam("name")String name,
//                               @RequestParam("gender")String gender,
//                               @RequestParam("age")String age,
//                               @RequestParam("email")String email,
//                               @CookieValue(value="personid", defaultValue="") String personIdInCookie) {
//        if (!(personIdInCookie.equals(""))){
//            Person person = new Person(id);
//            person.setAge(new Integer(age));
//            person.setName(name);
//            person.setGender(gender);
//            person.setEmail(email);
//            personService.updatePerson(person);
//            return new ModelAndView("redirect:/hello");
//        }else{
//            return new ModelAndView("login");
//        }
//
//    }
//
//    @RequestMapping("/goToUpdatePassword")
//    public ModelAndView goToUpdatePassword(@RequestParam("id")String id) {
//        Person person = personService.getPersonById(id);
//        data.put("person",person);
//        return new ModelAndView("changePassword", data);
//    }
//    @RequestMapping("/updatePassword")
//    public ModelAndView updatePassword(@RequestParam("id")String id,
//                                       @RequestParam("oldPassword")String oldPassword,
//                                       @RequestParam("newPassword")String newPassword,
//                                       @CookieValue(value="personid", defaultValue="") String personIdInCookie) {
//        Person person = personService.getPersonById(id);
//        person.setPassword(newPassword);
//        personService.updatePerson(person);
//        return new ModelAndView("redirect:/hello");
//    }

}
