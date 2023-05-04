package com.huaxiti.aop.aspect;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterFace{
    @Override
    public void method() {
        System.out.println("Target running ...");
    }
}
