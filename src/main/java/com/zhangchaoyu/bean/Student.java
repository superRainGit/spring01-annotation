package com.zhangchaoyu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
@SuppressWarnings({"unused"})
public class Student extends Person implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
	
	private ApplicationContext applicationContext;

	@Override
	public void setBeanName(String name) {
		System.out.println("Bean name is " + name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("Inject application context : " + applicationContext);
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		String resolveStringValue = resolver.resolveStringValue("Hello ioc i am ${os.name} and i am #{18 * 20} year old");
		System.out.println("resolce value " + resolveStringValue);
	}

}
