package com.unionpay.platform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.unionpay.platform.entity.PageBean;
import com.unionpay.platform.service.FindAllStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/8.
 */
@RestController
@RequestMapping({"/main"})
public class StudentController {

    @Autowired
    private FindAllStudentService findAllStudentService;

    @RequestMapping(value = {"/showstudents"}, method = {RequestMethod.GET})
    public ModelAndView show() {
        ModelAndView mv = new ModelAndView("student/show");
        return mv;
    }

    @RequestMapping(value = {"/userList"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> banksenderList(HttpServletRequest request) {
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<>();
        JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(findAllStudentService.FindAll(pageBean)));
        map.put("rows", jsonArray);
        map.put("total", findAllStudentService.CountAll());
        return map;
    }


}
