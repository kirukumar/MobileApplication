package com.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.application.dto.Mobiledto;
import com.application.model.MobilePhone;

@Mapper
public interface MobileMapper {

	@Mapping(target="mobileId",source="mobilephone.mobileId")
	@Mapping(target="color",source="mobilephone.color")
	@Mapping(target="batteryPower",source="mobilephone.batteryPower")
	
	public Mobiledto MobilephoneconverttoMobilePhonedto(MobilePhone mobilephone);
		
	
	@Mapping(target="mobileId", source="mobileId")
	@Mapping(target="color",source="color")
	@Mapping(target="batteryPower",source="batteryPower")
	
	public MobilePhone MobiledtoconverttoMobilePhone(Mobiledto mobiledto);
}
