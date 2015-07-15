package com.tw.core.controller;

import com.tw.core.aop.loginAop.ISLOGIN;
import com.tw.core.aop.loginAop.UserAccessAnnotation;
import com.tw.core.service.HelloDeleteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by marry on 7/13/15.
 */
@Controller
public class DeleteController {
    @RequestMapping("/delete")
   // @UserAccessAnnotation(isLogin= ISLOGIN.YES)
    public ModelAndView helloWorld(@RequestParam("id")String id,@CookieValue(value="personid", defaultValue="") String personIdInCookie) {
        if (!(personIdInCookie.equals(""))){
            HelloDeleteService deleteHelper = new HelloDeleteService();
            deleteHelper.deleltePerson(id);
            SelectContrller contrller = new SelectContrller();
            return contrller.helloWorld();
        }else {
            return new ModelAndView("login");
        }
    }
}
