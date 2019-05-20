package com.demo.dao;

import java.util.List;

import com.demo.entity.User;

public interface UserDao {
	
	public List<User> findAllUser();
	 /**
	  * 基于用户名获取用户对象
	  * @param username
	  * @return
	  */
	 public User findUserByUserName(String username);
}
