package com.fh.service.impl;

import com.fh.annotation.ExportExcel;
import com.fh.bean.StudentBean;
import com.fh.mapper.StudentMapper;
import com.fh.service.StudentService;
import com.fh.utils.page.PageBean;
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

        try {
            //创建一个实体bean
            StudentBean  user=new StudentBean();
            //获取所有的属性数组
            Field[] fields = user.getClass().getDeclaredFields();
            List<String>  fieldNameList=new ArrayList<>();
            for (int i = 0; i <fields.length ; i++) {
                if(fields[i].isAnnotationPresent(ExportExcel.class)){
                    System.out.println(fields[i].getName());
                    fieldNameList.add(fields[i].getName());
                }

            }


            SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
            Map map = new HashMap();

            List<StudentBean> userList= studentMapper.queryStuList(map);

            //将属性list和数据list存入
            List<List> excelList = new ArrayList();
            excelList.add(fieldNameList);
            excelList.add(userList);
            if(excelList.get(0).size()==0){
                System.out.println("sss");
            }
            XSSFWorkbook xwb = new XSSFWorkbook();
            XSSFSheet sheet = xwb.createSheet();
            //表头
            XSSFRow row=sheet.createRow(0) ;
            //将要导出的字段属性名设置为头标题
            String [] rowArr = new String[fields.length];

            //拿出第一个
            for (int i = 0; i <fieldNameList.size() ; i++) {
                String name = fieldNameList.get(i);
                rowArr[i]=name;
                XSSFCell cell = row.createCell(i);
                cell.setCellValue(fieldNameList.get(i));
            }

            for (int i = 0; i < userList.size(); i++) {

                XSSFRow row1=sheet.createRow(i+1) ;


                //每个字段放入一个单元格
                XSSFCell cell = row1.createCell(0);

                cell.setCellValue(i);

                XSSFCell cell1 = row1.createCell(1);
                String username = userList.get(i).getStuName();
                cell1.setCellValue(username);

                XSSFCell cell2 = row1.createCell(2);
                String realName = userList.get(i).getAge().toString();
                cell2.setCellValue(realName);

                XSSFCell cell4 = row1.createCell(3);
                if (userList.get(i).getBirthday() != null) {
                    String birthday = sim.format(userList.get(i).getBirthday());
                    cell4.setCellValue(birthday);
                } else {
                    cell4.setCellValue("");
                }

            }
            // CellRangeAddress region = new CellRangeAddress(1, 1, 0, 11);
            //sheet.addMergedRegion(region);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/octet-stream");

            //String  name="type.xlsx";
            response.addHeader("Content-Disposition", "attachment; filename=\"" + UUID.randomUUID().toString() + "\".xlsx");
            ServletOutputStream outputStream = response.getOutputStream();
            xwb.write(outputStream);
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
