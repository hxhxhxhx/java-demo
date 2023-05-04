package com.huaxiti.service.impl;

import com.huaxiti.dao.WebDao;
import com.huaxiti.entity.Student;
import com.huaxiti.entity.Teacher;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.huaxiti.service.WebService;
import com.huaxiti.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service
public class WebServiceImpl implements WebService {
    @Autowired
    private WebDao webDao;

    @Override
    public void insertStudent(String name) {
        ParamCheckUtil.paramIfEmpty(name,"name不能为空！");
        webDao.insertStudent(name);
    }

    @Override
    public void deleteStudentById(String id) {
        verifyId(id);
        webDao.deleteStudentById(id);
    }

    private void verifyId(String id) {
        ParamCheckUtil.paramIfEmpty(id,"id不能为空！");
        Student studentById = webDao.findStudentById(id);
        ParamCheckUtil.paramIfEmpty(studentById,"数据不存在！");
    }

    @Override
    public void updateStudentById(String id, String name) {
        ParamCheckUtil.paramIfEmpty(name,"name不能为空！");
        verifyId(id);
        webDao.updateStudentById(id,name);
    }

    @Override
    public Student findStudentById(String id) {
        ParamCheckUtil.paramIfEmpty(id, "id不能为空！");
        return webDao.findStudentById(id);
    }

    @Override
    public void insertTeacher(String name) {
        ParamCheckUtil.paramIfEmpty(name,"name不能为空！");
        webDao.insertTeacher(name);
    }

    @Override
    public void deleteTeacherById(String id) {
        verifyId(id);
        webDao.deleteTeacherById(id);
    }

    @Override
    public void updateTeacherById(String id, String name) {
        ParamCheckUtil.paramIfEmpty(name,"name不能为空！");
        verifyId(id);
        webDao.updateTeacherById(id, name);
    }

    @Override
    public Teacher findTeacherById(String id) {
        ParamCheckUtil.paramIfEmpty(id,"id不能为空！");
        return webDao.findTeacherById(id);
    }

    @Override
    public void testAOP() {
        System.out.println("-------------AOP-----------");
    }

}
