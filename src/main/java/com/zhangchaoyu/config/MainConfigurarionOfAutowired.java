package com.zhangchaoyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zhangchaoyu.bean.Car;
import com.zhangchaoyu.bean.Cat;
import com.zhangchaoyu.dao.BookDao;

/**
 * 自动装配
 * 	spring利用依赖注入(DI)，完成IOC容器中各个组件的依赖关系的赋值
 * 
 * (1)@Autowired 自动注入 
 * 	1.默认优先按照类型去容器中找对应的组件，如果找到那么直接赋值
 * 	2.如果在容器中找到多个类型相同的组件，再将属性的名称作为组件的ID去容器中查找
 *  3.使用@Qualifier注解制定装配的id 而不是根据属性进行装配
 *  4.自动装配默认一定要将属性赋值好  没有就会报错
 *    	可以配合@Autowired注解的required属性指定为false 在无法找到对应的bean时不进行装配:w
 *  5.@Primary: 让spring进行自动装配的时候使用首选的bean
 *  	也可以继续使用@Qualifier指定需要装配的bean的名字
 * (2)Spring还支持使用@Resouce(JSR250)和@Inject(JSR330)注解[java规范的注解]
 * 	1. 可以和@Autowired一样实现自动装配功能  但是@Resource默认是按照组件名称进行装配的
 * 		但是无法使用@Primary注解提供的优先注入的功能以及不支持@Autowired(request=false)功能
 *  2. 可以和@Autowired一样实现自动装配的功能 但是@Inject需要引入javax.inject的包
 *  	该注解可以使用@Primary注解的功能但是也不支持@Autowired(request=false)的功能
 *  
 *  @Autowired注解可以放置的位置 都是从容器中获取参数组件的值
 *  	构造器        参数     方法     属性
 *  	1. 标注在方法位置:放在setter方法上或者使用@Bean+方法参数的方式[不使用@Autowired的效果是一样的]
 *  	2. 标注在构造器上:如果组件只有一个有参构造器 这个有参构造器的@Autowired可以不写
 *  	3. 放在参数的位置上:即使用如下方式完成注入(@Autowired Car car)
 */
@Configuration
@ComponentScan({"com.zhangchaoyu.controller", "com.zhangchaoyu.service", 
	"com.zhangchaoyu.dao", "com.zhangchaoyu.bean"})
public class MainConfigurarionOfAutowired {
	
	/**
	 * 通过指定@Primary注解 指定 在发生了IOC容器无法确定装配哪个bean
	 * 时选取的优先级最高的bean
	 */
	@Bean("bookDao2")
	@Primary
	public BookDao bookDao() {
		BookDao bookDao = new BookDao();
		bookDao.setLable("2");
		return bookDao;
	}
	
	/**
	 * 使用@Bean注解方式在方法中传入的参数
	 * 可以不使用@Autowired注解 即可使用IOC容器中的bean
	 */
	@Bean
	public Cat cat(Car car) {
		Cat cat = new Cat();
		cat.setCar(car);
		return cat;
	}
}
