package com.quzi.weather_history;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	
	// http://localhost:8080/weather-history/weather-list-view
	// 날씨 목록 화면
	@GetMapping("/weather-list-view")
	public String weatherListView() {		
		return "weather_history/weatherList";
	}
	
	// http://localhost:8080/weather-history/add-weather-view
	// 날씨 입력 화면
	@GetMapping("add-weather-view")
	public String addWeatherView() {		
		return "weather_history/addWeather";
	}
	
}
