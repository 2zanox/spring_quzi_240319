package com.quzi.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quzi.lesson04.bo.SellerBO;
import com.quzi.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	// 판매자 추가 화면
	@GetMapping("/add-seller-view")
	public String addSeller() {
		return "lesson04/addSeller";
	}
	
	// 판매자 추가 진행 => DB 저장 => 결과 화면
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
		// DB 저장 - insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 결과 화면
		return "lesson04/afterAddSeller";
	}
	
	// 최근 가입자 뿌리는 화면
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	@GetMapping("/seller-info-view")
	public String sellerInfoView(Model model) {
		// DB select (최신 가입자 1명)
		Seller seller = sellerBO.getSellerInfo();
		
		// Model
		model.addAttribute("result", seller);
		model.addAttribute("title", "최근 가입한 유저 정보!");
		
		// 화면
		return "lesson04/sellerInfo";
	}
	
}
