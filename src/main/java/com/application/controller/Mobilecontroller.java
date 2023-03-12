package com.application.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Service.MobilePhoneService;
import com.application.dto.Mobiledto;
import com.application.model.MobilePhone;

@RestController
@RequestMapping("Mobile")
public class Mobilecontroller {
	
	public Mobilecontroller() {
		
	}
	@Autowired
	MobilePhoneService mobilePhoneService;
	
	@PostMapping()
	public ResponseEntity<String> addmobilephones(@RequestBody MobilePhone mobilephone) {
		
		int id = mobilephone.getMobileId();
		ResponseEntity<String> responseentity ;
		if(mobilePhoneService.isMobilephoneExists(id)) {
			String message = "Mobilephoneid already  exist";
			responseentity = new ResponseEntity<String>(message, HttpStatus.CONFLICT);
		}
		else {
		
	String message =  mobilePhoneService.saveProduct(mobilephone);
	responseentity = new ResponseEntity<String>(message, HttpStatus.OK);
	
	}
		return responseentity;
	}

	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletemobilephones(@PathVariable ("id") Integer num) {
		ResponseEntity<String> responseentity ;
		if(mobilePhoneService.isMobilephoneExists(num)) {
		
			String message =  mobilePhoneService.deleteMobilePhone(num);
			responseentity = new ResponseEntity<String>(message, HttpStatus.OK);
		}
		else {
			
			String message =  "mobile id doesnot exist cannot be deleted";
			responseentity = new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}
		return responseentity;
	}
	
	
	@GetMapping
	public ResponseEntity<List<MobilePhone>> getallmobilephones() {
		List<MobilePhone> mobilephones = mobilePhoneService.getAllMobiles();
		ResponseEntity<List<MobilePhone>> responseentity ;
		responseentity = new ResponseEntity<List<MobilePhone>>(mobilephones,HttpStatus.OK);
		return responseentity;
		
		
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<MobilePhone> getbyid(@PathVariable ("id")Integer num) {
		
		ResponseEntity<MobilePhone> responseentity ;
		if(mobilePhoneService.isMobilephoneExists(num)) {
		MobilePhone mobilephone =  mobilePhoneService.getMobilePhoneById(num);
		responseentity = new ResponseEntity<MobilePhone>(mobilephone, HttpStatus.OK);
		}else {
			MobilePhone mobilephone =  mobilePhoneService.getMobilePhoneById(num);
			responseentity = new ResponseEntity<MobilePhone>(mobilephone, HttpStatus.OK);
		}
		
		
		return responseentity;
	}
	
	@PutMapping()
		public ResponseEntity<MobilePhone> editmobilephones(@RequestBody MobilePhone mobilephone) {
		int num = mobilephone.getMobileId();
		
		ResponseEntity<MobilePhone> responseentity ;
		
	
		
		
			MobilePhone message =  mobilePhoneService.editMobilephone(mobilephone);
			responseentity = new ResponseEntity<MobilePhone>(message, HttpStatus.OK);
		
		return responseentity;
		
		
		
	}
	@GetMapping("/brand/{brandname}")
	public ResponseEntity<List<MobilePhone>> getproductbybrandname(@PathVariable ("brandname") String brandname){
		
		ResponseEntity<List<MobilePhone>> responseEntity;
		
		
		List<MobilePhone> mobilePhone = mobilePhoneService.getMobilePhoneByBrandName(brandname);
		if(mobilePhone.isEmpty()) {
			responseEntity = new ResponseEntity<List<MobilePhone>>(mobilePhone,HttpStatus.NO_CONTENT);
		}
		else {
			responseEntity = new ResponseEntity<List<MobilePhone>>(mobilePhone,HttpStatus.OK);
			
		}
		return responseEntity;
		
}
	
	@GetMapping("/model/{modelname}")
	public ResponseEntity<List<MobilePhone>> getproductbymodelname(@PathVariable ("modelname") String modelname){
		
		ResponseEntity<List<MobilePhone>> responseEntity;
		
		
		List<MobilePhone>mobilephone =  mobilePhoneService.getMobilePhoneByModelName(modelname);
		if(mobilephone.isEmpty()) {
			responseEntity = new ResponseEntity<List<MobilePhone>>(mobilephone, HttpStatus.NO_CONTENT);
		}
		else {
			responseEntity = new ResponseEntity<List<MobilePhone>>(mobilephone, HttpStatus.OK);
		}
		return responseEntity;
}
	
	@GetMapping("/greaterthan/{amount}")
	public int findallmobilephonesgreaterthan(@PathVariable("amount") double amount) {
		
		 return mobilePhoneService.getMobilePhone(amount);
		
		
		
	}
	@GetMapping("color/{colortype}")
	public List<MobilePhone> getbycolor(@PathVariable ("colortype")String color){
		
		return mobilePhoneService.getByColor(color);
	}
	
	@GetMapping("processor/{processortype}")
	public List<MobilePhone> getbyprocessor(@PathVariable("processortype")String processor){
		
		return mobilePhoneService.getByprocessor(processor);
	}
	
	@GetMapping("/unique")
	public int totalcountofuniquemobilephonewithbrandname () {
		
		return mobilePhoneService.getbyuniquemodelname();
	}
	
	@PostMapping("/post")
	public String saveallmobilephones( @RequestBody Mobiledto mobiledto){
		return mobilePhoneService.saveusingdto(mobiledto);
		
	}
	
	@GetMapping("/Mobiledto")
	public List<Mobiledto> getallmobilephonesusingdto(){
		
		List<Mobiledto> mobiledto=mobilePhoneService.getAllMobilePhones();
		return mobiledto;
	}
	
@GetMapping("/Mobiledto/{id}")
public Mobiledto getMobilePhoneByIdusingdto(@PathVariable ("id")Integer num) {
	
	return mobilePhoneService.getMobilePhoneByIdusingdto(num);
}

@GetMapping("/Mobiledto/brand/{brandname}")
public List<Mobiledto> getMobilePhoneBybrandnameusingdto(@PathVariable ("brandname")String brandname) {
	
	return mobilePhoneService.getMobilePhoneByBrandNameusingdto(brandname) ;
}

@GetMapping("/Mobiledto/model/{modelname}")
public List<Mobiledto> getMobilePhoneBymodelnameusingdto(@PathVariable ("modelname")String modelname) {
	
	return mobilePhoneService.getMobilePhoneByModelNameusingdto(modelname);
}
	
	
	
}
	
		
	
	
	

	
	

