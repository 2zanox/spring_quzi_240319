package com.quzi.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quzi.lesson03.bo.RealEstateBO;
import com.quzi.lesson03.domain.RealEstate;

@RestController
public class Lesson03Quzi01RestController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	// http://localhost:8080/lesson03/quiz01/1?id=20
	@RequestMapping("/lesson03/quiz01/1")
	public RealEstate quzi01_1(
			@RequestParam("id") int id) {
		return realEstateBO.getRealEstateById(id);
	}
	
	// http://localhost:8080/lesson03/quiz01/2?rent_price=90
	// input(response): rent_price(필수)
	// output(response): List<RealEstate>
	@RequestMapping("/lesson03/quiz01/2")
	public List<RealEstate> quzi01_2(
			@RequestParam("rent_price") int rentPrice) {
		return realEstateBO.getRealEstateListByRentPrice(rentPrice);
	}
	
	// http://localhost:8080/lesson03/quiz01/3?area=90&price=130000
	@RequestMapping("/lesson03/quiz01/3")
	public List<RealEstate> quzi01_3(
			@RequestParam("area") int area,
			@RequestParam(value = "price", required = true) int price) {
		return realEstateBO.getRealEstateListByAreaPrice(area, price);
	}
	
}
