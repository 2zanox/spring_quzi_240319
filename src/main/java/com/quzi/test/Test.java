package com.quzi.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
	
	@ResponseBody
	@RequestMapping("/test01")
	public String test1() {
		return "Hello world!";
	}
	
}
