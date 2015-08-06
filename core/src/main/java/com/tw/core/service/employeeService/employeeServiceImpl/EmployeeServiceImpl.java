package com.tw.core.service.employeeService.employeeServiceImpl;

import com.tw.core.bean.Employee;
import com.tw.core.DAO.impl.BaseServiceImpl;
import com.tw.core.service.employeeService.EmployeeService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by marry on 7/16/15.
 */
@Service
@Transactional
public class EmployeeServiceImpl extends BaseServiceImpl implements EmployeeService {
    private final static Logger logger = Logger.getLogger(EmployeeServiceImpl.class.getName());
    @Override
    public void insertEmployee(Employee employee) {
        logger.info(employee.getEmloyeeId());
        save(employee);
    }

    @Override
    public void delelteEmployee(String id) {
        this.deleteById(Employee.class, id);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = this.queryAll(Employee.class);
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        Employee employee = findById(Employee.class, id);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {

        this.update(employee);
    }
    @Override
    public void changeEmployeeState(Employee employee){
        employee.setState("locked");
        updateEmployee(employee);
    }

    @Override
    public List<Employee> getEmployeesOnlyActive() {
        DetachedCriteria dCriteria = DetachedCriteria.forClass(Employee.class);
        dCriteria.add(Restrictions.eq("state", "active"));
        dCriteria.add(Restrictions.eq("type", "coach"));
        List<Employee> employees =  queryAllOfCondition(Employee.class, dCriteria);
        return employees;
    }

    public static void main(String[] args){
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        service.getEmployeesOnlyActive();
    }
}
