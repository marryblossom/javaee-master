package com.tw.core.controller.userController;

import com.tw.core.bean.User;
import com.tw.core.UserLoginService;
import com.tw.core.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
                              HttpServletRequest request)
            throws NoSuchAlgorithmException {
        user = userLoginService.getUserByNameAndPassword(name, MD5Util.GetMD5Code(password));
        HttpSession session = request.getSession();
        if (user != null){
            session.setAttribute("userLogin", "true");
            System.out.println(session.getAttribute("prePage").toString());
            return new ModelAndView("redirect:/" + getPreUrl(session.getAttribute("prePage").toString()));
        }else {
            return new ModelAndView("redirect:/userLogin/goToLogin");
        }
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("userLogin");
        return new ModelAndView("login");
    }

    private String getPreUrl(String preUrl){
        String defaultUrl = "userOperate/";
        if(preUrl.equals("")){
            preUrl = defaultUrl;
        }
        return preUrl;


    }
}
