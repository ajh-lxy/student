package com.fh.mapper;

import com.fh.bean.StudentBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Lenovo
 * @title: StudentMapper
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1310:36
 */
@Repository
@Mapper
public interface StudentMapper {
    /**
     * 查询学生
     * @param map
     * @return
     */
    List<StudentBean> queryStuList(Map map);

    /**
     * 添加
     * @param studentBean
     */
    void addStu(StudentBean studentBean);

    /**
     * 修改
     * @param studentBean
     */
    void updateBook(StudentBean studentBean);

    /**
     * 回显
     * @param id
     * @return
     */
    StudentBean getByIdStuBean(Integer id);

    /**
     * 删除
     * @param id
     */
    void deleteStu(Integer id);
}
