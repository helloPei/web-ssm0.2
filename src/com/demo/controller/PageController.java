package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class PageController {
	/**
	 * 	问卷页面
	 * @return
	 */
	@RequestMapping("doPaperUI")
	public String doPagerUI(){
		return "paper";
	}
	/**
	 * 	登录页面
	 * @return
	 */
	@RequestMapping("doLoginUI")
	public String doLoginUI(){
		return "login";
	}
	/**
	 * 	主页
	 * @return
	 */
	@RequestMapping("doIndexUI")
	public String doIndexUI(){
		return "index";
	}
	/**
	 * 页面分页
	 * @return
	 */
//	@RequestMapping("doPageUI")
//	public String doPageUI(){
//		return "common/page";
//	}
}