package com.coolweather.app.model;

public class County {
	private int id ;
	private String countyName;
	private String countyCode;
	private int cityId;
	 public void setCountyName(String countyName) {
		 this.countyName = countyName;
		 
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public void setCountyCode(String countyCode) {
		 this.countyCode = countyCode;
	 }
	 public String getCountyName() {
		 return countyName;
	 }
	 public String getCountyCode() {
		 return countyCode;
	 }
	 public int getId() {
		 return id;
	 }
	 public void setCityId(int cityId) {
		 this.cityId = cityId;
	 }
	 public int getCityId() {
		 return cityId;
	 }

}