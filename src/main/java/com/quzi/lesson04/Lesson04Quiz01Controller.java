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
	
	// quiz01) http://localhost:8080/lesson04/quiz01/add-seller-view
	// 판매자 추가 화면
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// 판매자 DB 저장 => 성공 화면
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
//			@RequestParam("temperature") double temperature
			@RequestParam(value = "temperature", defaultValue = "36.5") double temperature) {
		
		// DB 저장 - insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 결과 화면
		return "lesson04/afterAddSeller";
	}
	
	// 방금 가입한 판매자 1명 화면
	// quiz02) http://localhost:8080/lesson04/quiz01/seller-info-view
	// quiz03) http://localhost:8080/lesson04/quiz01/seller-info-view?id=3
	@GetMapping("/seller-info-view")
	public String sellerInfoView(Model model,
			@RequestParam(value ="id", required = false) Integer id) {
		// DB select (최신 가입자 1명) - 데이터 조회		
		Seller seller = null;
		
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getLatestSellerById(id);
		}
		
		// Model에 데이터를 담아둔다.
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		// 화면
		return "lesson04/sellerInfo";
	}
	
}
