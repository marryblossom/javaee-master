package com.tw.core.controller.userController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.bean.Employee;
import com.tw.core.bean.Schema;
import com.tw.core.bean.User;
import com.tw.core.service.employeeService.EmployeeService;
import com.tw.core.service.schemaService.SchemaService;
import com.tw.core.service.userService.UserService;
import com.tw.core.util.HibernateProxyTypeAdapter;
import com.tw.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by marry on 7/15/15.
 */
@RestController
@RequestMapping("/userOperate")
public class UserOperateController {
    private final static Logger logger = Logger.getLogger(UserOperateController.class.getName());
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
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SchemaService schemaService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public @ResponseBody String hello() {
        List<User> users = userService.getUsers();
        return gson.toJson(users);
    }

    @RequestMapping(value="/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        Employee employee = user.getEmployee();
        user.setState("locked");
        employee.setState("locked");
        userService.updateUser(user);
        employeeService.updateEmployee(employee);
        List<Schema> schemas = schemaService.getSchemasByEmployee(employee);
        schemaService.deleteAllSchemas(schemas);
    }

    @RequestMapping("/addUserAndEmployee")
    public void addUserAndEmployee(@RequestParam String username, String employeename, String password,
                                String gender, String introduction, String email) {
        UUID uuid = new UUID(6,6);
        Employee employee = new Employee(uuid.randomUUID().toString(),gender,email,introduction,"active","coach",employeename);
        User user = new User(uuid.randomUUID().toString(),employee,username,MD5Util.GetMD5Code(password),"active","employee");

        employeeService.insertEmployee(employee);
        userService.insertUser(user);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public void update(@RequestParam String userId,String username, String employeename, String gender,String password,
                               String introduction, String email,HttpServletResponse response) {
        User user = userService.getUserById(userId);
        Employee employee = user.getEmployee();

        user.setUserName(username);
        employee.setEmployeeName(employeename);
        employee.setGender(gender);
        employee.setEmail(email);
        employee.setIntroduction(introduction);

        employeeService.updateEmployee(employee);
        userService.updateUser(user);

    }

    @RequestMapping(value = "/unlock/{userId}", method = RequestMethod.GET)
    public void unlock(@PathVariable String userId){
        User user = userService.getUserById(userId);
        Employee employee = user.getEmployee();
        user.setState("active");
        employee.setState("active");
        userService.updateUser(user);
        employeeService.updateEmployee(employee);
    }
}
