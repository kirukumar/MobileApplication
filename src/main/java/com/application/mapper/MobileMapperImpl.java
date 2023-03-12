package com.application.mapper;



import org.springframework.stereotype.Service;

import com.application.dto.Mobiledto;
import com.application.model.MobilePhone;


@Service
public class MobileMapperImpl implements MobileMapper {

	@Override
	public Mobiledto MobilephoneconverttoMobilePhonedto(MobilePhone mobilephone) {
		// TODO Auto-generated method stub
		Mobiledto mobiledto = new Mobiledto();
		System.out.println(mobilephone);
	mobiledto.setMobileId(mobilephone.getMobileId());
	mobiledto.setColor(mobilephone.getColor());
	mobiledto.setBatteryPower(mobilephone.getBatteryPower());
	
	return mobiledto;
		
	}

	@Override
	public MobilePhone MobiledtoconverttoMobilePhone(Mobiledto mobiledto) {
		// TODO Auto-generated method stub
		MobilePhone mobilephone = new MobilePhone();
//		System.out.println(mobiledto.getMobileId());
		mobilephone.setMobileId(mobiledto.getMobileId());
		mobilephone.setColor(mobiledto.getColor());
		mobilephone.setBatteryPower(mobiledto.getBatteryPower());
		
		
		return mobilephone;
		
	}

}
