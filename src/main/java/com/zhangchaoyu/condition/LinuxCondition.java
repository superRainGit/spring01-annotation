package com.zhangchaoyu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

@SuppressWarnings("unused")
public class LinuxCondition implements Condition {

	/**
	 * 用于与 @conditional 注解配合使用的条件类
	 * ConditionContext: 用于判断条件的上下文环境
	 * AnnotatedTypeMetadata: 元数据
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 可以获取到bean的工厂
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		// 可以获取到运行的环境信息
		Environment environment = context.getEnvironment();
		// 可以获取到类加载器信息
		ClassLoader classLoader = context.getClassLoader();
		// 可以获取到bean注册中心
		BeanDefinitionRegistry registry = context.getRegistry();
		String property = environment.getProperty("os.name");
		return property.contains("linux");
	}

}
