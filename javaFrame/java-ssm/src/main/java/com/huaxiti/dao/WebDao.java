package com.huaxiti.dao;

import com.huaxiti.entity.Student;
import com.huaxiti.entity.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
public interface WebDao {

    @Insert("insert into Student('name') values(?)")
    void insertStudent(String name);

    @Delete("delete from Student where id = ?")
    void deleteStudentById(String id);

    @Update("update table Student name = ? where id = ?")
    void updateStudentById(String id, String name);

    @Select({"select * from Student where id = ?"})
    Student findStudentById(String id);

    void insertTeacher(String name);

    void deleteTeacherById(String id);

    void updateTeacherById(String id, String name);

    Teacher findTeacherById(String id);


}
