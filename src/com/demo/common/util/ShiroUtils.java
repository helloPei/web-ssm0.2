package com.demo.common.util;

import org.apache.shiro.SecurityUtils;

import com.demo.entity.User;

public class ShiroUtils {

	 public static User getPrincipal(){
		 return (User)SecurityUtils.getSubject().getPrincipal();
	 }
}
