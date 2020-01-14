package com.fh.bean;

/**
 * @author Lenovo
 * @title: AreaBean
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1415:56
 */

public class AreaBean {
    private Integer aid;//主键id
    private Integer pid;//父id
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
