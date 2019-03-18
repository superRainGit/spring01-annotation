package com.zhangchaoyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zhangchaoyu.bean.Person;

/**
 * 	使用@PropertySource指定加载配置文件的位置
 */
@PropertySource({"classpath:person.properties"})
@Configuration
public class ConfigurationProertyValue {

	@Bean
	public Person person() {
		return new Person();
	} 
}
