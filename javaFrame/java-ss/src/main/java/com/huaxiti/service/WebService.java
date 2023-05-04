package com.huaxiti.service;

import com.huaxiti.entity.Student;
import com.huaxiti.entity.Teacher;

public interface WebService {

    void insertStudent(String name);

    void deleteStudentById(String id);

    void updateStudentById(String id, String name);

    Student findStudentById(String id);

    void insertTeacher(String name);

    void deleteTeacherById(String id);

    void updateTeacherById(String id, String name);

    Teacher findTeacherById(String id);

    void testAOP();
}
