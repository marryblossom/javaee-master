package com.tw.core.controller.customerController;

import com.tw.core.bean.Customer;
import com.tw.core.bean.Schema;
import com.tw.core.service.customerService.CustomerService;
import com.tw.core.service.schemaService.SchemaService;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by marry on 7/21/15.
 */
@RestController
@RequestMapping("/customerOperate")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SchemaService schemaService;
    Map<String,Object> data = new HashMap<String,Object>();
    JSONSerializer j = new JSONSerializer();
    @RequestMapping(value = "/customerShow",method = RequestMethod.GET)
    public @ResponseBody String customerShow() {
        List<Customer> customers = customerService.getCustomers();
        return j.serialize(customers);
    }
    @RequestMapping(value = "/addCustomer",method = RequestMethod.POST)
    public void addCustomer(@RequestParam String customerName,String introduction) {
        System.out.println("customer~~~"+customerName+"  "+introduction);
        UUID uuId = new UUID(6, 6);
        Customer customer = new Customer(uuId.randomUUID().toString(),customerName,"","active","",introduction);
        customerService.insertCustomer(customer);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable String customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        customer.setState("locked");
        List<Schema> schemas = schemaService.getSchemasByCustomer(customer);
        schemaService.deleteAllSchemas(schemas);
        customerService.updateCustomer(customer);
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
    @RequestMapping(value = "/unlockCustomer/{customerId}", method = RequestMethod.GET)
    public void unlock(@PathVariable String customerId){
        Customer customer = customerService.getCustomerById(customerId);
        customer.setState("active");
        customerService.updateCustomer(customer);
    }

}
