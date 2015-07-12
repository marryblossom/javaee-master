package com.tw.web.util;

import com.tw.core.bean.Person;
import com.tw.core.service.HelloInsertService;
import com.tw.core.service.HelloSelectService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HttpHelper extends HttpServlet {
    public void doGetHelper (HttpServletRequest req, HttpServletResponse res, String jsp) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        res.setCharacterEncoding("utf-8");
        HelloSelectService personService = new HelloSelectService();
        List<Person> people= personService.getPeople();
        req.setAttribute("people", people);
        req.getRequestDispatcher("index.jsp").forward(req,res);
//        PrintWriter out = res.getWriter();
//        out.print(people.get(0).getAge());
//        out.close();

    }
}
