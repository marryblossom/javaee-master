package com.tw.core.controller;

import com.tw.core.bean.Person;
import com.tw.core.service.HelloSelectService;
import com.tw.core.util.CookiesHelper;
import com.tw.core.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marry on 7/13/15.
 */
@Controller
public class LoginController {
    Person person;
    @RequestMapping("/goToLogin")
    public ModelAndView goToLogin() {
        return new ModelAndView("login");
    }
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("username")String name,
                              @RequestParam("password")String password,
                              HttpServletResponse response,HttpServletRequest request) {
        HelloSelectService selectService = new HelloSelectService();
        List<Person> people = selectService.getPeople();
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).getName().equals(name) && people.get(i).getPassword().equals(MD5Util.GetMD5Code(password))){
                person = people.get(i);
                CookiesHelper.setCookies(person,response,request);
                break;
            }
        }
        if (person != null){
            //SelectContrller selectController = new SelectContrller();
//            return selectController.helloWorld();//这样写在登录成功后，可能在页面获取不到已经存储的cookie
            return new ModelAndView("redirect:/hello");
        }else {
            return goToLogin();
        }
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response,@CookieValue(value="personid", defaultValue="") String personIdInCookie) {
        CookiesHelper.deleteCookies(request,response,personIdInCookie);
        return new ModelAndView("login");
    }
}
