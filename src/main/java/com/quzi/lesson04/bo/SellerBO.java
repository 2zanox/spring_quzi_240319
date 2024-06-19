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
	// input: 파라미터들(nickname, profileImageUrl, temperature)
	// output: X
	public void addSeller(String nickname, String profileImageUrl, double temperature) {
		sellserMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
		
	// input: X
	// output: Seller(채워져 있거나 null)
	public Seller getLatestSeller() {
		return sellserMapper.selectLatestSeller();
	}
	
	// input: id
	// output: Seller(채워져 있거나 null)
	public Seller getLatestSellerById(int id) {
		return sellserMapper.selectLatestSellerById(id);
	}
	
}
