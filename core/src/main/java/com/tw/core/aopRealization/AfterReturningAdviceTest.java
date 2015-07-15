package com.tw.core.aopRealization;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by marry on 7/15/15.
 */
@Aspect
public class AfterReturningAdviceTest {
    // 匹配 org.crazyit.app.service.impl 包下所有类的、
    // 所有方法的执行作为切入点
    @AfterReturning(returning="rvt",
            pointcut="execution(* com.tw.core.aopRealization.*.*(..))")
    public void log(Object rvt)
    {
        System.out.println("获取目标方法返回值 :" + rvt);
        System.out.println("模拟记录日志功能 ...");
    }
}
