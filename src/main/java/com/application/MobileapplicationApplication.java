package com.application;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.application.mapper.MobileMapper;
import com.application.mapper.MobileMapperImpl;

@SpringBootApplication

public class MobileapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileapplicationApplication.class, args);
		System.out.println("welcome to my mobile app");
	}
	 
}

