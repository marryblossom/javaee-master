package com.tw.core.service.employeeService;

import com.tw.core.bean.Employee;
import com.tw.core.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marry on 7/16/15.
 */
public interface EmployeeService {
    public void insertEmployee(Employee employee);
    public void delelteEmployee(String id);
    public List<Employee> getEmployees();
    public Employee getEmployeeById(String id);
    public void updateEmployee(Employee employee);
    public void changeEmployeeState(Employee employee);
}
