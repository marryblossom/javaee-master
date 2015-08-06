package com.tw.core.service.employeeService.employeeServiceImpl;

import com.tw.core.bean.Employee;
import com.tw.core.service.employeeService.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
//@WebAppConfiguration
@Transactional
//@TransactionConfiguration(defaultRollback = false)
public class EmployeeServiceImplTest {
    @Autowired
    private EmployeeService employeeService;
    Employee employee;

    @Before
    public void setUp() throws Exception {
         employee = new Employee("2", "female", "123@123.com", "this is a employee", "active", "coach", "Json");
    }

    @Test
    public void testInsertEmployee() throws Exception {
        employeeService.insertEmployee(employee);
    }

    @Test
    public void testGetEmployees() throws Exception {
        assertNotNull(employeeService.getEmployees());
    }

    @Test
    public void testGetEmployeeById() throws Exception {
        assertNotNull(employeeService.getEmployeeById("1"));
    }

    @Test
    public void testGetEmployeesOnlyActive() throws Exception {
        assertNotNull(employeeService.getEmployeesOnlyActive());
    }

//        @Test
////    @Rollback
//    public void testDelelteEmployee() throws Exception {
//        employeeService.delelteEmployee("1");
//    }
//    @Test
//    public void testUpdateEmployee() throws Exception {
//        employee.setGender("male");
//        employeeService.updateEmployee(employee);
////        assertEquals("male", employeeService.getEmployeeById("1").getGender());
//
//    }
//
//    @Test
//    public void testChangeEmployeeState() throws Exception {
//        employeeService.changeEmployeeState(employee);
//        assertEquals("locked", employeeService.getEmployeeById("1").getState());
//    }
//

}