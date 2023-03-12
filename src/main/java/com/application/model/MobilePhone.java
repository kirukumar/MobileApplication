package com.application.model;

import java.util.ArrayList;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import antlr.collections.List;
import lombok.Data;



@Entity
@Data
@Table(name="mobileproducts")

@Component

public class MobilePhone {
	

	@Id
	private int mobileId;
	private String brandname;
	private String modelName;
	private String color;
	private String batteryPower;
	private String processor;
	private double mobilePhoneCost;
	
	
}
