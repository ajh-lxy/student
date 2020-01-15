package com.fh.controller;

import com.fh.bean.AreaBean;
import com.fh.service.AreaService;
import com.fh.util.response.ResponseServer;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Lenovo
 * @title: AreaController
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1415:58
 */
@RestController
@RequestMapping("/areas")
@CrossOrigin
public class AreaController {
    private static Logger log = Logger.getLogger(AreaController.class);
    @Resource
    private AreaService areaService;

    /**
     * 查询ztree
     * @return
     */
    @RequestMapping(value = "queryArea")
    public List<Map<String,Object>> queryArea() {
        List<Map<String, Object>> maps = areaService.queryArea();
        return maps;
    }
    /**
     * 添加地区
     * @return
     */
    @RequestMapping("addArea")
    public ResponseServer addArea(AreaBean areaBean){
        ResponseServer responseServer = areaService.addArea(areaBean);
        log.info("添加地区信息："+areaBean.getaName());
        return responseServer;
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("deleteArea")
    public ResponseServer deleteArea(String ids){
        ResponseServer responseServer = areaService.deleteArea(ids);
        log.info("删除地区信息id为："+ids);
        return responseServer;
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping("updateArea")
    public ResponseServer updateArea(AreaBean areaBean){
        ResponseServer responseServer = areaService.updateArea(areaBean);
        log.info("修改地区信息："+areaBean.getaName());
        return responseServer;
    }

    /**
     * 导出地区
     */
    @RequestMapping("derive")
    public void derive(String ids, HttpServletResponse response){
        areaService.derive(ids,response);
    }
}
