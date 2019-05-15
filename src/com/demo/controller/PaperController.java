package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.User;
import com.demo.service.PaperService;
@Controller
@RequestMapping("/paper")
public class PaperController {
	@Autowired
    private PaperService paperService;//持有一个业务层对象
	//ajax查询数据
    @RequestMapping("/findAllById")
    @ResponseBody
    public User findAllById(@RequestParam("pId")int id) {
        return paperService.findAllById(id);
    }
}