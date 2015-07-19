package com.tw.core.util;

import java.util.logging.Logger;

/**
 * Created by marry on 7/19/15.
 */
public class StringSplitHelper {
    private static Logger logger = Logger.getLogger("StringSplitHelper");
    public static String[] splitStringWithMark(String str, String mark){
        logger.info("this is str and mark======="+str);
        String[] strs = str.split("\\"+mark);
        logger.info("this is str and mark======="+strs.length);
        String[] asReturn ;
        if (strs[0].equals("")){
            asReturn = new String[strs.length-1];
            for (int i=1;i<strs.length;i++){
                asReturn[i-1] = strs[i];
            }
            return asReturn;
        }else {
            return strs;
        }

    }
}
