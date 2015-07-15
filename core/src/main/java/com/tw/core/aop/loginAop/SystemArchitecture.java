package com.tw.core.aop.loginAop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by marry on 7/14/15.
 */
@Aspect
public class SystemArchitecture {
    /**
     * A Join Point is defined in the action layer where the method needs
     * a permission check.
     */
   // @Pointcut("@annotation(com.tw.core.aop.loginAop.UserAccessAnnotation)")
    @Pointcut("execution(* com.tw.core.aop.loginAop.aspectNeed.*(..))")
    public void userAccess() {}
}
