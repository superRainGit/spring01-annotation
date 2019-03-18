package com.zhangchaoyu.factory;

import org.springframework.beans.factory.FactoryBean;

import com.zhangchaoyu.bean.Person;

public class SelfFactoryBean implements FactoryBean<Person> {

	/**
	 * 该方法用于spring创建bean
	 */
	@Override
	public Person getObject() throws Exception {
		System.out.println("getObject...");
		return new Person();
	}

	/**
	 * 该方法返回bean的类型
	 */
	@Override
	public Class<?> getObjectType() {
		return Person.class;
	}

	/**
	 * 是否是单实例的bean
	 * true: 单实例的bean
	 * false: 多实例的bean
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
