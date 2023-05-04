package com.huaxiti.aop;

import com.huaxiti.service.impl.WebServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("TimeInterceptor")
public class TimeInterceptor implements MethodInterceptor {
    private WebServiceImpl target;
    public TimeInterceptor(WebServiceImpl target) {

        this.target = target;
    }
    @Override
    public Object intercept(Object proxy, Method method,
                            Object[] args, MethodProxy invocation) throws Throwable {
        System.out.println("方法之前："+System.currentTimeMillis());
        Object ret = invocation.invoke(target, args);
        System.out.println("方法之后："+System.currentTimeMillis());

        return ret;
    }
}
