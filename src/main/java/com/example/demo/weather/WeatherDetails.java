package com.example.demo.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class WeatherDetails {
	
	private int id;
	private String icon;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIcon() {
		return "http://openweathermap.org/img/wn/" + this.icon + "@2x.png";
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	

}
