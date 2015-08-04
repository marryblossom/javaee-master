package com.tw.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by marry on 7/26/15.
 */
@Controller
@RequestMapping("/xmlTest")
public class xmlTestController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test(HttpServletResponse response) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        response.setContentType("text/html;charset=utf-8");
        return new ModelAndView("views/xmlTest");
    }
    @RequestMapping(value = "/xml", method = RequestMethod.POST)
//    public ModelAndView xml(@RequestParam String username,String employeename, String password,HttpServletResponse response,H,ttpServletRequest request) {
    public ModelAndView xml(@RequestBody List<Object> object,HttpServletResponse response) {
//        request.body();
        System.out.println("data~~~~~~"+object);//a[b]=1&a[c]=2&d[]=3&d[]=4&d[2][e]=5
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
