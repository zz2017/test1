package com.sxe.sunspace.service.impl;

import com.sxe.sunspace.dao.StudentDao;
import com.sxe.sunspace.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> queryStudentAll() {
        return studentDao.findAll();
    }

    @Override
    public String deleteByName(String name) {
        int id = studentDao.deleteByStuName(name);
        String result = "删除失败";
        if(id > 0){
            result = "删除成功";
        }
        return result;
    }

    @Override
    public Student selectById(Integer id) {
        return studentDao.getOne(id);
    }

    @Override
    public Student saveStudent(Student student) {
        Student s = studentDao.save(student);
        return s;
    }

    @Override
    public Student findByName(String name) {
        return studentDao.findByStuName(name);
    }

}
