package com.zhangchaoyu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.zhangchaoyu.bean.DataSource;

/**
 * 
 * Profile
 * 	Spring提供的可以根据当前的环境，动态的激活和切换一系列组件的功能
 *  	使用@Profile注解默认的可注入的bean的方式是default
 *  	如何指定Profile呢?
 *  	1: 	在启动时通过指定启动参数 -Dspring.profiles.active=test/dev/pro
 *  	2:	在ioc容器启动前指定启动的配置环境
 *  	该注解还可以配置在配置类上，表明如果环境符合时才会将该配置类加载
 *  	如果配置类中的bean没有使用@Profile注解修饰 那么在任何环境下都会加载这个bean
 */
@Configuration
@PropertySource("classpath:/database.properties")
public class MainConfigurationOfProfile implements EmbeddedValueResolverAware {

	@Value("${db.name}")
	private String name;
	
	private String url;
	
	@Profile("test")
	@Bean
	public DataSource testDataSource(@Value("${db.pwd}") String pwd) {
		return new DataSource(name, pwd, url);
	}
	
	@Profile("dev")
	@Bean
	public DataSource devDataSource(@Value("${db.pwd}") String pwd) {
		return new DataSource(name, pwd, url);
	}

	@Profile("pro")
	@Bean
	public DataSource proDataSource(@Value("${db.pwd}") String pwd) {
		return new DataSource(name, pwd, url);
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.url = resolver.resolveStringValue("${db.url}");
	}
}
