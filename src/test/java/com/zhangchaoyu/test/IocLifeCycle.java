package com.zhangchaoyu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhangchaoyu.config.MyConfiguration3;

public class IocLifeCycle {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration3.class);
		System.out.println("ioc 容器创建完成");
		context.close();
	}
}
