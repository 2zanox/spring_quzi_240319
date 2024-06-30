package com.quzi.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quzi.booking.bo.BookingBO;
import com.quzi.booking.domain.Booking;

@RequestMapping("/templates/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	// 예약 목록 화면
	// http://localhost:8080/templates/booking/booking-list-view
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		// DB select
		List<Booking> BookingList = bookingBO.getBookingList();
		
		// model담기
		model.addAttribute("BookingList", BookingList);
		
		return "booking/bookingList";
	}
	
	// 예약하기 화면
	// http://localhost:8080/templates/booking/make-booking-view
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}

	// 예약확인 화면
	// http://localhost:8080/templates/booking/check-booking-view
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	// 삭제 화면
	// http://localhost:8080/templates/booking/delete-booking?id=3
	// AJAX 요청 - id로 삭제
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {

		// DB delete
		int rowCount = bookingBO.deleteBookingById(id);
		
		// 응답값 json
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {	
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 항목이 존재하지 않습니다.");
		}
		
		return result;
	}
	
	// 예약하는 AJAX
	// AJAX 요청 - insert
	@ResponseBody
	@PostMapping("/add-booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name,
			@RequestParam("date") LocalDate date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// DB insert
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// 응답값 json
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
				
		return result;
	}
	
}
