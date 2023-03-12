package com.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

import com.application.dto.Mobiledto;
import com.application.model.MobilePhone;
public interface Mobiledao extends CrudRepository<MobilePhone, Integer> {

	public List<MobilePhone> findByBrandname(String brandName);
	public List<MobilePhone> findByModelName(String modelName);
	public List<MobilePhone> findByMobilePhoneCostGreaterThan(double cost);
	public List<MobilePhone> findByColor(String color);
	public List<MobilePhone> findByProcessor(String processor);

	
	
	
	
	
	
	
	

}
