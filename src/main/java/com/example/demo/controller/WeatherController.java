package com.example.demo.controller;

import java.io.IOException;

import com.example.demo.weather.Weather;
import com.example.demo.weather.ZipCodeResults;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.model.WeatherSearch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherController {
	
	@RequestMapping("/index")
	public String searchPage(Model theModel) {
		WeatherSearch weatherSearch = new WeatherSearch();
		theModel.addAttribute("zipSearch", weatherSearch);
		return "index";
	}

	@RequestMapping("/showPage")
	public String showPage(WeatherSearch weatherSearch, Model theModel) {
		
		String weatherToken = System.getenv("WEATHER_TOKEN");
		String uri = "http://api.openweathermap.org/geo/1.0/zip?zip=" + weatherSearch.getZipCode() + ",us&appid=" + weatherToken;
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		try {
			ObjectMapper mapper = new ObjectMapper();
			ZipCodeResults zipCodeResults = mapper.readValue(result, ZipCodeResults.class);
			uri = "https://api.openweathermap.org/data/2.5/weather?lat=" + zipCodeResults.getLat() + "&lon=" + zipCodeResults.getLon() + "&units=imperial&appid=" + weatherToken;
			restTemplate = new RestTemplate();
			result = restTemplate.getForObject(uri, String.class);

			try {
				mapper = new ObjectMapper();
				Weather weather = mapper.readValue(result, Weather.class);
				theModel.addAttribute("weatherTest", weather);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
//		//String uri = "https://api.openweathermap.org/data/2.5/weather?lat=32.785990&lon=-117.110910&units=imperial&appid=" + weatherToken;
//		RestTemplate restTemplate = new RestTemplate();
//		String result = restTemplate.getForObject(uri, String.class);
//
//		try {
//			ObjectMapper mapper = new ObjectMapper();
//			Weather weather = mapper.readValue(result, Weather.class);
//			theModel.addAttribute("weatherTest", weather);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "weather";
	}
	
		

}
