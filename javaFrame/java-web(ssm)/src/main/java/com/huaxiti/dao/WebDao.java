package com.huaxiti.dao;

import com.huaxiti.entity.Student;
import com.huaxiti.entity.Teacher;
import org.apache.ibatis.annotations.*;

@Mapper
public interface WebDao {

    @Insert("insert into student(name) values(#{name})")
    void insertStudent(String name);

    @Delete("delete from student where id = #{id}")
    void deleteStudentById(String id);

    @Update("update table student name = #{name} where id = #{id}")
    void updateStudentById(String id, String name);

    @Select({"select * from student where id = #{id}"})
    Student findStudentById(String id);

    void insertTeacher(String name);

    void deleteTeacherById(String id);

    void updateTeacherById(String id, String name);

    Teacher findTeacherById(String id);


}
