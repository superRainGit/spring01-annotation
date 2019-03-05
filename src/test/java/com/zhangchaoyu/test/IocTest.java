package com.zhangchaoyu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhangchaoyu.config.MainConfig;

@SuppressWarnings("resource")
public class IocTest {

	@Test
	public void test01() {
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] beanNames = context.getBeanDefinitionNames();
		for (String name : beanNames) {
			System.out.println(name);
		}
	} 
}
