package com.quzi.lesson02.mapper;

import java.util.List;

import org.apache.catalina.Store;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {
	
	public List<Store> selectStoreList();
	
}
