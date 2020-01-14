package com.fh.service.impl;

import com.fh.annotation.ExportExcel;
import com.fh.bean.StudentBean;
import com.fh.mapper.StudentMapper;
import com.fh.service.StudentService;
import com.fh.utils.page.PageBean;
import com.fh.utils.poi.PoiUtils;
import com.fh.utils.response.ResponseServer;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /**
     * 导出
     * @param response
     */
    @Override
    public void xiaStuList(HttpServletResponse response) {
        //导出逻辑
        Map map = new HashMap();
        List<StudentBean> userList= studentMapper.queryStuList(map);
        PoiUtils.excelUtil(userList,response);
    }
}
