package com.huaxiti.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {

    @Before("execution(* com.huaxiti.aop.aspect.*.*(..))")
    public void before(){
        System.out.println("代码前置增强...");
    }
}
