package com.sxe.sunspace.controller;


import com.alibaba.fastjson.JSON;
import com.sxe.sunspace.model.Student;
import com.sxe.sunspace.service.impl.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/user")
public class StudentController {
//    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "selectAllStudent", method = RequestMethod.GET)
    @ResponseBody
    public String selectAllStudent(){
        List<Student> studentList = studentService.queryStudentAll();
        log.info("全部内容:{}", JSON.toJSONString(studentList));
        return JSON.toJSONString(studentList);
    }

    @RequestMapping(value = "saveStudent", method = RequestMethod.GET)
    @ResponseBody
    public String saveStudent(){
        Student student = new Student("小豆芽", 18, "豆芽君");
        //根据名字去重
        Student stu = studentService.findByName(student.getStuName());
        Student s = new Student();
        if(stu == null){
            s = studentService.saveStudent(student);
            if(s != null)
                return "增加成功";
            return "增加失败";
        }
        return "名称不能重复";
    }

    @RequestMapping(value = "updateStudent", method = RequestMethod.GET)
    @ResponseBody
    public String updateStudent(){
        Student student = new Student(1,"小豆芽", 18, "豆芽君");
        //根据名字去重
        Student stu = studentService.selectById(student.getId());
        Student s = new Student();
        if(stu != null && stu.getDeleted() == 0){
            if(stu.getStuName().equals(student.getStuName())){
                return "名称不能重复";
            }
            s = studentService.saveStudent(student);
            if(s != null)
                return "修改成功";
            return "修改失败";
        }
        return "要修改的数据不存在";
    }

    @RequestMapping(value = "selectById", method = RequestMethod.GET)
    @ResponseBody
    public String selectById(){
        Student student = studentService.selectById(1);
        log.info("id为1：{}", JSON.toJSONString(student));
        return JSON.toJSONString(student);
    }

    @RequestMapping(value = "deleteByName", method = RequestMethod.GET)
    @ResponseBody
    public String deleteByName(){
        String result = studentService.deleteByName("小豆芽");
        return result;
    }
}
