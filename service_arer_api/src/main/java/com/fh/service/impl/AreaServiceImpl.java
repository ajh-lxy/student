package com.fh.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.bean.AreaBean;
import com.fh.mapper.AreaMapper;
import com.fh.service.AreaService;
import com.fh.util.poi.PoiUtils;
import com.fh.util.redis.RedisPools;
import com.fh.util.response.ResponseServer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lenovo
 * @title: AreaServiceImpl
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1416:00
 */
@Service
public class AreaServiceImpl implements AreaService {
    private static Logger log = Logger.getLogger(AreaServiceImpl.class);
    @Autowired
    private AreaMapper areaMapper;

    /**
     * 查询地区
     * @return
     */
    @Override
    public List<Map<String, Object>> queryArea() {
        Jedis jeDis = RedisPools.getJeDis();
        String listStu = jeDis.get("rightList");
        if(listStu==null){
            List<AreaBean> rightList = areaMapper.queryArea();
            String s = JSONObject.toJSONString(rightList);
            jeDis.set("rightList", s);
            return getQueryList(0,rightList);
        }else {
            List<AreaBean> areaBeanList = JSONArray.parseArray(listStu, AreaBean.class);
            return getQueryList(0, areaBeanList);
        }
    }

    /**
     * 添加地区
     * @param areaBean
     * @return
     */
    @Override
    public ResponseServer addArea(AreaBean areaBean) {
        Jedis jeDis = RedisPools.getJeDis();
        areaMapper.addArea(areaBean);
        jeDis.del("rightList");
        return ResponseServer.success();
    }

    /**
     * 删除地区
     * @param ids
     * @return
     */
    @Override
    public ResponseServer deleteArea(String ids) {
        Jedis jeDis = RedisPools.getJeDis();
        areaMapper.deleteArea(ids);
        jeDis.del("rightList");
        return ResponseServer.success();
    }

    /**
     * 修改地区
     * @param areaBean
     * @return
     */
    @Override
    public ResponseServer updateArea(AreaBean areaBean) {
        Jedis jeDis = RedisPools.getJeDis();
        areaMapper.updateArea(areaBean);
        jeDis.del("rightList");
        return ResponseServer.success();
    }

    /**
     * 导出地区
     * @param ids
     * @param response
     */
    @Override
    public void derive(String ids, HttpServletResponse response) {
        if (ids!=null && !ids.equals("")){
            //定义idlist
            List<Integer> list = new ArrayList<Integer>();
            String[] split = ids.split(",");
            for (int i = 0; i < split.length; i++) {
                if(!split[i].equals("")){
                    String s = split[i];
                    list.add(Integer.valueOf(s.trim()));
                }
            }
            //有条件
            List<AreaBean> rightList = areaMapper.queryAreaList(list);
            log.info(JSONObject.toJSONString(rightList));
            PoiUtils.excelUtil(rightList, response);
        }else {
            //无条件
            List<AreaBean> rightList = areaMapper.queryArea();
            log.info(JSONObject.toJSONString(rightList));
            PoiUtils.excelUtil(rightList, response);
        }

    }

    //递归找节点
    private List<Map<String,Object>> getQueryList(Integer pid,List<AreaBean> rightList){
        List<Map<String,Object>>  list=new ArrayList<Map<String, Object>>();
        rightList.forEach(areaBean -> {
            Map<String,Object> map=null;
            if(pid.equals(areaBean.getPid())){
                map =new HashMap<String, Object>();
                map.put("id",areaBean.getAid());
                map.put("name", areaBean.getaName());
                if(0 ==  areaBean.getPid()){
                    map.put("iconOpen","/commons/orgimg/1_open.png");
                    map.put("iconClose","/commons/orgimg/organ.png");
                }else {
                    map.put("icon","/commons/orgimg/dept2.png");
                }
                map.put("children", getQueryList(areaBean.getAid(), rightList));
            }
            if(map != null){
                list.add(map);
            }

        });
        return list;
    }
}
