package com.fh.bean;

import com.fh.annotation.ExportExcel;
import com.fh.annotation.ExportTitle;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Lenovo
 * @title: StudentBean
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1310:36
 */
@ExportTitle(title = "学生表")
public class StudentBean {
    @ExportExcel(name = "学生编号")
    private Integer id;
    @ExportExcel(name = "学生姓名")
    private String stuName;
    @ExportExcel(name = "学生年龄")
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ExportExcel(name = "学生姓名")
    private Date birthday;
    @ExportExcel(name = "学生照片")
    private String img;
    @ExportExcel(name = "是否删除")
    private Integer isDel;
    @ExportExcel(name = "学生ip")
    private Integer ip;
    @ExportExcel(name = "学生地址")
    private String address;

    @ExportExcel(name = "学生学费")
    private BigDecimal price;


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
