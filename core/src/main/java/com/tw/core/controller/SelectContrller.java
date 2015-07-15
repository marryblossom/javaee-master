package com.tw.core.controller;

import com.tw.core.bean.Person;
import com.tw.core.service.HelloSelectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marry on 7/13/15.
 */
@Controller
//@RequestMapping("/bbtForum.do")//让 SelectContrller 处理所有包含 /bbtForum.do 的 URL 请求
public class SelectContrller {

    Map<String,Object> data = new HashMap<String,Object>();
    @RequestMapping("/")
    public ModelAndView indexPage(){
        return helloWorld();
    }

    @RequestMapping("/hello")
    //@RequestMapping(params = "method=helloWorld")
    //@RequestMapping(params = "method=helloWorld",method = RequestMethod.POST)   //它可以让 Controller 方法处理特定 HTTP 请求方式的请求，
                                //这样前端的请求方式必须写为/hello?method=helloWorld    。。。如果方法需要获取参数则请求方式后面加上：例&data=33，
                                //这样Spring 不但让 helloWorld() 方法处理这个请求，而且还将data 请求参数在类型转换后绑定到 helloWorld() 方法的data 入参上。
    public ModelAndView helloWorld() {
        HelloSelectService selectService = new HelloSelectService();
        List<Person> people = selectService.getPeople();
        data.put("people", people);
        return new ModelAndView("index", data);

    }
}
