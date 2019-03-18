package com.zhangchaoyu.config;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.zhangchaoyu.bean.Car;

/**
 * 用于学习bean的生命周期
 * 在ioc容器中 bean经历了如下的生命周期
 * 		bean的创建 --> bean的实例化 --> bean的销毁
 * bean的创建: 
 * 		单实例: 在IOC容器完成初始化时就完成了bean的创建
 * 		多实例: 在IOC容器每次使用bean对象时完成bean的创建
 * 在初始化之前调用的方法是 BeanPostProcessor.postProcessBeforeInitialization
 * bean的初始化: 
 * 		bean对象创建好，并赋值好，调用初始化方法
 * 在初始化之后调用的方法是 BeanPostProcessor.postProcessAfterInitialization
 * bean的销毁:
 * 		单实例: 在IOC容器进行关闭时销毁bean
 * 		多实例: IOC容器不再管理该bean对象的销毁 而是由开发者去销毁这样的对象
 * 如何使用Bean的生命周期
 * 	一、指定初始化以及销毁的方法
 * 	二、通过bean实现InitializingBean和DisposableBean接口的方式指定
 * 	三、通过使用JSR250中的注解
 * 		@PostConstruct: 在bean创建完成并且属性值赋值完成之后 来执行初始化
 * 		@PreDestory: 在容器销毁bean之前通知进行清理工作
 * 
 * 详解BeanPostProcessor中的方法何时调用
 * 	在初始化bean之前调用的postProcessBeforeInitialization
 *  在初始化bean之后调用的postProcessAfterInitialization
 *  
 *  	Object wrappedBean = bean;
		if (mbd == null || !mbd.isSynthetic()) {
			wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
		}

		try {
			invokeInitMethods(beanName, wrappedBean, mbd);
		}
		catch (Throwable ex) {
			throw new BeanCreationException(
					(mbd != null ? mbd.getResourceDescription() : null),
					beanName, "Invocation of init method failed", ex);
		}
		if (mbd == null || !mbd.isSynthetic()) {
			wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
		}	
 * Spring 使用BeanPostProcesser
 * 	bean赋值、注入其他组件、@Autowired、生命周期注解、@Async。。。。 
 *
 */
@ComponentScan("com.zhangchaoyu.bean")
@Configuration
@SuppressWarnings("unused")
public class MyConfiguration3 {
	
//	@Scope("prototype")
	@Bean(initMethod = "init", destroyMethod = "destory")
	public Car car() {
		return new Car();
	} 
}
