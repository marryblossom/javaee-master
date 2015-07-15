package com.tw.web.servlet;

import com.tw.core.bean.Person;
import com.tw.core.service.HelloInsertService;
import com.tw.web.util.HttpHelper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class HelloInsertServlet extends HttpServlet {
    HttpHelper helper = new HttpHelper();
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        helper.doGetHelper(req, res, "index.jsp");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String gender = req.getParameter("gender");
//        String email  = req.getParameter("email");
//        String age = req.getParameter("age");
//        UUID personId = new UUID(6,6);
//        Person person = new Person(personId.randomUUID().toString());
//        person.setName(name);
//        person.setAge(new Integer(age));
//        person.setGender(gender);
//        person.setEmail(email);
//        HelloInsertService insertService  =  new HelloInsertService();
//        insertService.insertPerson(person);
//        res.sendRedirect("/web/hello");

    }
}