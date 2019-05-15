package com.demo.service.impl;

import com.demo.dao.PaperDao;
import com.demo.entity.User;
import com.demo.service.PaperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaperServiceImpl implements PaperService {
	@Autowired
    private PaperDao paperDao;//持有一个持久层对象
	
    public User findAllById(int id) {
        return paperDao.findAllById(id);
    }
}