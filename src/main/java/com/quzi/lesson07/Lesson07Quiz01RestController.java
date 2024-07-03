package com.quzi.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quzi.lesson07.bo.CompanyBO;
import com.quzi.lesson07.entity.CompanyEntity;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson07Quiz01RestController {
	
	@Autowired
	private CompanyBO companyBO;
	
	// http://localhost:8080/lesson07/quiz01/save1
	@GetMapping("/save1")
	public CompanyEntity save1() {
		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		int headcount = 3585;
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	// http://localhost:8080/lesson07/quiz01/save2
	@GetMapping("/save2")
	public CompanyEntity save2() {
		// 회사명 : 버블팡
		// 사업내용 : 여신 금융업
		// 규모 : 대기업
		// 사원수 : 6834명
		
		return companyBO.addCompany("버블팡", "여신 금융업", "대기업", 6834);
	}
	
	// http://localhost:8080/lesson07/quiz01/update
	@GetMapping("/update")
	public CompanyEntity update() {
		// id가 8번, 규모를 중소기업, 사원수를 34명
		
		return companyBO.updateCompanyById(8, "중소기업", 34);
	}
	
	// http://localhost:8080/lesson07/quiz01/delete
	@GetMapping("/delete")
	public String delete() {
		// 버블팡인 회사 id 삭제(8)
		companyBO.deleteCompanyById(8);
		
		return "삭제 성공";
	}
	
}
