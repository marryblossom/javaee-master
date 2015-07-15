package com.tw.web.servlet;

import com.tw.web.util.HttpHelper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloUpdateServlet extends HttpServlet {
    HttpHelper helper = new HttpHelper();
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        res.setContentType("text/html;charset=UTF-8");
//        res.setCharacterEncoding("utf-8");
//        HelloSelectService updateServer = new HelloSelectService();
//        Person person = updateServer.getPersonById(req.getParameter("id"));
//        req.setAttribute("person",person);
//        req.getRequestDispatcher("person.jsp").forward(req, res);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        String name = req.getParameter("name");
//        String gender = req.getParameter("gender");
//        String email = req.getParameter("email");
//        String age = req.getParameter("age");
//        HelloUpdateServer updateServer = new HelloUpdateServer();
//        Person person = new Person(id);
//        person.setName(name);
//        person.setEmail(email);
//        person.setGender(gender);
//        person.setAge(new Integer(age));
//        System.out.println(id);
//        updateServer.updatePerson(person);
//        res.sendRedirect("/web/hello");

    }
}
