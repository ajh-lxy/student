package com.fh.service.impl;

import com.fh.bean.StudentBean;
import com.fh.mapper.StudentMapper;
import com.fh.service.StudentService;
import com.fh.utils.page.PageBean;
import com.fh.utils.response.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lenovo
 * @title: StudentServiceImpl
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1310:37
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询学生
     * @param page
     * @param studentBean
     * @return
     */
    @Override
    public ResponseServer queryStuList(PageBean<StudentBean> page, StudentBean studentBean) {
        //条件
        Map map = new HashMap();
        map.put("page",page);
        List<StudentBean> drugBeanList = studentMapper.queryStuList(map);
        page.setData(drugBeanList);
        page.setRecordsTotal((long) drugBeanList.size());
        return ResponseServer.success(page);
    }

    /**
     * 添加
     * @param studentBean
     * @return
     */
    @Override
    public ResponseServer addStu(StudentBean studentBean) {
        studentMapper.addStu(studentBean);
        return ResponseServer.success();
    }

    /**
     * 修改
     * @param studentBean
     * @return
     */
    @Override
    public ResponseServer updateStu(StudentBean studentBean) {
        studentMapper.updateBook(studentBean);
        return ResponseServer.success();
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @Override
    public ResponseServer getByIdStuBean(Integer id) {
        StudentBean bean = studentMapper.getByIdStuBean(id);
        return ResponseServer.success(bean);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public ResponseServer deleteStu(Integer id) {
        studentMapper.deleteStu(id);
        return ResponseServer.success();
    }
}
