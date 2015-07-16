package com.tw.web.util;


import com.tw.core.service.userService.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpHelper extends HttpServlet {
    UserService personService = new UserService();
    public void doGetHelper (HttpServletRequest req, HttpServletResponse res, String jsp) throws ServletException, IOException {
//        res.setContentType("text/html;charset=UTF-8");
//        res.setCharacterEncoding("utf-8");
//        List<Person> people= personService.getPeople();
//        req.setAttribute("people", people);
//        req.getRequestDispatcher("index.jsp").forward(req,res);
    }
}
