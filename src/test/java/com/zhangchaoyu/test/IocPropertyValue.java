package com.zhangchaoyu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhangchaoyu.bean.Person;
import com.zhangchaoyu.config.ConfigurationProertyValue;

public class IocPropertyValue {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationProertyValue.class);

	@Test
	public void test() {
		printBeanDefination(context);
		Person person = context.getBean(Person.class);
		System.out.println(person);
		context.close();
	}
	
	private void printBeanDefination(ApplicationContext context) {
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
}
