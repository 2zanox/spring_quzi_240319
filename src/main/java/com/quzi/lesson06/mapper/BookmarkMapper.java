package com.quzi.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quzi.lesson06.domain.Bookmark;

@Mapper
public interface BookmarkMapper {
	
	// quiz01
	public void insertBookmark(
			@Param("name") String name, 
			@Param("url") String url);
	
	public List<Bookmark> selectBookmarkList();
	
	// quiz02
	public boolean isDuplicationByUrl(String url);
	
}
