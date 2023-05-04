package com.huaxiti.controller;

import com.huaxiti.entity.Student;
import com.huaxiti.entity.Teacher;
import com.huaxiti.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/web")
public class webController {

    @Autowired
    private WebService webService;

    @PostMapping("/insertStudent")
    public void insertStudent(@RequestParam("name") String name){
        webService.insertStudent(name);
    }

    @PostMapping("/deleteStudentById")
    public void deleteStudentById(@RequestParam("id") String id){
        webService.deleteStudentById(id);
    }

    @PostMapping("/updateStudentById")
    public void updateStudentById(@RequestParam("id") String id, @RequestParam("name") String name){
        webService.updateStudentById(id,name);
    }

    @PostMapping("/findStudentById")
    public void findStudentById(@RequestParam("id") String id){
        Student studentById = webService.findStudentById(id);
    }

    @PostMapping("/insertTeacher")
    public void insertTeacher(@RequestParam("name") String name){
        webService.insertTeacher(name);
    }

    @PostMapping("/deleteTeacherById")
    public void deleteTeacherById(@RequestParam("id") String id){
        webService.deleteTeacherById(id);
    }

    @PostMapping("/updateTeacherById")
    public void updateTeacherById(@RequestParam("id") String id, @RequestParam("name") String name){
        webService.updateTeacherById(id,name);
    }

    @PostMapping("/findTeacherById")
    public void findTeacherById(@RequestParam("id") String id){
        Teacher TeacherById = webService.findTeacherById(id);
    }
}
