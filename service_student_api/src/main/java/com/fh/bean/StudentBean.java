package com.fh.bean;

import com.fh.annotation.ExportExcel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Lenovo
 * @title: StudentBean
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1310:36
 */
public class StudentBean {
    @ExportExcel
    private Integer id;
    @ExportExcel
    private String stuName;
    @ExportExcel
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ExportExcel
    private Date birthday;
    @ExportExcel
    private String img;
    @ExportExcel
    private Integer isDel;
    @ExportExcel
    private Integer ip;
    @ExportExcel
    private String address;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIp() {
        return ip;
    }

    public void setIp(Integer ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
