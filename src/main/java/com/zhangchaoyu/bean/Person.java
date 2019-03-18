package com.zhangchaoyu.bean;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
	
	/**
	 *	可以使用@Value注解进行对象的值的赋值
	 *	可以在注解中写入的值为
	 *	1、基本数值
	 *	2、spEL表达式: #{}
	 *	3、可以使用${} 获取配置文件中的属性对应的值
	 */
	@Value("张三")
	private String name;
	
	@Value("#{20 - 1}")
	private Integer age;
	
	@Value("${person.nickName}")
	private String nickName;

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
