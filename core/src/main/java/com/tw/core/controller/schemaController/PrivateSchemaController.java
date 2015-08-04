package com.tw.core.controller.schemaController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.bean.Customer;
import com.tw.core.bean.Employee;
import com.tw.core.bean.Schema;
import com.tw.core.service.courseService.CourseService;
import com.tw.core.service.customerService.CustomerService;
import com.tw.core.service.employeeService.EmployeeService;
import com.tw.core.service.schemaService.SchemaService;
import com.tw.core.util.DateParseHelper;
import com.tw.core.util.HibernateProxyTypeAdapter;
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
    private Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
            .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
            .serializeNulls().setDateFormat("yyyy-MM-dd")//时间转化为特定格式
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
            .setPrettyPrinting() //对json结果格式化.
            .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                    //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
                    //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();
    @Autowired
    private SchemaService schemaService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @RequestMapping(value = "/schemaPrivateShow" , method= RequestMethod.GET)
    public @ResponseBody String schemaPrivateShow() {
        List<Schema> schemas = schemaService.getPrivateSchemas();
        return gson.toJson(schemas);
    }
    @RequestMapping(value = "/schemaPrivateCustomer" , method= RequestMethod.GET)
    public @ResponseBody String schemaPrivateCustomer() {
        List<Customer> customers = customerService.getCustomerOnlyActive();
        return gson.toJson(customers);
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
