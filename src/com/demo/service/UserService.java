package com.demo.service;

import java.util.List;

import com.demo.entity.User;
/**
 * 业务层接口
 * @author Administrator
 *
 */
public interface UserService {
	/** 页面显示所有用户 */
	public List<User> findAllUser();
	/** 保存添加用户（及用户权限） */
	public int saveUser(User user, Integer[] roleIds);
	/** 删除用户 （改变用户状态，及录入操作用户） */
	public int deleteUser(Integer[] ids, String userName);
	/** 修改用户 （及录入操作用户） */
	public int updateUser(User user, String userName);
}