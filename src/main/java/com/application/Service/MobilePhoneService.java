package com.application.Service;

import java.util.List;

import com.application.dto.Mobiledto;
import com.application.model.MobilePhone;


public interface MobilePhoneService {

	public String saveProduct(MobilePhone mobilephone);
	public String deleteMobilePhone(int id);
	public List<MobilePhone> getAllMobiles();
	public MobilePhone getMobilePhoneById(int id);
	public MobilePhone editMobilephone(MobilePhone mobilePhone);
	public boolean isMobilephoneExists(int mobileid);
	public List<MobilePhone> getMobilePhoneByBrandName(String brandName);	
	public List<MobilePhone> getMobilePhoneByModelName(String modelName);
	public int getMobilePhone(double cost);
	public List<MobilePhone> getByColor(String color); 
	public List<MobilePhone> getByprocessor(String processor); 
	public int getbyuniquemodelname();//unique items
	public List<Mobiledto> getAllMobilePhones();
	public String saveusingdto(Mobiledto mobiledto);
	public Mobiledto getMobilePhoneByIdusingdto(int id);
	public List<Mobiledto> getMobilePhoneByBrandNameusingdto(String brandName);
	public List<Mobiledto> getMobilePhoneByModelNameusingdto(String modelName);
	
}
