package com.tw.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by marry on 7/19/15.
 */
public class DateParseHelper {
    private static SimpleDateFormat sdf=new SimpleDateFormat();
    private static String defaultPattern="yyyy-MM-dd";

    public static Date parseDate(String dateStr,String pattern){
        sdf.applyPattern(pattern);
        try {
            Date date=sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDate(String dateStr){
        sdf.applyPattern(defaultPattern);
        try {
            Date date=sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Date datePasrser(String dateString){
        sdf.applyPattern(defaultPattern);
        String[] dates = dateString.split("\\ ");
        String da = getMonth(dates[0]);
        da = dates[2]+"-"+da+"-"+dates[1].substring(0,dates[1].indexOf(","));
        System.out.println(da);
        try {
            Date date=sdf.parse(da);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args){
        System.out.print(datePasrser("July 1, 2015"));
    }

    public static String getMonth(String month){
        String monthNumber = "";
        switch (month){
            case "January":
                monthNumber = "01";
                break;
            case "February":
                monthNumber = "02";
                break;
            case "March":
                monthNumber = "03";
                break;
            case "April":
                monthNumber = "04";
                break;
            case "May":
                monthNumber = "05";
                break;
            case "June":
                monthNumber = "06";
                break;
            case "July":
                monthNumber = "07";
                break;
            case "August":
                monthNumber = "08";
                break;
            case "September":
                monthNumber = "09";
                break;
            case "October":
                monthNumber = "10";
                break;
            case "November":
                monthNumber = "11";
                break;
            case "December":
                monthNumber = "12";
                break;
        }
        return monthNumber;
    }
}
