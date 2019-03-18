package com.zhangchaoyu.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhangchaoyu.bean.DataSource;
import com.zhangchaoyu.config.MainConfigurationOfProfile;

public class IocProfile {

	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigurationOfProfile.class);
		Map<String, DataSource> beansOfType = context.getBeansOfType(DataSource.class);
		beansOfType.forEach((k, v) -> {
			System.out.println(k);
		} );
		context.close();
	} 
	
	@Test
	public void test2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.register(MainConfigurationOfProfile.class);
		context.refresh();
		Map<String, DataSource> beansOfType = context.getBeansOfType(DataSource.class);
		beansOfType.forEach((k, v) -> {
			System.out.println(k);
		} );
		context.close();
	}
}
