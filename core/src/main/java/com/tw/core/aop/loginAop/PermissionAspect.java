package com.tw.core.aop.loginAop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by marry on 7/14/15.
 */
@Aspect
public class PermissionAspect {
    //AuthService authService = null;

    @Before(value="com.tw.core.aop.loginAop.SystemArchitecture.userAccess()&&"+
            "@annotation(userAccessAnnotation)",argNames="userAccessAnnotation")

    public void checkPermission(UserAccessAnnotation userAccessAnnotation)
            throws Exception{
     //   System.out.println("======thisis aspect");
        ISLOGIN isLogin = userAccessAnnotation.isLogin ();
        System.out.print("this is permition========"+isLogin.toString());
//        if(!authService.getUser().equals(isLogin.toString())){
//            throw new NoPermissionException();
//        }
    }

}
