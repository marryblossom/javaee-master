package com.tw.core.controller.defalutController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by marry on 7/17/15.
 */
@Controller
@RequestMapping("/")
public class DefaultController {
    @RequestMapping("/")
    public  ModelAndView hello(HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        return new ModelAndView("index");
    }
//    @RequestMapping("/userOperate")
//    public ModelAndView employeeManagementPage(){
//        return new ModelAndView("redirect:/userOperate/hello");
//    }
    @RequestMapping("/schemaOperate")
    public ModelAndView schemaManagementPage(){
        return new ModelAndView("redirect:/schemaOperate/schemaShow");
    }
    @RequestMapping("/courseOperate")
     public ModelAndView courseManagementPage(){
        return new ModelAndView("redirect:/courseOperate/courseShow");
    }
    @RequestMapping("/userLogin")
    public ModelAndView userLoginManagementPage(){
        return new ModelAndView("redirect:/userLogin/goToLogin");
    }
    @RequestMapping("/customerOperate")
    public ModelAndView customerManagementPage(){
        return new ModelAndView("redirect:/customerOperate/customerShow");
    }
    @RequestMapping("/xmlTest")
    public ModelAndView xmlPage(){
        return new ModelAndView("redirect:/xmlTest/test");
    }

}
