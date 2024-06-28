package com.quzi.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quzi.booking.bo.BookingBO;
import com.quzi.booking.domain.Booking;

@RequestMapping("/templates/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	// http://localhost:8080/templates/booking/bookingList
	@GetMapping("/bookingList")
	public String bookingList(Model model) {
		// DB select
		List<Booking> BookingList = bookingBO.getBookingList();
		
		// model담기
		model.addAttribute("BookingList", BookingList);
		
		return "booking/bookingList";
	}
	
}
