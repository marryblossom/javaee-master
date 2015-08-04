package com.tw.core.controller.customerController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.bean.Customer;
import com.tw.core.bean.Schema;
import com.tw.core.service.customerService.CustomerService;
import com.tw.core.service.schemaService.SchemaService;
import com.tw.core.util.HibernateProxyTypeAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    private Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
            .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
            .serializeNulls().setDateFormat("yyyy-MM-dd")//时间转化为特定格式
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
            .setPrettyPrinting() //对json结果格式化.
            .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                    //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
                    //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SchemaService schemaService;
    Map<String,Object> data = new HashMap<String,Object>();
    @RequestMapping(value = "/customerShow",method = RequestMethod.GET)
    public @ResponseBody String customerShow() {
        List<Customer> customers = customerService.getCustomers();
        return gson.toJson(customers);
    }
    @RequestMapping(value = "/addCustomer",method = RequestMethod.POST)
    public void addCustomer(@RequestParam String customerName,String introduction) {
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
//    @RequestMapping("/updateCustomer")
//    public ModelAndView updateCustomer(@RequestParam("customerId")String customerId,
//                               @RequestParam("name")String name,
//                               @RequestParam("introduction")String introduction) {
//        Customer customer = customerService.getCustomerById(customerId);
//        customer.setName(name);
//        customer.setIntroduction(introduction);
//        customerService.updateCustomer(customer);
//        return new ModelAndView("redirect:/customerOperate/customerShow");
//    }
//    @RequestMapping("/goToCustomerUpdate")
//    public ModelAndView goToCustomerUpdate(@RequestParam("customerId")String customerId) {
//        Customer customer = customerService.getCustomerById(customerId);
//        data.put("customer", customer);
//        return new ModelAndView("customerUpdate", data);
//    }
    @RequestMapping(value = "/unlockCustomer/{customerId}", method = RequestMethod.GET)
    public void unlock(@PathVariable String customerId){
        Customer customer = customerService.getCustomerById(customerId);
        customer.setState("active");
        customerService.updateCustomer(customer);
    }

}
