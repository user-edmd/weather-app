package com.example.demo.weather;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Sys {

	private long sunrise;
	private long sunset;

	public String getSunrise() {
		long javaTimestamp = this.sunrise * 1000L;
		Date date = new Date(javaTimestamp);
		return new SimpleDateFormat("hh:mm").format(date);
	}

	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}

	public String getSunset() {
		long javaTimestamp = this.sunset * 1000L;
		Date date = new Date(javaTimestamp);
		return new SimpleDateFormat("hh:mm").format(date);
	}

	public void setSunset(long sunset) {
		this.sunset = sunset;
	}
	

}
