package com.quzi.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.quzi.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	
	public RealEstate selectRealEstateById(int id);
	
	public RealEstate selectRealEstateListByRentPrice(int rentPrice);
	
}
