package com.sxe.sunspace.dao;

import com.sxe.sunspace.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{
    //继承Jpa和Curd的方法
    /**
     * 保存
     * @param student
     * @return
     */
    Student save(Student student);

    /**
     * 根据名字查找
     * @param name
     * @return
     */
    Student findByStuName(String name);

    /**
     * 根据deleted来查询所有的学生
     * @param deleted
     * @return
     */
    Student findByDeleted(Integer deleted);

    @Override
    void delete(Integer integer);

    @Override
    List<Student> findAll();

    @Override
    Student findOne(Integer integer);

    @Override
    long count();

    @Override
    Page<Student> findAll(Pageable pageable);
//    int page = 1,size = 10;
//    Sort sort = new Sort(Sort.Direction.ASC, "id");
//    Pageable pageable = new PageRequest(page, size, sort);




    @Override
    boolean exists(Integer integer);

    /**
     * 删除，当要写sql语句时，需要加上@Modifying这个注解才能解析sql语句并执行
     * @param name
     * @return
     */
    @Query(value = "delete from Student s where s.stuName = :name")
    @Modifying
    @Transactional
    Integer deleteByStuName(@Param(value = "name") String name);

//    @Query(value = " update Student s set where s.id = :id")
//    @Modifying
//    @Transactional
//    Integer deleteById(@Param("id") Integer id);


}
