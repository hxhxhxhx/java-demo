package com.huaxiti.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaxiti.dao.StudentDao;
import com.huaxiti.entity.Student;
import com.huaxiti.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2023-06-26 15:29:51
 */
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

}

