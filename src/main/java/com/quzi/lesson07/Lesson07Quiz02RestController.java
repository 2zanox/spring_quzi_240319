package com.quzi.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quzi.lesson07.entity.RecruitEntity;
import com.quzi.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	// http://localhost:8080/lesson07/quiz02/1
	@GetMapping("/1")
	public List<RecruitEntity> select1() {
		return recruitRepository.findById(8);
	}
	
	// http://localhost:8080/lesson07/quiz02/2
	@GetMapping("/2")
	public List<RecruitEntity> select2() {
		return recruitRepository.findTop3ByOrderById();
	}
	
	// http://localhost:8080/lesson07/quiz02/3
	@GetMapping("/3")
	public List<RecruitEntity> select3() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	// http://localhost:8080/lesson07/quiz02/4
	@GetMapping("/4")
	public List<RecruitEntity> select4() {
		return recruitRepository.findByTypeOrSalary("정규직", 9000);
	}
	
	// http://localhost:8080/lesson07/quiz02/5
	@GetMapping("/5")
	public List<RecruitEntity> select5() {
		return recruitRepository.findTop3ByOrderBySalaryDesc();
	}
	
	// http://localhost:8080/lesson07/quiz02/6
//	@GetMapping("/6")
//	public List<RecruitEntity> select6() {
//		
//	}
	
}
