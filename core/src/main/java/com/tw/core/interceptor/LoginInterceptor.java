package com.tw.core.interceptor;

import com.tw.core.util.CookiesHelper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by marry on 7/20/15.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
//    private static Logger logger = Logger.getLogger("LoginInterceptor");
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    String isLogin = "";

    if (request.getRequestURI().equals("/web/userLogin/goToLogin")) return true;

    Cookie[] cookies = request.getCookies();




    for(Cookie cookie: cookies){
        if(cookie.getName().equals("loginUserId")){
            isLogin = cookie.getValue();
        }
    }

    if(isLogin.equals("true")){
        Cookie cookie = new Cookie("prevPage", null);
        cookie.setPath("/");
        response.addCookie(cookie);
        return true;
    }else {
        Cookie cookie = new Cookie("prevPage", request.getRequestURI().substring(5));
        cookie.setPath("/");
        response.addCookie(cookie);
        response.sendRedirect("/web/userLogin/goToLogin");
        return false;
//            Cookie cookie = new Cookie("prevPage", null);
//            cookie.setMaxAge(0);
//            cookie.setPath("/");
//            response.addCookie(cookie);
//            return true;
    }

//        if (session.getAttribute("isLogin") == null) {
//            throw new AuthorizationException();
//        } else {
//            return true;
//        }
}

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
