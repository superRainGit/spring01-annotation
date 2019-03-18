package com.zhangchaoyu.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class DataSource {

	private String name;
	
	private String pwd;
	
	private String url;
}
