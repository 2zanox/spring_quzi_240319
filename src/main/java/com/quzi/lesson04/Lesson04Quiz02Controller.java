package com.quzi.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quzi.lesson04.bo.RealtorBO;
import com.quzi.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
	
	@Autowired
	private RealtorBO realtorBO;
	
	// http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	// DB Insert 화면
	@PostMapping("/add-realtor") 
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		
		// DB Insert
		realtorBO.addRealtor(realtor);
		
		// DB Select => 방금 가입한 아이디 조회
		// int id = realtor.getId();
		// Realtor latestRealtor = realtorBO.getRealtorById();
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId()); // 주석처리한 두개의 코드와 같은 의미다.
		
		// Model
		model.addAttribute("realtor", latestRealtor);
		
		// 결과화면
		return "lesson04/afterAddRealtor";
	}
		
}
