package com.quzi.booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quzi.booking.domain.Booking;

@Mapper
public interface BookingMapper {
	
	public List<Booking> selectBookingList();
	
}
