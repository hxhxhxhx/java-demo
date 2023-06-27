package com.huaxiti;

import com.huaxiti.controller.StudentController;
import com.huaxiti.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class testStudent {

    @Resource
    private StudentController studentController;

    @Test
    public void testAdd(){
//        Student student = new Student();
//        student.setName("zhangsan");
//        student.setAddr("hangzhou");
//        student.setClazz("computer");
//        student.setPhone("666666");
//        studentController.add(student);
    }
}
