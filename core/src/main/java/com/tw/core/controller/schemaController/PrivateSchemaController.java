package com.tw.core.controller.schemaController;

import com.tw.core.bean.Customer;
import com.tw.core.bean.Employee;
import com.tw.core.bean.Schema;
import com.tw.core.service.courseService.CourseService;
import com.tw.core.service.customerService.CustomerService;
import com.tw.core.service.employeeService.EmployeeService;
import com.tw.core.service.schemaService.SchemaService;
import com.tw.core.util.DateParseHelper;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by marry on 7/30/15.
 */
@RestController
@RequestMapping("/privateSchemaOperate")
public class PrivateSchemaController {
    @Autowired
    private SchemaService schemaService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    JSONSerializer j = new JSONSerializer();
    @RequestMapping(value = "/schemaPrivateShow" , method= RequestMethod.GET)
    public @ResponseBody String schemaPrivateShow() {
        List<Schema> schemas = schemaService.getPrivateSchemas();
        return j.include("course").include("employee").include("customer").serialize(schemas);
    }
    @RequestMapping(value = "/schemaPrivateCustomer" , method= RequestMethod.GET)
    public @ResponseBody String schemaPrivateCustomer() {
        List<Customer> customers = customerService.getCustomerOnlyActive();
        System.out.println(customers.size());
        return j.serialize(customers);
    }
    @RequestMapping(value = "/addPrivateSchema" , method= RequestMethod.POST)
    public void addPrivateSchema(@RequestParam String customerId,String courseId, String coachId, String date) {
        Employee employee = employeeService.getEmployeeById(coachId);
        if (schemaService.schemaAtThisTimeExist(employee, DateParseHelper.datePasrser(date))){
            System.out.println("has existed~~~~~~~~~~~~~~~~");
        }else {

            UUID uuId = new UUID(6, 6);
            Schema schema = new Schema();
//            Schema schema = new Schema(uuId.randomUUID().toString(),courseService.getCourseById(courseId),customerService.getCustomerById(customerId),employee,DateParseHelper.datePasrser(date),"active","coach");
            schema.setSchemaId(uuId.randomUUID().toString());
            schema.setCustomer(customerService.getCustomerById(customerId));
            schema.setCourse(courseService.getCourseById(courseId));
            schema.setEmployee(employee);
            schema.setDate(DateParseHelper.datePasrser(date));
            schema.setState("active");
            schema.setType("private");
            System.out.println("!!!!!!!"+customerId+"------"+courseId+"++++"+coachId+">>>>>"+date);
            schemaService.insertSchema(schema);
        }
    }
}
