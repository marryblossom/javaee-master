package com.tw.core.controller.userController;

import com.tw.core.business.userLoginService.HelloLoginService;
import com.tw.core.util.CookiesHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by marry on 7/13/15.
 */
@Controller
//@RequestMapping("/userLogin")
public class UserLoginController {
//    Person person;
//    @RequestMapping("/goToLogin")
//    public ModelAndView goToLogin() {
//        return new ModelAndView("login");
//    }
//    @RequestMapping("/login")
//    public ModelAndView login(@RequestParam("username")String name,
//                              @RequestParam("password")String password,
//                              HttpServletResponse response,HttpServletRequest request) {
//        person = new HelloLoginService().getLoginPerson(response,request,name,password);
//        if (person != null){
//
//            return new ModelAndView("redirect:/hello");
//        }else {
//            return new ModelAndView("login");
//        }
//    }
//
//    @RequestMapping("/logout")
//    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response,
//                               @CookieValue(value="personid", defaultValue="") String personIdInCookie) {
//        CookiesHelper.deleteCookies(request,response,personIdInCookie);
//        return new ModelAndView("login");
//    }
}
