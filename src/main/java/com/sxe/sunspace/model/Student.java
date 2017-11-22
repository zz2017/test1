package com.sxe.sunspace.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "sxe_stu_name")
    private String stuName;

    @Column(name = "sxe_stu_age")
    private Integer stuAge;

    @Column(name = "sxe_stu_nick_name")
    private String stuNickName;

    @Column(name = "sxe_deleted")
    private Integer deleted;

    public Student(){}

    public Student(String stuName, Integer stuAge, String stuNickName) {
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuNickName = stuNickName;
    }

    public Student(Integer id, String stuName, Integer stuAge, String stuNickName) {
        this.id = id;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuNickName = stuNickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuNickName() {
        return stuNickName;
    }

    public void setStuNickName(String stuNickName) {
        this.stuNickName = stuNickName;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
