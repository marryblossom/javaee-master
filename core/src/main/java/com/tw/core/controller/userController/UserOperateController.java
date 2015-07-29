package com.tw.core.controller.userController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.bean.Employee;
import com.tw.core.bean.Schema;
import com.tw.core.bean.User;
import com.tw.core.org.json.JSONException;
import com.tw.core.org.json.JSONObject;
import com.tw.core.service.employeeService.EmployeeService;
import com.tw.core.service.schemaService.SchemaService;
import com.tw.core.service.userService.UserService;
import com.tw.core.util.HibernateProxyTypeAdapter;
import com.tw.core.util.MD5Util;
import com.tw.core.util.StringSplitHelper;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by marry on 7/15/15.
 */
@RestController
@RequestMapping("/userOperate")
public class UserOperateController {
    private static Logger logger = Logger.getLogger("UserOperateController");

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SchemaService schemaService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public @ResponseBody String hello() {
        List<User> users = userService.getUsers();
        JSONSerializer j = new JSONSerializer();
        return j.include("employee").serialize(users);

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
        User user = new User(uuid.randomUUID().toString(),employee,username,MD5Util.GetMD5Code(password),"active","");
        employeeService.insertEmployee(employee);
        userService.insertUser(user);
    }

    @RequestMapping(value = "/goToUpdate/{userId}", method = RequestMethod.GET)
    public @ResponseBody String goToUpdate(@PathVariable String userId,HttpServletResponse response) {
        User user = userService.getUserById(userId);
//        try {
//            JSONObject userJson = new JSONObject("{'userId':'"+user.getUserId()+
//                                                    "','userName':'"+user.getUserName() +
//                                                    "','employeeName':'"+user.getEmployee().getEmployeeName()+
//                                                    "','gender':'"+user.getEmployee().getGender()+
//                                                    "','email':'"+user.getEmployee().getEmail()+
//                                                    "','introduction':'"+user.getEmployee().getIntroduction()+
//                                                    "','userState':'"+user.getEmployee().getState()+
//                                                    "','userType':'"+user.getEmployee().getType()+
//                                                    "'}");
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().write(userJson.toString());
//        } catch(JSONException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        JSONSerializer j = new JSONSerializer();
        return j.include("employee").serialize(user);
    }
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public ModelAndView cancel(@RequestParam String userId,HttpServletResponse response) {
        User user = userService.getUserById(userId);
        try {
            JSONObject userJson = new JSONObject("{'userId':'"+user.getUserId()+
                    "','userName':'"+user.getUserName() +
                    "','employeeName':'"+user.getEmployee().getEmployeeName()+
                    "','gender':'"+user.getEmployee().getGender()+
                    "','email':'"+user.getEmployee().getEmail()+
                    "','introduction':'"+user.getEmployee().getIntroduction()+
                    "','userState':'"+user.getEmployee().getState()+
                    "','userType':'"+user.getEmployee().getType()+
                    "'}");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(userJson.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam String userId, String userName, String employeeName, String gender,
                               String userIntroduction, String userEmail,HttpServletResponse response) {

        User user = userService.getUserById(userId);
        Employee employee = userService.getUserById(userId).getEmployee();
        user.setUserName(userName);
        userService.updateUser(user);
        employee.setEmployeeName(employeeName);
        employee.setGender(gender);
        employee.setEmail(userEmail);
        employee.setIntroduction(userIntroduction);
        employeeService.updateEmployee(employee);

        try {
            JSONObject userJson = new JSONObject("{'userId':'"+user.getUserId()+
                    "','userName':'"+user.getUserName() +
                    "','employeeName':'"+employee.getEmployeeName()+
                    "','gender':'"+employee.getGender()+
                    "','email':'"+employee.getEmail()+
                    "','introduction':'"+employee.getIntroduction()+
                    "','userState':'"+employee.getState()+
                    "','userType':'"+employee.getType()+
                    "'}");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(userJson.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;

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
