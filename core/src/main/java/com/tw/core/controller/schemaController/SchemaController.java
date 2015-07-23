package com.tw.core.controller.schemaController;

import com.tw.core.bean.*;
import com.tw.core.service.courseService.CourseService;
import com.tw.core.service.customerService.CustomerService;
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
    @Autowired
    private CustomerService customerService;
    Map<String,Object> data = new HashMap<String,Object>();
    @RequestMapping(value = "/schemaShow", method= RequestMethod.GET)
    public ModelAndView schemaShow() {
        List<Schema> schemas = schemaService.getSchemas();

//        List<SchemaTable> schemaTables = schemaService.getAllSchemaTables();
        List<Course> courses = courseService.getCoursesOnlyActive();
        List<Employee> employees = employeeService.getEmployeesOnlyActive();

        data.put("schemas", schemas);
        data.put("courses", courses);
        data.put("employees",employees);
        return new ModelAndView("schema", data);
    }
    @RequestMapping("/addSchema")
    public ModelAndView addSchema(@RequestParam("courseId")String courseId,
                                  @RequestParam("coachId")String coachId,
                                  @RequestParam("date")String date) {
        Schema schema = new Schema();
        UUID schemaId = new UUID(6,6);
        Employee employee = employeeService.getEmployeeById(coachId);
        if (schemaService.schemaAtThisTimeExist(employee,DateParseHelper.datePasrser(date))){
            System.out.println("has existed~~~~~~~~~~~~~~~~");
        }else{
            System.out.println("nothing existed~~~~~~~~~~~~~~~~");
            schema.setSchemaId(schemaId.randomUUID().toString());
            schema.setCourse(courseService.getCourseById(courseId));
            schema.setEmployee(employeeService.getEmployeeById(coachId));
            schema.setDate(DateParseHelper.datePasrser(date));
            schema.setState("active");
            schema.setType("public");
            schemaService.insertSchema(schema);
        }

        return new ModelAndView("redirect:/schemaOperate/schemaShow");
    }
    @RequestMapping("/deleteSchema")
    public ModelAndView deleteSchema(@RequestParam("schemasId")String schemasId,@CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
        schemaService.equals(schemasId);
//        schemaService.deleteAllSchemaByIds(schemasId.toString());
        schemaService.delelteSchema(schemasId);
        return new ModelAndView("redirect:/schemaOperate/schemaShow");
    }
    @RequestMapping("/goToSchemaUpdate")
    public ModelAndView goToSchemaUpdate(@RequestParam("schemasId")String schemasId,
                                         @CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
        Schema schema = schemaService.getSchemaById(schemasId);
        data.put("schema", schema);
        return new ModelAndView("schemaUpdate", data);
    }
    @RequestMapping("/schemaUpdate")
    public ModelAndView schemaUpdate(@RequestParam("schemaId")String schemaId,
                                         @RequestParam("date") String date) {
        Schema schema = schemaService.getSchemaById(schemaId);
        schema.setDate(DateParseHelper.datePasrser(date));
        schemaService.updateSchema(schema);
        return new ModelAndView("redirect:/schemaOperate/schemaShow");
    }


    @RequestMapping(value = "/schemaPrivateShow" , method= RequestMethod.GET)
    public ModelAndView schemaPrivateShow() {
        List<Schema> schemas = schemaService.getPrivateSchemas();
        List<Course> courses = courseService.getCoursesOnlyActive();
        List<Employee> employees = employeeService.getEmployeesOnlyActive();
        List<Customer> customers = customerService.getCustomerOnlyActive();

        data.put("customers",customers);
        data.put("schemas", schemas);
        data.put("courses", courses);
        data.put("employees", employees);
        return new ModelAndView("privateSchema", data);
    }

    @RequestMapping(value = "/addPrivateSchema" , method= RequestMethod.POST)
    public ModelAndView addPrivateSchema(@RequestParam("customerId")String customerId,@RequestParam("courseId")String courseId,
                                  @RequestParam("coachId")String coachId,
                                  @RequestParam("date")String date,
                                  @CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
        Employee employee = employeeService.getEmployeeById(coachId);
        if (schemaService.schemaAtThisTimeExist(employee,DateParseHelper.datePasrser(date))){
            System.out.println("has existed~~~~~~~~~~~~~~~~");
        }else {
            Schema schema = new Schema();
            UUID schemaId = new UUID(6, 6);
            schema.setSchemaId(schemaId.randomUUID().toString());
            schema.setCustomer(customerService.getCustomerById(customerId));
            schema.setCourse(courseService.getCourseById(courseId));
            schema.setEmployee(employee);
            schema.setDate(DateParseHelper.datePasrser(date));
            schema.setState("active");
            schema.setType("private");
            schemaService.insertSchema(schema);
        }
        return new ModelAndView("redirect:/schemaOperate/schemaPrivateShow");
    }
}
