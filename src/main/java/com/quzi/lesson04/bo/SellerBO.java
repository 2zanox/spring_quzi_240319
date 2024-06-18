package com.quzi.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quzi.lesson04.domain.Seller;
import com.quzi.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	
	@Autowired
	private SellerMapper sellserMapper;
	
	// quiz01
	public void addSeller(String nickname, String profileImageUrl, double temperature) {
		sellserMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	public Seller getSellerInfo() {
		return sellserMapper.selectSellerInfo();
	}
	
}
