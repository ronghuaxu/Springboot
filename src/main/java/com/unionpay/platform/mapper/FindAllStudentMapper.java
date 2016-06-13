package com.unionpay.platform.mapper;

/**
 * Created by Administrator on 2016/6/8.
 */

import com.unionpay.platform.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedList;
import java.util.List;

public interface FindAllStudentMapper {

    @Select("SELECT * FROM t_student limit #{offset},#{limit}")
    List<Student> findAll(@Param("offset") int offset, @Param("limit") int limit);

    @Select("select count(*) from t_student")
    int countAll();
}
