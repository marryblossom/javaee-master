package com.tw.core.service.customerService;

import com.tw.core.bean.Customer;
import java.util.List;

/**
 * Created by marry on 7/16/15.
 */
public interface CustomerService {
    public void insertCustomer(Customer customer);
    public void delelteCustomer(String id);
    public List<Customer> getCustomers();
    public Customer getCustomerById(String id);
    public void updateCustomer(Customer customer);
}
