package com.fh.controller;

import com.fh.bean.StudentBean;
import com.fh.service.StudentService;
import com.fh.utils.imgUtil.CopyFile;
import com.fh.utils.page.PageBean;
import com.fh.utils.response.ResponseServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lenovo
 * @title: StudentController
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1310:36
 */
@RestController
@RequestMapping("stu")
@CrossOrigin
public class StudentController {
    @Resource
    private StudentService studentService;

    /**
     * 查询学生
     * @param page
     * @param studentBean
     * @return
     */
    @RequestMapping("queryStuList")
    public ResponseServer queryStuList(PageBean<StudentBean> page, StudentBean studentBean){
        ResponseServer responseServer = studentService.queryStuList(page,studentBean);
        return responseServer;
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("addStu")
    public ResponseServer addStu(StudentBean studentBean){
        ResponseServer responseServer = studentService.addStu(studentBean);
        return responseServer;
    }
    /**
     * 修改书籍
     * @return
     */
    @RequestMapping("updateStu")
    public ResponseServer updateStu(StudentBean studentBean){
        ResponseServer responseServer = studentService.updateStu(studentBean);
        return responseServer;
    }

    /**
     * 回显
     * @return
     */
    @RequestMapping("getByIdStuBean")
    public ResponseServer getByIdStuBean(Integer id){
        ResponseServer responseServer = studentService.getByIdStuBean(id);
        return responseServer;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("deleteStu")
    public ResponseServer deleteStu(Integer id){
        ResponseServer responseServer=studentService.deleteStu(id);
        return responseServer;
    }

    //上传图片
    @RequestMapping("fileInput")
    public Map<String, Object> fileinput(@RequestParam("img") MultipartFile photo) {
        String path = CopyFile.copyFile(photo, "upload");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("path", path);
        return map;
    }
}
