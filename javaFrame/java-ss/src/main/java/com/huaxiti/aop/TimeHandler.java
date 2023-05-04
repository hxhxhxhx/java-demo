package com.huaxiti.aop;

import com.huaxiti.service.impl.WebServiceImpl;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("TimeHandler")
public class TimeHandler implements InvocationHandler {
      
    // 目标对象  
    private WebServiceImpl targetObject;
    
    public TimeHandler(WebServiceImpl targetObject){
          this.targetObject = targetObject;
    }
    @Override  
    //关联的这个实现类的方法被调用时将被执行  
    /*InvocationHandler接口的方法，proxy表示代理，method表示原对象被调用的方法，      
        args表示方法的参数*/  
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret=null;  
        try{  
            System.out.println("方法之前："+System.currentTimeMillis());    
            //调用目标方法  
            ret=method.invoke(targetObject, args);  
            System.out.println("方法之后："+System.currentTimeMillis());  
        }catch(Exception e){  
            e.printStackTrace();  
            System.out.println("error");  
            throw e;  
        }  
        return ret;  
    }  
  
} 