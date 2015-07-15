package com.tw.core.aopRealization;

import org.springframework.stereotype.Component;

/**
 * Created by marry on 7/15/15.
 */
@Component
public class Chinese implements User{
    @Override
    public String sayHello(String name) {
        System.out.println("-- 正在执行 sayHello 方法 --");
        // 返回简单的字符串
        return name + " Hello , Spring AOP";
    }

    @Override
    public void eat(String food) {
        System.out.println("我正在吃 :"+ food);
    }
}
