package com.example.demo.weather;

import lombok.Data;

@Data
public class ZipCodeResults {

	private String zip;
	private String name;
	private double lat;
	private double lon;
	private String country;

}
