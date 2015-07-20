package com.tw.core.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by marry on 7/13/15.
 */
public class CookiesHelper {
    public static HttpServletResponse setCookies(String value,HttpServletResponse response,String cookieId){
        Cookie cookie = new Cookie(cookieId,value);
        cookie.setMaxAge(365 * 24 * 3600);
        cookie.setPath("/");
        response.addCookie(cookie);
        return response;
    }

    public static void deleteCookies(HttpServletRequest request,HttpServletResponse response,String cookieId){
        Cookie[] cookies = request.getCookies();
        try {
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equalsIgnoreCase(cookieId) ) {
                        cookies[i].setValue(null);
                        cookies[i].setMaxAge(0);
                        cookies[i].setPath("/");
                        response.addCookie(cookies[i]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean hasCookies(HttpServletRequest request,String cookieId) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i <cookies.length ; i++) {
                if (cookies[i].getName().equals(cookieId)){
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public static String getCookie(HttpServletRequest request,String cookieId){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i <cookies.length ; i++) {
                if (cookies[i].getName().equals(cookieId)){
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
