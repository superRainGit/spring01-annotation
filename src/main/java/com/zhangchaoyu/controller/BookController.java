package com.zhangchaoyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zhangchaoyu.service.BookService;

@Controller
@SuppressWarnings("unused")
public class BookController {

	@Autowired
	private BookService bookService;
}
