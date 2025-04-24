package com.kaya.erp.kayaerp.controller.anagrup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.erp.kayaerp.entity.model.Anagrup;
import com.kaya.erp.kayaerp.service.anagrup.IAnagrupService;

@RestController
@RequestMapping (value="/rest/api/anagrup",produces ="application/json;charset=UTF-8")
public class AnagrupControllerImpl implements IAnagrupController {
	
	@Autowired
	private IAnagrupService anagrupService;
	
	@GetMapping("/getAllAnagrup")
	public List<Anagrup> getAllAnagrup(){
		
		return anagrupService.getAllAnagrup();
	}

	@GetMapping("/getAnagrupById/{id}")
	@Override
	public Anagrup getAnagrupByIdAnagrup(@PathVariable(name = "id") Integer id) {
		
		return anagrupService.getAnagrupByIdAnagrup(id);
		
	}
     
	@GetMapping("/getAnagrupByAnagrupKod")
	@Override
	public Anagrup getAnagrupByAnagrupKod(@RequestParam String anagrup_kod) {
		
		return anagrupService.getAnagrupByAnagrupKod(anagrup_kod);
	}
    
	@GetMapping("/getAnagrupByAnagrupDealer") 
	@Override
	public List<Anagrup> getAnagrupByAnagrupDealer(@RequestParam String anagrup_dealer) {
		
		return anagrupService.getAnagrupByAnagrupDealer(anagrup_dealer);
	}
	
	@PostMapping("/addAndUpdateAnagrup")
	public Anagrup addAnagrup (@RequestBody Anagrup anagrup) {
		return anagrupService.addAnagrup(anagrup);
	}
	
	@PostMapping("/addAllAnagrup")
	public List <Anagrup> addAnagrupList(@RequestBody List <Anagrup> anagrupList) {
	    return anagrupService.addAnagrupList(anagrupList);
	
}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteAnagrup(@PathVariable(name = "id") Integer id) {
        anagrupService.deleteAnagrup(id);
    }
		
	}