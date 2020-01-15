package com.fh.controller;

import com.fh.bean.VipBean;
import com.fh.service.LoginService;
import com.fh.utils.response.ResponseServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Lenovo
 * @title: LoginController
 * @projectName service_arer_api
 * @description: TODO
 * @date 2020/1/1516:19
 */
@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {

    @Resource
    private LoginService loginService;
    /**
     * 登录
     * @return
     */
    @RequestMapping("login")
    public ResponseServer login(VipBean vipBean){
        ResponseServer responseServer = loginService.login(vipBean);
        return  responseServer;
    }


    /**
     * 验证
     * @return
     */
    @RequestMapping("queryLogin")
    public ResponseServer queryLogin(HttpServletRequest request){
        VipBean vipBean = (VipBean) request.getAttribute("vipBean");
        return ResponseServer.success(vipBean);
    }


    /**
     * 验证手机号是否已经注册
     * @return
     */
    @RequestMapping("queryPhone")
    public ResponseServer queryPhone (VipBean vipBean){
        ResponseServer responseServer = loginService.queryPhone(vipBean);
        return responseServer;
    }

    /**
     * 发送验证码
     * @return
     */
    @RequestMapping("faSongYan")
    public ResponseServer faSongYan(String phone){
        ResponseServer responseServer = loginService.faSongYan(phone);
        return responseServer;
    }


    /**
     * 注册
     * @param vipBean
     * @return
     */
    @RequestMapping("addPhone")
    public ResponseServer addPhone(VipBean vipBean){
        ResponseServer responseServer = loginService.addPhone(vipBean);
        return responseServer;
    }
}
