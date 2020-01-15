package com.fh.mapper;

import com.fh.bean.VipBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Lenovo
 * @title: LoginMapper
 * @projectName service_arer_api
 * @description: TODO
 * @date 2020/1/1516:21
 */
@Repository
@Mapper
public interface LoginMapper {
    /**
     * 根据手机号查询用户信息
     * @param vipBean
     * @return
     */
    VipBean queryPhone(VipBean vipBean);

    /**
     *
     * @param vipBean
     */
    void addVipBean(VipBean vipBean);
}
