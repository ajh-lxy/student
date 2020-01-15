package com.fh.bean;

import com.fh.annotation.ExportExcel;
import com.fh.annotation.ExportTitle;

/**
 * @author Lenovo
 * @title: stu
 * @projectName service_arer_api
 * @description: TODO
 * @date 2020/1/1510:02
 */
@ExportTitle(title = "t_stu")
public class stu {
    @ExportExcel(name = "id")
    private Integer id;
    @ExportExcel(name = "name")
    private String name;
    @ExportExcel(name = "sex")
    private Integer sex;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
