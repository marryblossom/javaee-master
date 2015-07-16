package com.tw.core.testController.userTestController;

import com.tw.core.bean.Course;
import com.tw.core.bean.Employee;
import com.tw.core.bean.User;
import com.tw.core.service.courseService.CoourseServiceImpl.CourseServiceImpl;
import com.tw.core.service.courseService.CourseService;
import com.tw.core.service.employeeService.EmployeeService;
import com.tw.core.service.employeeService.employeeServiceImpl.EmployeeServiceImpl;
import com.tw.core.service.userService.UserService;
import com.tw.core.service.userService.userServiceImpl.UserServiceImpl;
import com.tw.core.util.MD5Util;
import java.util.UUID;

/**
 * Created by marry on 7/16/15.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:User.bean.xml"})
public class UserServiceTest {
   // @Autowired
   //ApplicationContext ctx;
    static UserService userService = new UserServiceImpl();
    static EmployeeService employeeService = new EmployeeServiceImpl();
    static CourseService courseService = new CourseServiceImpl();
   // @Test
//    public static void addUserTest() {
//        //User user =(User) ctx.getBean("user");
//       // System.out.print(user.getUserName());
//        Employee employee = new Employee();
//        UUID uuid1 = new UUID(6, 6);
//        employee.setEmloyeeId(uuid1.randomUUID().toString());
//        employee.setEmail("1233@111.com");
//        System.out.println("employee id ======="+employee.getEmloyeeId());
//        employeeService.insertEmployee(employee);
//
//
//        User user = new User();
//        UUID uuid = new UUID(6,6);
//        user.setUserId(uuid.randomUUID().toString());
//        user.setPassword(MD5Util.GetMD5Code("123"));
//        user.setEmployee(employee);
//        user.setState("active");
//        user.setUserName("xiaoming");
//        userService.insertUser(user);
//
//
//    }
//    public static void deleteUserAndEmployeeTest(){
//        userService.delelteUser("085c8db5-cfcb-4165-b32d-426ae1f2c161");
//        employeeService.delelteEmployee("7b3961eb-af38-46c2-a7bb-9387bcba609b");
//
//    }
//    public static void selectUserAndEmpoyeeTest(){
//        System.out.println(userService.getUserById("9bbd8a42-6609-4eb6-bd2e-3ef030d6a53e").getUserName());
//        System.out.println(employeeService.getEmployeeById("5ab0bb1d-3afb-4633-89fa-a2f2f185c457").getEmail());
//        System.out.println(userService.getUsers().size());
//        System.out.println(employeeService.getEmployees().size());
//
//    }
//    public static void updateUserAndEmpoyeeTest(){
//        User user = userService.getUserById("9bbd8a42-6609-4eb6-bd2e-3ef030d6a53e");
//        user.setUserName("小明");
//        userService.updateUser(user);
//
//        Employee employee = employeeService.getEmployeeById("5ab0bb1d-3afb-4633-89fa-a2f2f185c457");
//        employee.setEmployeeName("emploeeName");
//        employeeService.updateEmployee(employee);
//
//    }
//    public static void addCourseTest() {
//        //User user =(User) ctx.getBean("user");
//        // System.out.print(user.getUserName());
//        Course course = new Course();
//        UUID uuid1 = new UUID(6, 6);
//        course.setCourseId(uuid1.randomUUID().toString());
//        course.setName("语文");
//        courseService.insertCourse(course);
////
////
//    }
    public static void main(String[] args){
//        updateUserAndEmpoyeeTest();
   }
}
