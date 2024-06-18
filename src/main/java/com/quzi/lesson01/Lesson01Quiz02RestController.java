package com.quzi.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {
	
	//  http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, String>> quzi02_1() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
		Map<String, String> map = new HashMap<>();
		map.put("rate", "15");
		map.put("director", "봉준호");
		map.put("time", "131");
		map.put("title", "기생충");
		list.add(map);
		
		Map<String, String> map1 = new HashMap<>();
		map1.put("rate", "0");
		map1.put("director", "로베르토 베니니");
		map1.put("time", "116");
		map1.put("title", "인생은 아름다워");
		list.add(map1);
		
		Map<String, String> map2 = new HashMap<>();
		map2.put("rate", "12");
		map2.put("director", "크리스토퍼 놀란");
		map2.put("time", "147");
		map2.put("title", "인셉션");
		list.add(map2);
		
		map = new HashMap<>();
		map.put("rate", "19");
		map.put("director", "윤종빈");
		map.put("time", "133");
		map.put("title", "범죄와의 전쟁 : 나쁜놈들의 전성시대");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", "15");
		map.put("director", "프란시스 로렌스");
		map.put("time", "137");
		map.put("title", "헝거게임");
		list.add(map);
		
		return list;
	}
	
	// http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Board> quzi02_2() {
		// @ResponseBody + return String => HttpMessageConverter => HTML
		// @ResponseBody + return 객체(Map, 객체, List) => HttpMessageConverter => jackson lib =>JSON
		
		List<Board> list = new ArrayList<>();
		
		Board board = new Board();
		board.setTitle("안녕하세요");
		board.setUser("marobiana");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		list.add(board);
		
		Board board1 = new Board();
		board1.setTitle("헐 대박");
		board1.setUser("bada");
		board1.setContent("오늘 목요일이였어... 금요일인줄");
		list.add(board1);
		
		board = new Board();
		board.setTitle("오늘 데이트 한 이야기 해드릴께요.");
		board.setUser("dulumary");
		board.setContent("...");
		list.add(board);
		
		return list;
	}
	
	// http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<Board> quzi02_3() {
		Board board = new Board();
		board.setTitle("안녕하세요");
		board.setUser("marobiana");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		
		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
