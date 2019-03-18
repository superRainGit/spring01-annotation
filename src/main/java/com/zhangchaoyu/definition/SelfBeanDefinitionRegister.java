package com.zhangchaoyu.definition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.zhangchaoyu.bean.Person;

public class SelfBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata 在类或者方法上的注解的信息
	 * BeanDefinitionRegistry:bean对象的注册器
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean definition = registry.containsBeanDefinition("com.zhangchaoyu.bean.Teacher");
		boolean definition2 = registry.containsBeanDefinition("com.zhangchaoyu.bean.Worker");
		if(definition && definition2) {
			BeanDefinition linuxBeanDefinition = new RootBeanDefinition(Person.class);
			registry.registerBeanDefinition("linux", linuxBeanDefinition);
		}
	}

}
