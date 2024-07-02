package com.quzi.booking.bo;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quzi.booking.domain.Booking;
import com.quzi.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	
	@Autowired
	private BookingMapper bookingMapper;
	
	// select
	// input: X
	// output: List<Booking>
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	// delete
	// input: id
	// output: int
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	// insert
	// input: parameter
	// output: insert
	public void addBooking(String name, LocalDate date,
			int day, int headcount, String phoneNumber) {
		
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// select 예약확인 조회
	// input: name, phoneNumber
	// output: booking(최신) or null
	public Booking getLatestBookingByNamePhoneNumber(String name, String phoneNumber) {
		// 없을 때: []	있을 때: [booking1, booking2, booking3....]
		List<Booking> bookingList = bookingMapper.selectBookingListByNamePhoneNumber(name, phoneNumber);
		
		return bookingList.isEmpty() ? null :bookingList.get(bookingList.size() -1);
	}
	
}
