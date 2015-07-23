package com.tw.core.controller.userController;

import com.tw.core.bean.Employee;
import com.tw.core.bean.Schema;
import com.tw.core.bean.User;
import com.tw.core.service.employeeService.EmployeeService;
import com.tw.core.service.schemaService.SchemaService;
import com.tw.core.service.userService.UserService;
import com.tw.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * Created by marry on 7/15/15.
 */
@Controller
@RequestMapping("/userOperate")
public class UserOperateController {
    private static Logger logger = Logger.getLogger("UserOperateController");

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SchemaService schemaService;
    Map<String,Object> data = new HashMap<String,Object>();

//    @RequestMapping("/hello")
//    //@RequestMapping(params = "method=helloWorld")
//    //@RequestMapping(params = "method=helloWorld",method = RequestMethod.POST)   //它可以让 Controller 方法处理特定 HTTP 请求方式的请求，
//    //这样前端的请求方式必须写为/hello?method=helloWorld    。。。如果方法需要获取参数则请求方式后面加上：例&data=33，
//    //这样Spring 不但让 helloWorld() 方法处理这个请求，而且还将data 请求参数在类型转换后绑定到 helloWorld() 方法的data 入参上。
//    public ModelAndView helloWorld() {
//        List<Person> people = personService.getPeople();
//        data.put("people", people);
//        return new ModelAndView("index", data);
//
//    }
    @RequestMapping("/hello")
    public ModelAndView hello() {
        List<User> users = userService.getUsers();
        data.put("users", users);
        return new ModelAndView("user", data);

    }
    @RequestMapping("/delete")
    // @UserAccessAnnotation(isLogin= ISLOGIN.YES)
    public ModelAndView delete(@RequestParam("userId")String userId) {
        User user = userService.getUserById(userId);
        Employee employee = user.getEmployee();

        user.setState("locked");
        employee.setState("locked");

        userService.updateUser(user);
        employeeService.updateEmployee(employee);
        List<Schema> schemas = schemaService.getSchemasByEmployee(employee);
        schemaService.deleteAllSchemas(schemas);
        return new ModelAndView("redirect:/userOperate/hello");
    }
    @RequestMapping("/addUserAndEmployee")
    public ModelAndView addUserAndEmployee(@RequestParam("username")String username,
                                @RequestParam("employeename")String employeename,
                                @RequestParam("password")String password,
                                @RequestParam("gender")String gender,
                                @RequestParam("introduction")String introduction,
                                @RequestParam("email")String email) {
        UUID employeeId = new UUID(6, 6);
        Employee employee = new Employee();
        employee.setEmloyeeId(employeeId.randomUUID().toString());
        employee.setEmail(email);
        employee.setEmployeeName(employeename);
        employee.setGender(gender);
        employee.setIntroduction(introduction);
        employee.setType("coach");
        employee.setState("active");

        UUID userId = new UUID(6, 6);
        User user = new User();
        user.setUserId(userId.randomUUID().toString());
        user.setPassword(MD5Util.GetMD5Code(password));
        user.setEmployee(employee);
        user.setUserName(username);
        user.setState("active");
        employeeService.insertEmployee(employee);
        userService.insertUser(user);
        return new ModelAndView("redirect:/userOperate/hello");
    }

    @RequestMapping("/goToUpdate")
    public ModelAndView goToUpdate(@RequestParam("userId")String userId) {
            User user = userService.getUserById(userId);
            data.put("user",user);
            return new ModelAndView("userUpdate", data);
    }
    @RequestMapping("/update")
    public ModelAndView update(@RequestParam("userId")String userId,
                               @RequestParam("employeeName")String employeeName,
                               @RequestParam("gender")String gender,
                               @RequestParam("introduction")String introduction,
                               @RequestParam("email")String email) {
        Employee employee = userService.getUserById(userId).getEmployee();
        employee.setEmployeeName(employeeName);
        employee.setGender(gender);
        employee.setEmail(email);
        employee.setIntroduction(introduction);
        employeeService.updateEmployee(employee);
        return new ModelAndView("redirect:/userOperate/hello");

    }
    @RequestMapping(value = "/unlock", method = RequestMethod.GET)
    public ModelAndView unlock(@RequestParam("userId")String userId){
        User user = userService.getUserById(userId);
        Employee employee = user.getEmployee();
        user.setState("active");
        employee.setState("active");
        userService.updateUser(user);
        employeeService.updateEmployee(employee);
        return new ModelAndView("redirect:/userOperate/hello");
    }
}
