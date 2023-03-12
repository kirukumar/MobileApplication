package com.application.dto;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mobiledto {
	
	
	
	private int mobileId;
	private String color;
	private String batteryPower;
	
	

}
