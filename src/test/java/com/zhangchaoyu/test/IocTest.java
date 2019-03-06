package com.zhangchaoyu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhangchaoyu.bean.Person;
import com.zhangchaoyu.config.MainConfig;
import com.zhangchaoyu.config.MyConfiguration2;

@SuppressWarnings("resource")
public class IocTest {
	
	@Test
	public void testImport() {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration2.class);
		this.printBeanDefination(context);
	}

	@Test
	public void test03() {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration2.class);
		String[] beanNames = context.getBeanNamesForType(Person.class);
		for (String name : beanNames) {
			System.out.println(name);
		}
	} 
	
	@Test
	public void test02() {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration2.class);
		String[] beanNames = context.getBeanDefinitionNames();
		for (String name : beanNames) {
			System.out.println(name);
		}
		Object bean = context.getBean("person");
		Object bean2 = context.getBean("person");
		System.out.println(bean == bean2);
	} 

	@Test
	public void test01() {
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] beanNames = context.getBeanDefinitionNames();
		for (String name : beanNames) {
			System.out.println(name);
		}
	} 
	
	private void printBeanDefination(ApplicationContext context) {
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
}
