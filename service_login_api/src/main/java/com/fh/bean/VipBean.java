package com.fh.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Lenovo
 * @title: VipBean
 * @projectName shop_admin_web
 * @description: TODO
 * @date 2019/12/1921:24
 */
public class VipBean implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String phone;
    private Date createDate;
    private Integer isLock;
    private String code;


    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
