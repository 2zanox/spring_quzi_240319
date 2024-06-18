package com.quzi.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quzi.lesson04.domain.Seller;

@Mapper
public interface SellerMapper {
	
	// quiz01
	public int insertSeller(
			@Param("nickname") String nickname, 
			@Param("profileImageUrl") String profileImageUrl, 
			@Param("temperature") double temperature);
	
	public Seller selectSellerInfo();
}
