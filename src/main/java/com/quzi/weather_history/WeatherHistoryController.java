package com.quzi.weather_history;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quzi.weather_history.bo.WeatherHistoryBO;
import com.quzi.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// http://localhost:8080/weather-history/weather-list-view
	// 날씨 목록 화면
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		// select DB
		List<WeatherHistory> WeatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		// Model담기
		model.addAttribute("WeatherHistoryList", WeatherHistoryList);
		
		// 화면이동
		return "weather_history/weatherList";
	}
	
	// http://localhost:8080/weather-history/add-weather-view
	// 날씨 입력 화면
	@GetMapping("add-weather-view")
	public String addWeatherView() {		
		return "weather_history/addWeather";
	}
	
	// 날씨 추가 기능 /weather-history/add-weather
	@PostMapping("/add-weather")
	public String addWeather(
			@ModelAttribute WeatherHistory weatherHistory,
			Model model) {
		
		
		// DB저장
		weatherHistoryBO.addWeather(weatherHistory);
		
		// DB화면 뿌리기
		List<WeatherHistory> WeatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		return "weather_history/weatherList";
	}
	
	
}
