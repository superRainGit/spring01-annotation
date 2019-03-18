package com.zhangchaoyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zhangchaoyu.dao.BookDao;

import lombok.ToString;

@Service
@ToString
public class BookService {

	@Qualifier("bookDao")
	@Autowired(required = false)
	private BookDao bookDao2;
}
