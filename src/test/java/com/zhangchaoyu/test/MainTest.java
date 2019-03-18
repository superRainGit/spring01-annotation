package com.zhangchaoyu.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhangchaoyu.bean.Person;
import com.zhangchaoyu.config.MainConfig;

public class MainTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		Person person = (Person) context.getBean("person");
//		System.out.println(person);
//		context.close();
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = context.getBean(Person.class);
		System.out.println(person);
		String[] nameForType = context.getBeanNamesForType(Person.class);
		for(String name : nameForType) {
			System.out.println(name);
		}
	}
}
