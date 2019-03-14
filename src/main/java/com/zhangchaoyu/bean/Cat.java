package com.zhangchaoyu.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component
@Setter
@ToString
public class Cat implements InitializingBean, DisposableBean {
	
	private Car car;
	
	public Cat() {
		System.out.println("Cat constructor...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("cat destory...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("cat afterPropertiesSet...");
	}

}
