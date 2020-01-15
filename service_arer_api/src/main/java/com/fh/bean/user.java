package com.fh.bean;

import com.fh.annotation.ExportExcel;
import com.fh.annotation.ExportTitle;

/**
 * @author Lenovo
 * @title: user
 * @projectName service_arer_api
 * @description: TODO
 * @date 2020/1/159:59
 */
@ExportTitle(title = "t_user")
public class user {
    @ExportExcel(name = "id")
    private Integer id;
    @ExportExcel(name = "name")
    private String name;
    @ExportExcel(name = "age")
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
