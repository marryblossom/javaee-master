package com.tw.core.aop.loginAop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by marry on 7/14/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UserAccessAnnotation {
        /**
         * User has been login or not.
         *
         */
        ISLOGIN isLogin();
}
