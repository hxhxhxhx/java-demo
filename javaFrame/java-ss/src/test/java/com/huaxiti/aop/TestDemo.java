package com.huaxiti.aop;

import com.huaxiti.aop.aspect.TargetInterFace;
//import com.huaxiti.cofig.SpringBootConfig;
import com.huaxiti.service.impl.WebServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = SpringBootConfig.class)
public class TestDemo {

    @Test
    public void test1() {
        WebServiceImpl webService = new WebServiceImpl();
        TimeHandler timeHandler = new TimeHandler(webService);
        Proxy.newProxyInstance(webService.getClass().getClassLoader(), webService.getClass().getInterfaces(),timeHandler);
        webService.testAOP();

        TimeInterceptor timeInterceptor = new TimeInterceptor(webService);
        Enhancer.create(webService.getClass(),timeInterceptor);
        webService.testAOP();
    }
//    @Autowired
//    private TargetInterFace target;
//    @Test
//    public void testAspect(){
//        target.method();
//    }
}
