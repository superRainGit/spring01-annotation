package com.zhangchaoyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.zhangchaoyu.bean.Person;
import com.zhangchaoyu.bean.Student;
import com.zhangchaoyu.bean.Teacher;
import com.zhangchaoyu.condition.LinuxCondition;
import com.zhangchaoyu.condition.WindowsCondition;
import com.zhangchaoyu.definition.SelfBeanDefinitionRegister;
import com.zhangchaoyu.factory.SelfFactoryBean;
import com.zhangchaoyu.selector.SelfImportSelector;

/**
 * 使用@Conditional 
 * 注解还可以用于类上 使用此注解标识的方式是: 只有该条件满足 那么才会将类中的bean放入到ioc容器中
 */
@Conditional(WindowsCondition.class)
@Configuration
@Import({Teacher.class, Student.class, SelfImportSelector.class, SelfBeanDefinitionRegister.class})
public class MyConfiguration2 {

	/**
	 * 使用@Scope注解配置bean的作用域的范围
	 * 可选的配置方式有四种
	 * singleton: 单实例的注入bean 在IOC容器开始加载时就已经放入到了IOC容器中
	 * prototype: 多实例的注入bean 在每次获取时才开始获取对象
	 * request
	 * session
	 * 懒加载：
	 * 		单实例的bean 默认在容器在启动时创建bean对象
	 * 		如果使用懒加载 容器启动时不创建对象 改为第一次使用改bean对象时创建
	 */
	@Lazy
	@Scope("")
	@Bean("person")
	public Person person() {
		System.out.println("person init....");
		return new Person();
	}

	/**
	 * 使用 @Conditional 注解用于根据条件进行bean的注册
	 */
	@Conditional({WindowsCondition.class})
	@Bean("bill")
	public Person person01() {
		return new Person("bill gits", 50);
	}

	@Conditional(LinuxCondition.class)
	@Bean("linux")
	public Person person02() {
		return new Person("linus", 40);
	}
	
	/**
	 * 注入bean的几种方式
	 * 1 使用包扫描以及使用spring提供的注解(@Controller @Service @Component @Repository)
	 * 2 使用@Bean 注解进行bean的注入
	 * 3 使用@Import 注解进行bean的注入
	 * 		一、直接使用@Import(类型名) 通过直接配置类型名的方式来向ioc容器中注册bean
	 * 		二、通过实现 ImportSelector接口来控制注入哪些bean
	 * 		三、通过实现ImportBeanDefinitionRegistrar接口通过beanDefinitionRegistry来注册bean
	 * 4 使用FactoryBean向ioc容器中注入bean
	 * 		一、使用该方法默认注入的bean的类型是FactoryBean的getObject()的对象的类型
	 * 		二、如果向要获取FactoryBean对象本身 那么通过在Id前面加上&+id的方式获取
	 */
	@Bean
	public SelfFactoryBean factoryBean() {
		return new SelfFactoryBean();
	}
}
