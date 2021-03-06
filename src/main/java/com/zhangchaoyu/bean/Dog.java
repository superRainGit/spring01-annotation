package com.zhangchaoyu.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Dog {

	public Dog() {
		System.out.println("Dog constructor...");
	}
	
	/**
	 * 对象创建并且赋值之后调用
	 */
	@PostConstruct
	public void init() {
		System.out.println("Dog init...");
	} 
	
	/**
	 * 容器移除对象之前
	 */
	@PreDestroy
	public void destory() {
		System.out.println("Dog destory...");
	} 
}
