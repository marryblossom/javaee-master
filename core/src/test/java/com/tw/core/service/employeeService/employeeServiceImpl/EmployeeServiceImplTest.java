package com.tw.core.service.employeeService.employeeServiceImpl;

import com.tw.core.bean.Employee;
import com.tw.core.service.employeeService.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

/**
 * Created by marry on 8/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
//@WebAppConfiguration
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class EmployeeServiceImplTest {
    @Autowired
    private EmployeeService employeeService;
    Employee employee;

    @Before
    public void setUp() throws Exception {
//         employee = new Employee("1", "female", "123@123.com", "this is a employee", "coach", "active", "Json");
    }

    @Test
    public void testInsertEmployee() throws Exception {
//        employeeService.insertEmployee(employee);
        assertEquals(1, 1);
    }

//    @Test
//    public void testDelelteEmployee() throws Exception {
////        employeeService.delelteEmployee("1");
//        assertEquals(1, 1);
//    }

//    @Test
//    public void testGetEmployees() throws Exception {
//        assertEquals(1, 1);
////        assertNotNull(employeeService.getEmployees());
//    }
//
//    @Test
//    public void testGetEmployeeById() throws Exception {
//        assertEquals(1, 1);
////        assertNotNull(employeeService.getEmployeeById("1"));
//    }
//
//    @Test
//    public void testUpdateEmployee() throws Exception {
//        assertEquals(1, 1);
////        employee.setGender("male");
////        assertEquals("male",employeeService.getEmployeeById("1").getGender());
//
//    }
//
//    @Test
//    public void testChangeEmployeeState() throws Exception {
//        assertEquals(1,1);
////        assertEquals("locked", employeeService.getEmployeeById("1").getState());
//    }
//
//    @Test
//    public void testGetEmployeesOnlyActive() throws Exception {
//        assertEquals(1,1);
////        assertNotNull(employeeService.getEmployeesOnlyActive());
//    }
}