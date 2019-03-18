package com.zhangchaoyu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SelfBeanPostProcessor implements BeanPostProcessor {

	/**
	 * 对象在创建之后 初始化之前调用的方法
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization --> " + bean);
		return bean;
	}

	/**
	 * 对象在创建之后 初始化之后调用的方法
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization --> " + bean);
		return bean;
	}

}
