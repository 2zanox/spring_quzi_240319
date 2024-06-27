package com.quzi.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quzi.lesson06.bo.BookmarkBO;
import com.quzi.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;
	
	// 추가하는 화면
	// http://localhost:8080/lesson06/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView () {
		return "lesson06/addBookmark";
	}
	
	// AJAX가 하는 요청
	// 즐겨찾기 추가 로직
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// DB insert
		bookmarkBO.addBookmark(name, url);
		
		// 성공 JSON
		// {"code":200, "result":"성공"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result; // JSON String
	}
	
	// 즐겨찾기 목록 화면
	// http://localhost:8080/lesson06/bookmark-list-view
	@GetMapping("/bookmark-list-view")
	public String BookmarkView(Model model) {
		// select DB
		List<Bookmark> BookmarkList = bookmarkBO.getBookmarkList();
		
		// Model담기
		model.addAttribute("BookmarkList", BookmarkList);
		
		// 결과 화면
		return "lesson06/BookmarkList";
	}
	
	// AJAX의 요청 - url 중복확인
	@ResponseBody
	@GetMapping("is-duplication-url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url) {
		
		// DB select
		boolean isDuplication = bookmarkBO.isDuplicationByUrl(url);
		
		// 응답 JSON
		// {"code":200, "is_duplication":ture}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplication);
		
		
		return result;
	}
	
}
