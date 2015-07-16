package com.tw.core.service.employeeService.employeeServiceImpl;

import com.tw.core.bean.Employee;
import com.tw.core.bean.User;
import com.tw.core.service.baseService.impl.BaseServiceImpl;
import com.tw.core.service.employeeService.EmployeeService;

import java.util.List;

/**
 * Created by marry on 7/16/15.
 */
public class EmployeeServiceImpl extends BaseServiceImpl implements EmployeeService {
    @Override
    public void insertEmployee(Employee employee) {
        this.save(employee);
    }

    @Override
    public void delelteEmployee(String id) {
        this.deleteById(Employee.class,id);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = this.queryAll(Employee.class);
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        Employee employee = findById(Employee.class,id);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        this.update(employee);
    }
}
