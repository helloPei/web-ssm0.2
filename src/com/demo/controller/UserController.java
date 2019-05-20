package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.common.util.ShiroUtils;
import com.demo.common.vo.JsonResult;
import com.demo.entity.User;
import com.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 用户页面
	 * @return
	 */
    @RequestMapping("doUserListUI")
	public String doUserListUI(){
		return "system/user_list";
	}
    /**
     * 添加用户页面
     * @return
     */
    @RequestMapping("doUserEditUI")
    public String doUserEditUI(){
 	   return "sys/user_edit";
    }
    /**
     * 保存添加用户（及用户权限）
     * @param user
     * @param roleIds 权限ID
     * @return
     */
    @RequestMapping("doSaveUser")
	@ResponseBody
	public JsonResult doSaveUser(User user, Integer[] roleIds) {
		User userShiro = ShiroUtils.getPrincipal();
		//添加创建用户
		user.setCreatedUser(userShiro.getUsername());
		userService.saveUser(user, roleIds);
		return new JsonResult("save ok");
	}
    /**
     * 删除用户 （改变用户状态，及录入操作用户）
     * @param id
     * @return
     */
    @RequestMapping("doDeleteUser")
	@ResponseBody
	public JsonResult doSaveObject(Integer[] ids) {
		User userShiro = ShiroUtils.getPrincipal();
		//根据ID改变用户状态，录入操作用户名
		userService.deleteUser(ids, userShiro.getUsername());
		return new JsonResult("delete ok");
	}
    /**
     * 修改用户 （及录入操作用户）
     * @param user
     * @return
     */
    @RequestMapping("doUpdateUser")
	@ResponseBody
	public JsonResult doUpdateUser(User user) {
    	User userShiro = ShiroUtils.getPrincipal();
    	//修改用户，录入操作用户名
		userService.updateUser(user, userShiro.getUsername());
		return new JsonResult("update ok");
	}
    /**
     * 页面显示所有用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("doFindAllUser")
	@ResponseBody
	public JsonResult doFindAllUser() {
    	//PageHelper页面框架，pageNum页面数、pageSize页面大小
    	PageHelper.startPage(50, 10);
		List<User> userList = userService.findAllUser();
		PageInfo<User> pageInfo = new PageInfo<User>(userList);
    	//数据返回视图层
		return new JsonResult(pageInfo);
	}
}