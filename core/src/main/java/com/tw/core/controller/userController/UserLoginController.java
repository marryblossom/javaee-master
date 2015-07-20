package com.tw.core.controller.userController;

import com.tw.core.bean.User;
import com.tw.core.business.userLoginService.HelloLoginService;
import com.tw.core.service.userService.UserLoginService;
import com.tw.core.util.CookiesHelper;
import com.tw.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * Created by marry on 7/13/15.
 */
@Controller
@RequestMapping("/userLogin")
public class UserLoginController {
    private static Logger logger = Logger.getLogger("UserLoginController");
    User user;
    @Autowired
    private UserLoginService userLoginService;
    @RequestMapping("/goToLogin")
    public ModelAndView goToLogin() {
        return new ModelAndView("login");
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username")String name,
                              @RequestParam("password")String password,
                              HttpServletResponse response,@CookieValue(value="prevPage", defaultValue="") String preUrl)
            throws NoSuchAlgorithmException {
        user = userLoginService.getUserByNameAndPassword(name, MD5Util.GetMD5Code(password));
        if (user != null){
                CookiesHelper.setCookies("true",response,"loginUserId");
                logger.info("url====="+getPreUrl(preUrl));
//                return new ModelAndView("redirect:/" + getPreUrl(preUrl));
            return new ModelAndView("redirect:/userOperate/hello");
        }else {
            return new ModelAndView("redirect:/userLogin/goToLogin");
        }
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
        CookiesHelper.deleteCookies(request,response,"loginUserId");
        return new ModelAndView("login");
    }

    private String getPreUrl(String preUrl){
        String defaultUrl = "userOperate/";
        if(!preUrl.equals("")){
            preUrl = defaultUrl;
        }
        return preUrl;


    }
}
