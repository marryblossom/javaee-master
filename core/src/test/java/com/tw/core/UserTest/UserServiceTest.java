package com.tw.core.UserTest;

import com.tw.core.bean.Employee;
import com.tw.core.bean.User;
import com.tw.core.service.employeeService.EmployeeService;
import com.tw.core.service.employeeService.employeeServiceImpl.EmployeeServiceImpl;
import com.tw.core.service.userService.UserService;
import com.tw.core.service.userService.userServiceImpl.UserServiceImpl;
import com.tw.core.util.MD5Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by marry on 7/16/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:hibernate.cfg.xml"})
//@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
public class UserServiceTest {
    private static Logger logger = Logger.getLogger("userServiceTest");
//    @Autowired
    private UserService userService = new UserServiceImpl();
//    @Autowired
    private EmployeeService employeeService  = new EmployeeServiceImpl();

    @Before
    public void setUp() throws Exception {
        logger.info("thi sis set up");

    }

    @Test
    public void testInsertUser() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/tw/beanXml/User.bean.xml");
        User user = applicationContext.getBean("user", User.class);
        logger.info(user.getUserName());
        Employee employee = applicationContext.getBean("employee",Employee.class);

        UUID uuid1 = new UUID(6, 6);
        employee.setEmloyeeId(uuid1.randomUUID().toString());
        employeeService.insertEmployee(employee);

        UUID uuid = new UUID(6,6);
        user.setUserId(uuid.randomUUID().toString());
        user.setPassword(MD5Util.GetMD5Code("123"));
        user.setEmployee(employee);
        userService.insertUser(user);

    }

    @Test
    public void testDelelteUser() throws Exception {

    }

    @Test
    public void testGetUsers() throws Exception {

    }

    @Rollback
    @Test
    public void testGetUserById() throws Exception {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/tw/beanXml/User.bean.xml");
        User user = userService.getUserById("7da60f98-1c8c-4a65-8f98-31b07ee1791e");
//        assertEquals("小明",user.getUserName());
//        logger.info(user.getEmployee().getEmloyeeId());
    }

    @Test
    public void testUpdateUser() throws Exception {

    }





//    public void setAnnotationTest(AnnotationTest annotationTest) {
//        this.annotationTest = annotationTest;
//    }
    // @Autowired
   //ApplicationContext ctx;
//
  //  static CourseService courseService = new CourseServiceImpl();


//   // @Test
//    public static void addUserTest() {
//
//
//
//    }
//    public static void deleteUserAndEmployeeTest(){
//        userService.delelteUser("9bbd8a42-6609-4eb6-bd2e-3ef030d6a53e");
//        employeeService.delelteEmployee("5ab0bb1d-3afb-4633-89fa-a2f2f185c457");
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

}
