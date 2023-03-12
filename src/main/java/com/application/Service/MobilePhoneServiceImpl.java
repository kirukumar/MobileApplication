package com.application.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.application.dao.Mobiledao;
import com.application.dto.Mobiledto;
import com.application.mapper.MobileMapper;
import com.application.mapper.MobileMapperImpl;
import com.application.model.MobilePhone;

@Service
public class MobilePhoneServiceImpl implements MobilePhoneService {
	

	@Autowired
	Mobiledao mobiledao;
	
	@Autowired
MobileMapper mapper;
	@Override
	public String saveProduct(MobilePhone mobilephone) {

		
		
		// TODO Auto-generated method stub
		mobiledao.save(mobilephone);

		return "product saved succesfully";

	}

	@Override
	public String deleteMobilePhone(int id) {

		mobiledao.deleteById(id);
		return "product deleted successsfully";
	}

	@Override
	public List<MobilePhone> getAllMobiles() {
		// TODO Auto-generated method stub
		return (List<MobilePhone>) mobiledao.findAll();

	}

	@Override
	public MobilePhone getMobilePhoneById(int id) {
		// TODO Auto-generated method stub
		Optional<MobilePhone> mobilephone = mobiledao.findById(id);
		return mobilephone.get();

	}

	@Override
	public MobilePhone editMobilephone(MobilePhone mobilePhone) {

		mobiledao.save(mobilePhone);

		return mobilePhone;
	}

	@Override
	public boolean isMobilephoneExists(int mobileid) {
		// TODO Auto-generated method stub
		Optional<MobilePhone> mobilephones = mobiledao.findById(mobileid);
		return mobilephones.isPresent();

	}

	@Override
	public List<MobilePhone> getMobilePhoneByBrandName(String brandName) {
		// TODO Auto-generated method stub

		return mobiledao.findByBrandname(brandName);

	}

	@Override
	public List<MobilePhone> getMobilePhoneByModelName(String modelName) {

		return mobiledao.findByModelName(modelName);
	}

	@Override
	public int getMobilePhone(double cost) {
		// TODO Auto-generated method stub
		List<MobilePhone> mobilephones = mobiledao.findByMobilePhoneCostGreaterThan(cost);
		int count = 0;
		for (MobilePhone a : mobilephones) {

			count++;

		}

		return count;

	}

	@Override
	public List<MobilePhone> getByColor(String color) {
		// TODO Auto-generated method stub
		return mobiledao.findByColor(color);

	}

	@Override
	public List<MobilePhone> getByprocessor(String processor) {
		// TODO Auto-generated method stub
		return mobiledao.findByProcessor(processor);
		
		
	}
	
	public int getbyuniquemodelname(){
		
		List<MobilePhone> mobilephone = (List<MobilePhone>) mobiledao.findAll();
		HashSet<String> set = new HashSet<String>();
		for(MobilePhone a : mobilephone) {
			set.add(a.getModelName());	
			}
		return set.size();	
		
	}

	@SuppressWarnings("null")
	@Override
	public List<Mobiledto> getAllMobilePhones() {
		
		 List<MobilePhone> mobilephone = (List<MobilePhone>) mobiledao.findAll();
		// TODO Auto-generated method stub
		 Mobiledto mobiledto = new Mobiledto();
		 List<Mobiledto> mobiledtolist= new ArrayList<Mobiledto>();
	for(MobilePhone a : mobilephone ) {
		
		
		
		
		 mobiledtolist.add(mapper.MobilephoneconverttoMobilePhonedto(a));
		  
		 
		
	}
	return mobiledtolist ;
		
		
	}
	
	
	
		    


	@Override
	public String saveusingdto(Mobiledto mobiledto) {
		
//		MobilePhone mobilePhone = new MobilePhone();
//		System.out.println(mobiledto.getMobileId());
//		mobilePhone.setMobileId(mobiledto.getMobileId());
//		mobilePhone.setColor(mobiledto.getColor());
//		mobilePhone.setBatteryPower(mobiledto.getBatteryPower());
//		mobiledao.save(mobilePhone);
//		System.out.println(mobilePhone);
//		
//	   mobiledto=mapper.MobilephoneconverttoMobilePhonedto(mobilePhone);
		
		
		MobileMapper mobilemapper = new MobileMapperImpl();
//	
	MobilePhone mobilePhone = mobilemapper.MobiledtoconverttoMobilePhone(mobiledto);
//	System.out.println(mobilePhone);
		mobiledao.save(mobilePhone);
//		System.out.println(mobilePhone);
		return "updated successfully";
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public Mobiledto getMobilePhoneByIdusingdto(int id) {
		// TODO Auto-generated method stub

		 Optional<MobilePhone> mobilephone=mobiledao.findById(id);
	     
		    Mobiledto mobiledto= mapper.MobilephoneconverttoMobilePhonedto(mobilephone.get());
		    		return mobiledto; 
	}

	@Override
	public List<Mobiledto> getMobilePhoneByBrandNameusingdto(String brandName) {
		 List<MobilePhone> mobiledtolist= new ArrayList<MobilePhone>();
		 List<Mobiledto> mobiledtolistdto= new ArrayList<Mobiledto>();
		// TODO Auto-generated method stub
		 mobiledtolist = mobiledao.findByBrandname(brandName);
		 for(MobilePhone a :mobiledtolist ) {
			 mobiledtolistdto.add( mapper.MobilephoneconverttoMobilePhonedto(a));
			 
		 }
		 return mobiledtolistdto;
		
	}

	@Override
	public List<Mobiledto> getMobilePhoneByModelNameusingdto(String modelName) {
		// TODO Auto-generated method stub
		 List<MobilePhone> mobiledtolist= new ArrayList<MobilePhone>();
		 List<Mobiledto> mobiledtolistdto= new ArrayList<Mobiledto>();
		// TODO Auto-generated method stub
		 mobiledtolist = mobiledao.findByModelName(modelName);
		 for(MobilePhone a :mobiledtolist ) {
			 mobiledtolistdto.add( mapper.MobilephoneconverttoMobilePhonedto(a));
			 
		 }
		 return mobiledtolistdto;
	}
	

}
