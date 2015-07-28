package com.tw.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by marry on 7/26/15.
 */
@Controller
@RequestMapping("/xmlTest")
public class xmlTestController {
    @RequestMapping("/test")
    public ModelAndView test() {
        return new ModelAndView("xmlTest");
    }
    @RequestMapping("/xml")
    public ModelAndView xml(@RequestParam String city,String state,HttpServletResponse response) {
        System.out.println(city);
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write(city+"  "+state);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
