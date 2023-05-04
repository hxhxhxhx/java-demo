package com.huaxiti.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.huaxiti.aop.aspect.TargetInterFace;
import com.huaxiti.entity.Student;
import com.huaxiti.entity.Teacher;
import com.huaxiti.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/web")
public class webController {

    @Autowired
    private WebService webService;

    @PostMapping("/insertStudent")
    public R insertStudent(String name){
        webService.insertStudent(name);
        return R.ok(Boolean.TRUE);
    }

    @PostMapping("/deleteStudentById")
    public R deleteStudentById(@RequestParam("id") String id){
        webService.deleteStudentById(id);
        return R.ok(Boolean.TRUE);
    }

    @PostMapping("/updateStudentById")
    public R updateStudentById(@RequestParam("id") String id, @RequestParam("name") String name){
        webService.updateStudentById(id,name);
        return R.ok(Boolean.TRUE);
    }

    @PostMapping("/findStudentById")
    public R findStudentById(@RequestParam("id") String id){
        Student studentById = webService.findStudentById(id);
        return R.ok(studentById);
    }

    @PostMapping("/insertTeacher")
    public R insertTeacher(@RequestParam("name") String name){
        webService.insertTeacher(name);
        return R.ok(Boolean.TRUE);
    }

    @PostMapping("/deleteTeacherById")
    public R deleteTeacherById(@RequestParam("id") String id){
        webService.deleteTeacherById(id);
        return R.ok(Boolean.TRUE);
    }

    @PostMapping("/updateTeacherById")
    public R updateTeacherById(@RequestParam("id") String id, @RequestParam("name") String name){
        webService.updateTeacherById(id,name);
        return R.ok(Boolean.TRUE);
    }

    @PostMapping("/findTeacherById")
    public R findTeacherById(@RequestParam("id") String id){
        Teacher TeacherById = webService.findTeacherById(id);
        return R.ok(TeacherById);
    }

    @Autowired
    private TargetInterFace targetInterFace;

    @PostMapping("/test")
    public void testAOP(){
        targetInterFace.method();
    }
}
