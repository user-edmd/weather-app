package com.example.demo.weather;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Weather {

	private Main main;
	private Sys sys;
	private String name;	
	private List<WeatherDetails> weather;
	

	public List<WeatherDetails> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherDetails> weather) {
		this.weather = weather;
	}

	public Weather() {}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return "Weather [main=" + main + ", sys=" + sys + ", name=" + name + "]";
	}

	
}
