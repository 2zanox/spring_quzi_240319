package com.quzi.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quzi.weather_history.domain.WeatherHistory;
import com.quzi.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	// input: X
	// output: List<WeatherHistory>
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	
	public void addWeather(WeatherHistory weatherHistory) {
		weatherHistoryMapper.insertWeather(weatherHistory);
	}
	
}
