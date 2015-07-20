package com.tw.core.controller.schemaController;

import com.tw.core.bean.*;
import com.tw.core.service.courseService.CourseService;
import com.tw.core.service.employeeService.EmployeeService;
import com.tw.core.service.schemaService.SchemaService;
import com.tw.core.util.DateParseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by marry on 7/19/15.
 */
@Controller
@RequestMapping("/schemaOperate")
public class SchemaController {
    private static Logger logger = Logger.getLogger("SchemaController");
    @Autowired
   private SchemaService schemaService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeService employeeService;
    Map<String,Object> data = new HashMap<String,Object>();
    @RequestMapping(value = "/schemaShow", method= RequestMethod.GET)
    public ModelAndView schemaShow() {
        List<SchemaTable> schemaTables = schemaService.getAllSchemaTables();
        List<Course> courses = courseService.getCourses();
        List<Employee> employees = employeeService.getEmployees();
        data.put("schemaTables", schemaTables);
        data.put("courses", courses);
        data.put("employees",employees);
        return new ModelAndView("schema", data);
    }
    @RequestMapping("/addSchema")
    // @UserAccessAnnotation(isLogin= ISLOGIN.YES)
    public ModelAndView addSchema(@RequestParam("courseId")String courseId,
                                  @RequestParam("coachId")String coachId,
                                  @RequestParam("date")String date,
                                  @CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
//        if (!(userIdInCookie.equals(""))){
        Schema schema = new Schema();
        UUID schemaId = new UUID(6,6);
        schema.setSchemaId(schemaId.randomUUID().toString());
        schema.setCourse(courseService.getCourseById(courseId));
        schema.setEmployee(employeeService.getEmployeeById(coachId));
        schema.setDate(DateParseHelper.datePasrser(date));
        schema.setState("active");
        schemaService.insertSchema(schema);
        return new ModelAndView("redirect:/schemaOperate/schemaShow");
//        }else {
//            return new ModelAndView("login");
//        }
    }
    @RequestMapping("/deleteSchema")
    // @UserAccessAnnotation(isLogin= ISLOGIN.YES)
    public ModelAndView deleteSchema(@RequestParam("schemasId")String schemasId,@CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
//        if (!(userIdInCookie.equals(""))){
        schemaService.deleteAllSchema(schemasId.toString());
        return new ModelAndView("redirect:/schemaOperate/schemaShow");
//        }else {
//            return new ModelAndView("login");
//        }
    }
    @RequestMapping("/goToSchemaUpdate")
    public ModelAndView goToSchemaUpdate(@RequestParam("schemasId")String schemasId,
                                         @CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
//        if (!(userIdInCookie.equals(""))){
        List<Schema> schemas = schemaService.getSchemaTablesByIds(schemasId);
        data.put("schemas",schemas);
        return new ModelAndView("schemaUpdate", data);
//        }
//        else {
//            return new ModelAndView("login");
//        }
    }
    @RequestMapping("/schemaUpdate")
    public ModelAndView schemaUpdate(@RequestParam("schemaId")String schemaId,
                                         @RequestParam("date") String date,
                                     HttpServletRequest request) {
//        if (!(userIdInCookie.equals(""))){
        Schema schema = schemaService.getSchemaById(schemaId);
        logger.info(date);
        schema.setDate(DateParseHelper.datePasrser(date));
        schemaService.updateSchema(schema);
        return new ModelAndView("redirect:/schemaOperate/schemaShow");
//        }
//        else {
//            return new ModelAndView("login");
//        }
    }

}
