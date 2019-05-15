package com.demo.dao;

import com.demo.entity.User;

public interface UserDao {
	 /**
	  * 基于用户名获取用户对象
	  * @param username
	  * @return
	  */
	 User findUserByUserName(String username);
}
