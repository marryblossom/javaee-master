package com.tw.core.controller.userController;

import com.tw.core.bean.Employee;
import com.tw.core.bean.Schema;
import com.tw.core.bean.User;
import com.tw.core.org.json.JSONException;
import com.tw.core.org.json.JSONObject;
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

    @RequestMapping("/hello")
    public ModelAndView hello() {
        List<User> users = userService.getUsers();
        data.put("users", users);
        return new ModelAndView("user", data);

    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam String userId,HttpServletResponse response) {
        User user = userService.getUserById(userId);
        Employee employee = user.getEmployee();

        user.setState("locked");
        employee.setState("locked");

        userService.updateUser(user);
        employeeService.updateEmployee(employee);
        List<Schema> schemas = schemaService.getSchemasByEmployee(employee);
        schemaService.deleteAllSchemas(schemas);
        try {
            response.getWriter().write(user.getState().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/addUserAndEmployee")
    public ModelAndView addUserAndEmployee(@RequestParam String username, String employeename, String password,
                                String gender, String introduction, String email) {
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

    @RequestMapping(value = "/goToUpdate", method = RequestMethod.POST)
    public ModelAndView goToUpdate(@RequestParam String userId,HttpServletResponse response) {
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
    @RequestMapping(value = "/unlock", method = RequestMethod.GET)
    public ModelAndView unlock(@RequestParam String userId,HttpServletResponse response){
        User user = userService.getUserById(userId);
        Employee employee = user.getEmployee();
        user.setState("active");
        employee.setState("active");
        userService.updateUser(user);
        employeeService.updateEmployee(employee);
        try {
            response.getWriter().write(user.getState().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
