package com.tw.core.controller.schemaController;

import com.tw.core.bean.Employee;
import com.tw.core.bean.Schema;
import com.tw.core.bean.User;
import com.tw.core.service.schemaService.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marry on 7/19/15.
 */
@Controller
@RequestMapping("/schemaOperate")
public class SchemaController {
    @Autowired
   private SchemaService schemaService;
    Map<String,Object> data = new HashMap<String,Object>();
    @RequestMapping(value = "/schemaShow", method= RequestMethod.GET)
    public ModelAndView schemaShow() {
        List<Schema> schemas = schemaService.getSchemas();
        data.put("schemas", schemas);
        return new ModelAndView("schema", data);
    }
    @RequestMapping(value = "/deleteSchema",method = RequestMethod.POST)
    // @UserAccessAnnotation(isLogin= ISLOGIN.YES)
    public ModelAndView deleteSchema(@RequestParam("schemaId")String schemaId,@CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
//        if (!(userIdInCookie.equals(""))){
        schemaService.delelteSchema(schemaId);
        return new ModelAndView("redirect:/schemaOperate/schemaShow");
//        }else {
//            return new ModelAndView("login");
//        }
    }
    @RequestMapping("/goToSchemaUpdate")
    public ModelAndView goToSchemaUpdate(@RequestParam("schemaId")String schemaId,
                                         @RequestParam("date") String date,
                                         @CookieValue(value="loginId", defaultValue="") String userIdInCookie) {
//        if (!(userIdInCookie.equals(""))){
        Schema schema = schemaService.getSchemaById(schemaId);
       // schema.setDate(date);
        return new ModelAndView("userUpdate", data);
//        }
//        else {
//            return new ModelAndView("login");
//        }
    }
}
