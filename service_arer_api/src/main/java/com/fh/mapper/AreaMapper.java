package com.fh.mapper;

import com.fh.bean.AreaBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lenovo
 * @title: AreaMapper
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1415:59
 */
@Repository
@Mapper
public interface AreaMapper {
    /**
     * 查询地区
     * @return
     * @param
     */
    List<AreaBean> queryArea();

    /**
     * 添加地区
     * @param areaBean
     */
    void addArea(AreaBean areaBean);

    /**
     * 删除地区
     * @param ids
     */
    void deleteArea(String ids);

    /**
     * 修改地区
     * @param areaBean
     */
    void updateArea(AreaBean areaBean);


    List<AreaBean> queryAreaList(List array);
}
