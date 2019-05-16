package com.demo.common.util;

import org.apache.shiro.SecurityUtils;

import com.demo.entity.User;
/**
 * Shiro框架工具类
 * @author Administrator
 *
 */
public class ShiroUtils {
	/**
	 * 当前可访问用户
	 * @return
	 */
	public static User getPrincipal() {
		return (User) SecurityUtils.getSubject().getPrincipal();
	}
}
