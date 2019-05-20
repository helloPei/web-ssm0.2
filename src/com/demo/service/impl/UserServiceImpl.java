package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.entity.User;
import com.demo.service.UserService;
/**
 * 	业务层接口实现类
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findAllUser() {
		List<User> userList = userDao.findAllUser();
		return userList;
	}

	@Override
	public int saveUser(User user, Integer[] roleIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Integer[] ids, String userName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user, String userName) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}