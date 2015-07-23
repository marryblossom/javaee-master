package com.tw.core.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Created by marry on 7/20/15.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();
    session.setAttribute("prePage","");
    if (request.getRequestURI().toString().contains("userLogin")){
        return true;
    }

    if (session.getAttribute("userLogin") != null){

        return true;
    }else {
        session.setAttribute("prePage",request.getRequestURI().substring(5));
    }
    response.sendRedirect("/web/userLogin/goToLogin");
    return false;
}

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
