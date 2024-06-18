package com.quzi.lesson02;

import java.util.List;

import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quzi.lesson02.bo.StoreBO;

@RestController
public class Lesson02Quiz01RestController {
	
	@Autowired
	private StoreBO storeBO;
	
	// http://localhost/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quzi01() {
		List<Store> storeList = storeBO.getStoreList();
		return storeList; // JSON String
	}
	
}
