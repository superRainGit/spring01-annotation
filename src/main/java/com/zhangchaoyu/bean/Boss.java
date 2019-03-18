package com.zhangchaoyu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
public class Boss {
	
	// 使用此方式类似之前的自动注入
//	@Autowired
	private Car car;

	// 将此注解放在构造器上也可以直接使用
	// 在对象构造时使用改方法  如果一个对象的只有一个有参构造器 那么@Autowired注解可以省略不写
//	@Autowired
	public Boss(/*@Autowired*/ Car car) {
		System.out.println("Boss constructor...");
		this.car = car;
	}

	// 也可以放在setter方法上
	// 放在此方法上 在构造完成初始化的时候会调用此方法
	@Autowired
	public void setCar(Car car) {
		System.out.println("Boss setter...");
		this.car = car;
	}
}
