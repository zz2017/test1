package com.sxe.sunspace;

import com.sxe.sunspace.service.impl.StudentService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//SpringJUnit支持，由此引入Spring-Test框架支持
@RunWith(SpringJUnit4ClassRunner.class)
//运行application文件
@SpringBootTest(classes = SunSpaceApplication.class)
public class Test {
    @Resource
    private StudentService studentService;

    @org.junit.Test
    public void test() throws Exception{
//        Student student = studentService.findByName("小豆芽");
        Assert.assertEquals("豆芽君", studentService.findByName("小豆芽").getStuNickName());
    }
}
