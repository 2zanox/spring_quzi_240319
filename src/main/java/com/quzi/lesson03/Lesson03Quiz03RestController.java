package com.quzi.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quzi.lesson03.bo.RealEstateBO;

@RestController
public class Lesson03Quiz03RestController {
	
	// http://localhost:8080/lesson03/quiz03/1?id=8&type=전세&price=70000
	@Autowired
	private RealEstateBO realestateBO;
	
	@RequestMapping("/lesson03/quiz03/1")
	public String quzi03_1(
			@RequestParam("id") int id,
			@RequestParam("type") String type,
			@RequestParam("price") int price) {
		
		int rowCount = realestateBO.updateRealEstateById(id, type, price);
		return "수정 성공: " + rowCount;
	}
	
}
