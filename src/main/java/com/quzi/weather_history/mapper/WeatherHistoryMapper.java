package com.quzi.weather_history.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quzi.weather_history.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {
	
	public List<WeatherHistory> selectWeatherHistoryList();
	
	public int insertWeather(WeatherHistory weatherHistory);
	
}
