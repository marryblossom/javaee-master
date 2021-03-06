package com.tw.core.util;

import com.tw.core.bean.Person;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by marry on 7/13/15.
 */
public class CookiesHelper {
    public static HttpServletResponse setCookies(Person person,HttpServletResponse response,HttpServletRequest request){
        Cookie cookieId = new Cookie("personid",person.getId());
        cookieId.setMaxAge(365 * 24 * 3600);
        response.addCookie(cookieId);
        return response;

    }

    public static void deleteCookies(HttpServletRequest request,HttpServletResponse response,String personIdInCookie){
        Cookie[] cookies = request.getCookies();
        try {
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equalsIgnoreCase("personid") ) {
                        cookies[i].setValue(null);
                        cookies[i].setMaxAge(0);
                        response.addCookie(cookies[i]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean hasCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i <cookies.length ; i++) {
                if (cookies[i].getName().equals("personid")){
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public static String getCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i <cookies.length ; i++) {
                if (cookies[i].getName().equals("persnid")){
                    return cookies[i].getValue();
                }
            }
            return "";
        } else {
            return "";
        }
    }
    public static String getCurrentUrlCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i <cookies.length ; i++) {
                if (cookies[i].getName().equals("currentUrl")){
                    String url = cookies[i].getValue();
                    return manageUrl(url);
                }
            }
            return "";
        } else {
            return "";
        }
    }
    public static HttpServletResponse setUrlCookies(HttpServletResponse response,HttpServletRequest request,String needStr,String id){
        Cookie cookie = new Cookie("currentUrl",request.getRequestURL().toString()+needStr+id);
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i <cookies.length ; i++) {
                if (cookies[i].getName().equals("currentUrl")){
                    cookies[i].setValue(request.getRequestURL().toString()+needStr+id);
                }else {
                    cookie.setMaxAge(365 * 24 * 3600);
                    response.addCookie(cookie);
                }
            }

        }
        return response;

    }
    public static String manageUrl(String url){
       return url.substring(url.lastIndexOf("/")+1);
    }

    public static void main(String[] args){
       CookiesHelper helper = new CookiesHelper();
//        HttpServletResponse response = new HttpServletResponse();
        System.out.println(helper.manageUrl("http://localhost:8080/web/goToUpdate"));

    }


}
