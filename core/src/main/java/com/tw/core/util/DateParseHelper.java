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
}
