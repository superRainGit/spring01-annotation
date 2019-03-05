package com.zhangchaoyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.zhangchaoyu.bean.Person;

// 配置类==配置文件
@Configuration // 告诉spring这是一个配置类
@ComponentScans(value = {
		@ComponentScan(value = "com.zhangchaoyu", includeFilters = {
				@Filter(type = FilterType.CUSTOM, classes = {SelfTypeFilter.class})
		}, useDefaultFilters = false)
})
public class MainConfig {

	// 给容器中注册一个bean 类型为返回值的类型 使用方法名作为唯一标识
	@Bean("person")
	public Person person01() {
		return new Person("lisi", 20);
	}
}
