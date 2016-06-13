package com.unionpay.platform.service;

import com.unionpay.platform.entity.PageBean;
import com.unionpay.platform.entity.Student;
import com.unionpay.platform.mapper.FindAllStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/8.
 */
@Service
public class FindAllStudentService {

    @Autowired
    FindAllStudentMapper findAllStudentMapper;

    public List<Student> FindAll(PageBean pagebean) {

        return findAllStudentMapper.findAll(pagebean.getStart(),pagebean.getRows());
    }
    public int CountAll(){
        return findAllStudentMapper.countAll();
    }
}
