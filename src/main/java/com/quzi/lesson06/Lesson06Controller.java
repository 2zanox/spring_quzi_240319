package com.quzi.lesson06;

import java.util.List;

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
	
	// http://localhost:8080/lesson06/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView () {
		return "lesson06/addBookmark";
	}
	
	// AJAX가 하는 요청
	@ResponseBody
	@PostMapping("/add-bookmark")
	public String addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// DB insert
		bookmarkBO.addBookmark(name, url);
		
		return "성공"	;
	}
	
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
}
