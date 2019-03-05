package com.zhangchaoyu.config;

import java.io.IOException;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class SelfTypeFilter implements TypeFilter {

	/**
	 * metadataReader: 获取当前被扫描的类的一些信息
	 * metadataReaderFactory: 获取类的其他的信息
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		String className = classMetadata.getClassName();
		System.out.println("-->" + className);
		return className.contains("er");
	}

}
