package com.tw.core.util;

import com.tw.core.bean.Person;

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
      //  cookieId.setPath("/");
        response.addCookie(cookieId);
        System.out.println("add length=======" + request.getCookies().length);
        System.out.println("add=======" + request.getCookies()[0].getName());
        return response;

    }

    public static void deleteCookies(HttpServletRequest request,HttpServletResponse response,String personIdInCookie){
        Cookie[] cookies = request.getCookies();
        try {
            if (cookies != null) {
                System.out.println("==================" + cookies.length);
                System.out.println("==================" + cookies[0].getName());
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equalsIgnoreCase("personid") ) {
                        cookies[i].setValue(null);
                      //  cookies[i].setPath("/");
                        cookies[i].setMaxAge(0);
                        response.addCookie(cookies[i]);
                    }
                }
            }
            System.out.println("=11=================" + cookies.length);
            System.out.println("==11================" + cookies[0].getName());
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

    public static void main(String[] args){
//        CookiesHelper helper = new CookiesHelper();
//        HttpServletResponse response = new HttpServletResponse();

    }
}
