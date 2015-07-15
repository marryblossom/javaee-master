package com.tw.core.aop.loginAop;

/**
 * Created by marry on 7/15/15.
 */
public class aspectNeed {

    @UserAccessAnnotation(isLogin= ISLOGIN.YES)
    public void system(){
        System.out.println("this is the method need to add aspect");
    }
}
