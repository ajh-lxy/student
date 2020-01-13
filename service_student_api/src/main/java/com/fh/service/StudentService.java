package com.fh.service;

import com.fh.bean.StudentBean;
import com.fh.utils.page.PageBean;
import com.fh.utils.response.ResponseServer;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Lenovo
 * @title: StudentService
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1310:37
 */
public interface StudentService {
    /**
     * 查询学生
     * @param page
     * @param studentBean
     * @return
     */
    ResponseServer queryStuList(PageBean<StudentBean> page, StudentBean studentBean);

    /**
     * 添加
     * @param studentBean
     * @return
     */
    ResponseServer addStu(StudentBean studentBean);

    /**
     * 修改
     * @param studentBean
     * @return
     */
    ResponseServer updateStu(StudentBean studentBean);

    /**
     * 回现
     * @param id
     * @return
     */
    ResponseServer getByIdStuBean(Integer id);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseServer deleteStu(Integer id);

    /**
     * 导出
     * @param response
     */
    void xiaStuList(HttpServletResponse response);
}
