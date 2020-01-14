package com.fh.bean;

import com.fh.annotation.ExportExcel;
import com.fh.annotation.ExportTitle;

/**
 * @author Lenovo
 * @title: AreaBean
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1415:56
 */
@ExportTitle(title = "地区信息")
public class AreaBean {
    @ExportExcel(name = "aid")
    private Integer aid;//主键id
    @ExportExcel(name = "pid")
    private Integer pid;//父id
    @ExportExcel(name = "地区名字")
    private String aName;//地区名字


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }
}
