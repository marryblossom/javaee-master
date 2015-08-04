package com.tw.core.service.customerService.customerServiceImpl;

import com.tw.core.bean.Customer;
import com.tw.core.DAO.impl.BaseServiceImpl;
import com.tw.core.service.customerService.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by marry on 7/16/15.
 */
@Service
public class CustomerServiceImpl extends BaseServiceImpl implements CustomerService {
    @Override
    public void insertCustomer(Customer customer) {
        save(customer);
    }

    @Override
    public void delelteCustomer(String id) {
        deleteById(Customer.class, id);
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = this.queryAll(Customer.class);
        return customers;
    }

    @Override
    public Customer getCustomerById(String id) {
        Customer customer = findById(Customer.class, id);
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        update(customer);
    }

    @Override
    public List<Customer> getCustomerOnlyActive() {
        DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class);
        dCriteria.add(Restrictions.eq("state", "active"));
        List<Customer> customers =  queryAllOfCondition(Customer.class, dCriteria);
        return customers;
    }


}
