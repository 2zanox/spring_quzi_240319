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
	
}
