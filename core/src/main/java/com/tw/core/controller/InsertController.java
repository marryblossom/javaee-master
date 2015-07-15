package com.tw.core.controller;

import com.tw.core.bean.Person;
import com.tw.core.service.HelloInsertService;
import com.tw.core.service.HelloSelectService;
import com.tw.core.util.CookiesHelper;
import com.tw.core.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by marry on 7/13/15.
 */
@Controller
public class InsertController {
    Map<String,Object> data = new HashMap<String,Object>();
    @RequestMapping("/insert")
    public ModelAndView addTest(@RequestParam("name")String name,
                                @RequestParam("password")String password,
                                @RequestParam("gender")String gender,
                                @RequestParam("age")String age,
                                @RequestParam("email")String email,
                                @CookieValue(value="personid", defaultValue="") String personIdInCookie) {
        UUID personId = new UUID(6,6);
        Person person = new Person(personId.randomUUID().toString());
        password = MD5Util.GetMD5Code(password);
        if (!(personIdInCookie.equals(""))){
            HelloInsertService insertService = new HelloInsertService();
            person.setAge(new Integer(age));
            person.setName(name);
            person.setPassword(password);
            person.setGender(gender);
            person.setEmail(email);
            insertService.insertPerson(person);
            SelectContrller contrller = new SelectContrller();
            return contrller.helloWorld();
      }else {
            return new ModelAndView("login");
        }


    }
}
