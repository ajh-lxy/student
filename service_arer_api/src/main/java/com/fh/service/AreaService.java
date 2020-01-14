package com.fh.service;

import com.fh.bean.AreaBean;
import com.fh.util.response.ResponseServer;

import java.util.List;
import java.util.Map;

/**
 * @author Lenovo
 * @title: AreaService
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1416:00
 */
public interface AreaService {
    /**
     * 查询地区功能
     * @return
     */
    List<Map<String,Object>> queryArea();

    /**
     * 添加地区
     * @param areaBean
     * @return
     */
    ResponseServer addArea(AreaBean areaBean);

    /**
     * 删除地区
     * @param ids
     * @return
     */
    ResponseServer deleteArea(String ids);

    /**
     * 修改地区
     * @param areaBean
     * @return
     */
    ResponseServer updateArea(AreaBean areaBean);
}
