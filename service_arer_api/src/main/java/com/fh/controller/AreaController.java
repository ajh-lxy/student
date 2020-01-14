package com.fh.controller;

import com.fh.service.AreaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @Resource
    private AreaService areaService;
}
