package com.zhangchaoyu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhangchaoyu.bean.Boss;
import com.zhangchaoyu.bean.Car;
import com.zhangchaoyu.bean.Cat;
import com.zhangchaoyu.config.MainConfigurarionOfAutowired;
import com.zhangchaoyu.dao.BookDao;
import com.zhangchaoyu.service.BookService;

public class IocAutowired {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigurarionOfAutowired.class);
		BookService bookService = context.getBean(BookService.class);
		System.out.println(bookService);
		BookDao bookDao = context.getBean(BookDao.class);
		System.out.println(bookDao);
		Boss boss = context.getBean(Boss.class);
		System.out.println(boss);
		Car car = context.getBean(Car.class);
		System.out.println(car);
		Cat cat = context.getBean(Cat.class);
		System.out.println(cat);
		context.close();
	}
}
