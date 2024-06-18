package com.quzi.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quzi.lesson03.domain.RealEstate;
import com.quzi.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateMapper realEstateMapper;
	
	// quzi01
	
	// input: id(int)
	// output: RealEstate
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	// input: rentPrice
	// output: List<RealEstate>
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
	
	// input: area, price
	// output: List<RealEstate>
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price) {
		return realEstateMapper.selectRealEstateListByAreaPrice(area, price);
	}
	
	// quzi02
	
	// input: RealEstate(insert한 행)
	// output: 성공한 행의 개수(int)
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	// input: RealEstatefield(insert한 행)
	// output: 성공한 행의 개수(int)
	public int addRealEstatefield(int realtorId, String address, int area,
			String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstatefield(realtorId, address, area, type, price, rentPrice);
	}
	
	// quzi03
	
	// input: id, type, price
	// output: 성공한 행의 개수(int)
	public int updateRealEstateById(int id, String type, int price) {
		return realEstateMapper.updateRealEstateById(id, type, price);
	}
	
	// quzi04
	// input: id
	// output: void => X
	public void deleteRealEstateById(int id) {
		realEstateMapper.deleteRealEstateById(id);
	}
	
}
