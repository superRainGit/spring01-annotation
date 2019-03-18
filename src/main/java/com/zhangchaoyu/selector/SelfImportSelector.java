package com.zhangchaoyu.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class SelfImportSelector implements ImportSelector {

	/**
	 * importingClassMetadata: 标识@Import 注解的类上的所有的注解的信息
	 * @return 返回注入到ioc容器中的bean的全类名
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.zhangchaoyu.bean.Worker"};
	}

}
