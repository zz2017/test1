package com.sxe.sunspace.service.impl;

import com.sxe.sunspace.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    Student findByName(String name);

    List<Student> queryStudentAll();

    String deleteByName(String name);

    Student selectById(Integer id);

//    String deleteById
}
