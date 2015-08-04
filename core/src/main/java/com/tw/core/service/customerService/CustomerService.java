package com.tw.core.service.customerService;

import com.tw.core.DAO.IBaseDao;
import com.tw.core.bean.Customer;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by marry on 7/16/15.
 */
@Service
public interface CustomerService{
    public void insertCustomer(Customer customer);
    public void delelteCustomer(String id);
    public List<Customer> getCustomers();
    public Customer getCustomerById(String id);
    public void updateCustomer(Customer customer);

    public List<Customer> getCustomerOnlyActive();

}
