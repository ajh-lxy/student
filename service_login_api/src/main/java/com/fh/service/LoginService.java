package com.fh.service;

import com.fh.bean.VipBean;
import com.fh.utils.response.ResponseServer;

/**
 * @author Lenovo
 * @title: LoginService
 * @projectName service_arer_api
 * @description: TODO
 * @date 2020/1/1516:18
 */
public interface LoginService {
    /**
     * 登录
     * @param vipBean
     * @return
     */
    ResponseServer login(VipBean vipBean);

    /**
     * 验证手机号是否注册
     * @param vipBean
     * @return
     */
    ResponseServer queryPhone(VipBean vipBean);

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    ResponseServer faSongYan(String phone);

    /**
     * 注册
     * @param vipBean
     * @return
     */
    ResponseServer addPhone(VipBean vipBean);
}
