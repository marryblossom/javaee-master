package com.tw.core.controller.customerController;

import com.tw.core.bean.Customer;
import com.tw.core.bean.Schema;
import com.tw.core.service.customerService.CustomerService;
import com.tw.core.service.schemaService.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by marry on 7/21/15.
 */
@Controller
@RequestMapping("/customerOperate")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SchemaService schemaService;
    Map<String,Object> data = new HashMap<String,Object>();
    @RequestMapping("/customerShow")
    public ModelAndView customerShow() {
        List<Customer> customers = customerService.getCustomers();
        data.put("customers", customers);
        return new ModelAndView("customer", data);

    }
    @RequestMapping("/addCustomer")
    public ModelAndView addCustomer(@RequestParam("name")String customerName,
                                  @RequestParam("introduction")String introduction) {
        UUID customerId = new UUID(6, 6);
        Customer customer = new Customer();
        customer.setCustomerId(customerId.randomUUID().toString());
        customer.setIntroduction(introduction);
        customer.setName(customerName);
        customer.setState("active");
        customerService.insertCustomer(customer);
        return new ModelAndView("redirect:/customerOperate/customerShow");
    }

    @RequestMapping("/deleteCustomer")
    public ModelAndView deleteCustomer(@RequestParam("customerId")String customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        customer.setState("block");
        List<Schema> schemas = schemaService.getSchemasByCustomer(customer);
        schemaService.deleteAllSchemas(schemas);
        customerService.updateCustomer(customer);
        return new ModelAndView("redirect:/customerOperate/customerShow");
    }
    @RequestMapping("/updateCustomer")
    public ModelAndView updateCustomer(@RequestParam("customerId")String customerId,
                               @RequestParam("name")String name,
                               @RequestParam("introduction")String introduction) {
        Customer customer = customerService.getCustomerById(customerId);
        customer.setName(name);
        customer.setIntroduction(introduction);
        customerService.updateCustomer(customer);
        return new ModelAndView("redirect:/customerOperate/customerShow");
    }
    @RequestMapping("/goToCustomerUpdate")
    public ModelAndView goToCustomerUpdate(@RequestParam("customerId")String customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        data.put("customer", customer);
        return new ModelAndView("customerUpdate", data);
    }

}
