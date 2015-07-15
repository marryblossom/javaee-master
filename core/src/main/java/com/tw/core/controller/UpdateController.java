package com.tw.core.controller;

import com.tw.core.bean.Person;
import com.tw.core.service.HelloSelectService;
import com.tw.core.service.HelloUpdateServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marry on 7/13/15.
 */
@Controller
public class UpdateController {
    HelloSelectService selectService = new HelloSelectService();
    HelloUpdateServer updateServer = new HelloUpdateServer();
    Map<String,Object> data = new HashMap<String,Object>();
    @RequestMapping("/goToUpdate")
    public ModelAndView goToUpdate(@RequestParam("id")String id,@CookieValue(value="personid", defaultValue="") String personIdInCookie) {
        if (!(personIdInCookie.equals(""))){
            Person person = selectService.getPersonById(id);
            data.put("person",person);
            return new ModelAndView("person", data);
        }
        else {
            return new ModelAndView("login");
        }
    }
    @RequestMapping("/update")
    public ModelAndView update(@RequestParam("id")String id,
                               @RequestParam("name")String name,
                                @RequestParam("gender")String gender,
                                @RequestParam("age")String age,
                                @RequestParam("email")String email,
                               @CookieValue(value="personid", defaultValue="") String personIdInCookie) {
        if (!(personIdInCookie.equals(""))){
            Person person = new Person(id);
            person.setAge(new Integer(age));
            person.setName(name);
            person.setGender(gender);
            person.setEmail(email);
            updateServer.updatePerson(person);
            SelectContrller contrller = new SelectContrller();
            return contrller.helloWorld();
        }else{
            return new ModelAndView("login");
        }

    }


    @RequestMapping("/goToUpdatePassword")
    public ModelAndView goToUpdatePassword(@RequestParam("id")String id) {
        Person person = selectService.getPersonById(id);
        data.put("person",person);
        return new ModelAndView("changePassword", data);
    }
    @RequestMapping("/updatePassword")
    public ModelAndView updatePassword(@RequestParam("id")String id,
                               @RequestParam("oldPassword")String oldPassword,
                               @RequestParam("newPassword")String newPassword,
                                       @CookieValue(value="personid", defaultValue="") String personIdInCookie) {
        Person person = selectService.getPersonById(id);
        person.setPassword(newPassword);
        updateServer.updatePerson(person);
        SelectContrller contrller = new SelectContrller();
        return contrller.helloWorld();
    }

}
