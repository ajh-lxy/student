package com.fh.service.impl;

import com.fh.mapper.AreaMapper;
import com.fh.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 * @title: AreaServiceImpl
 * @projectName service_student_web
 * @description: TODO
 * @date 2020/1/1416:00
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
}
