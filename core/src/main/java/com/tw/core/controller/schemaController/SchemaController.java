package com.tw.core.controller.schemaController;

import com.tw.core.bean.*;
import com.tw.core.service.courseService.CourseService;
import com.tw.core.service.customerService.CustomerService;
import com.tw.core.service.employeeService.EmployeeService;
import com.tw.core.service.schemaService.SchemaService;
import com.tw.core.util.DateParseHelper;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by marry on 7/19/15.
 */
@RestController
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
    public @ResponseBody String schemaShow() {
        JSONSerializer j = new JSONSerializer();
        List<Schema> schemas = schemaService.getSchemas();
//        return "1234";
        return j.include("employee","course").serialize(schemas);
    }
    @RequestMapping(value = "/schemaEmployeeShow", method= RequestMethod.GET)
    public @ResponseBody String schemaEmployeeShow() {
        JSONSerializer j = new JSONSerializer();
        List<Employee> employees = employeeService.getEmployeesOnlyActive();
        return j.serialize(employees);
    }
    @RequestMapping(value = "/schemaCourseShow", method= RequestMethod.GET)
    public @ResponseBody String schemaCourseShow() {
        JSONSerializer j = new JSONSerializer();
        List<Course> courses = courseService.getCoursesOnlyActive();
        return j.serialize(courses);
    }
    @RequestMapping(value = "/addSchema", method = RequestMethod.POST)
    public void addSchema(@RequestParam String courseId, String coachId, String date) {

        Schema schema = new Schema();
        UUID schemaId = new UUID(6,6);
        Employee employee = employeeService.getEmployeeById(coachId);
        System.out.println("employee~~~~"+employee.getEmployeeName());
        if (schemaService.schemaAtThisTimeExist(employee,DateParseHelper.datePasrser(date))){
        }else{
            schema.setSchemaId(schemaId.randomUUID().toString());
            schema.setCourse(courseService.getCourseById(courseId));
            schema.setEmployee(employeeService.getEmployeeById(coachId));
            schema.setDate(DateParseHelper.datePasrser(date));
            schema.setState("active");
            schema.setType("public");
            schemaService.insertSchema(schema);
        }
    }
    @RequestMapping(value = "/{schemaId}",method = RequestMethod.DELETE)
    public void deleteSchema(@PathVariable String schemaId) {
        schemaService.equals(schemaId);
//        schemaService.deleteAllSchemaByIds(schemasId.toString());
        schemaService.delelteSchema(schemaId);
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

}
