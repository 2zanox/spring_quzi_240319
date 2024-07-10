package com.quzi.memo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/memo")
@Controller
public class MemoController {
	
	// http://localhost:8080/memo/login-view
	@GetMapping("/login-view")
	public String loginView() {
		return "memo/login";
	}
	
	// http://localhost:8080/memo/joinmembership-view
	@GetMapping("/joinmembership-view")
	public String joinmembershipView() {
		return "memo//joinmembership";
	}
}
