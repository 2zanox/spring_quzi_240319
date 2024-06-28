package com.quzi.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quzi.lesson06.domain.Bookmark;
import com.quzi.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	
	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	// quiz01
	
	// input: name, url
	// output: X
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	// input: X
	// output: List<Bookmark>
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	// quiz02
	
	// input: url
	// output: boolean
	public boolean isDuplicationByUrl(String url) {
		return bookmarkMapper.isDuplicationByUrl(url);
	}
	
	// input: url
	// output: boolean
	public boolean isDuplicationUrl(String url) {
		// 중복 [bookmark1, bookmark2] true		중복 아님:[] false
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkListByUrl(url);
		return bookmarkList.isEmpty() ? false : true;
		//return !bookmarkList.isEmpty();
	}
	
	// input: id
	// output: X
	public int deleteBookmarkById(int id) {
		return bookmarkMapper.deleteBookmarkById(id);
	}
	
}
