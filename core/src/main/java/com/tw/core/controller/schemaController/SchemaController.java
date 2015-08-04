package com.tw.core.controller.schemaController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.bean.*;
import com.tw.core.service.courseService.CourseService;
import com.tw.core.service.employeeService.EmployeeService;
import com.tw.core.service.schemaService.SchemaService;
import com.tw.core.util.DateParseHelper;
import com.tw.core.util.HibernateProxyTypeAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    Map<String,Object> data = new HashMap<String,Object>();

    @RequestMapping(value = "/schemaShow", method= RequestMethod.GET)
    public @ResponseBody String schemaShow() {
        List<Schema> schemas = schemaService.getSchemas();
        return gson.toJson(schemas);
    }
    @RequestMapping(value = "/schemaEmployeeShow", method= RequestMethod.GET)
    public @ResponseBody String schemaEmployeeShow() {
        List<Employee> employees = employeeService.getEmployeesOnlyActive();
        return gson.toJson(employees);
    }
    @RequestMapping(value = "/schemaCourseShow", method= RequestMethod.GET)
    public @ResponseBody String schemaCourseShow() {
        List<Course> courses = courseService.getCoursesOnlyActive();
        return gson.toJson(courses);
    }
    @RequestMapping(value = "/addSchema", method = RequestMethod.POST)
    public @ResponseBody String addSchema(@RequestParam String courseId, String coachId, String date) {
    System.out.println(date);

        Employee employee = employeeService.getEmployeeById(coachId);
        System.out.println("ddd~~~~~"+(schemaService.schemaAtThisTimeExist(employee,DateParseHelper.datePasrser(date))));

        if (!(schemaService.schemaAtThisTimeExist(employee,DateParseHelper.datePasrser(date)))){
            UUID uuId = new UUID(6,6);
//            Schema schema = new Schema(uuId.randomUUID().toString(),courseService.getCourseById(courseId),null,employeeService.getEmployeeById(coachId),DateParseHelper.datePasrser(date),"active","public");
            Schema schema = new Schema();
            schema.setSchemaId(uuId.randomUUID().toString());
            schema.setCourse(courseService.getCourseById(courseId));
            System.out.println(courseService.getCourseById(courseId));
            System.out.println(employeeService.getEmployeeById(coachId));
            schema.setEmployee(employeeService.getEmployeeById(coachId));
            schema.setDate(DateParseHelper.datePasrser(date));
            schema.setState("active");
            schema.setType("public");
            schemaService.insertSchema(schema);
            return gson.toJson("noExist");
        }else{
            return gson.toJson("exist");
        }
    }
    @RequestMapping(value = "/{schemaId}",method = RequestMethod.DELETE)
    public void deleteSchema(@PathVariable String schemaId) {
        schemaService.equals(schemaId);
        schemaService.delelteSchema(schemaId);
    }
//    @RequestMapping("/goToSchemaUpdate")
//    public ModelAndView goToSchemaUpdate(@RequestParam("schemasId")String schemasId,
//                                         @CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
//        Schema schema = schemaService.getSchemaById(schemasId);
//        data.put("schema", schema);
//        return new ModelAndView("schemaUpdate", data);
//    }
//    @RequestMapping("/schemaUpdate")
//    public ModelAndView schemaUpdate(@RequestParam("schemaId")String schemaId,
//                                         @RequestParam("date") String date) {
//        Schema schema = schemaService.getSchemaById(schemaId);
//        schema.setDate(DateParseHelper.datePasrser(date));
//        schemaService.updateSchema(schema);
//        return new ModelAndView("redirect:/schemaOperate/schemaShow");
//    }

}
