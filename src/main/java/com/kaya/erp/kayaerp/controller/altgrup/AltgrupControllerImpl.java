package com.kaya.erp.kayaerp.controller.altgrup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.erp.kayaerp.entity.model.Altgrup;

import com.kaya.erp.kayaerp.service.altgrup.IAltgrupService;

@RestController
@RequestMapping (value="/rest/api/altgrup",produces ="application/json;charset=UTF-8")
public class AltgrupControllerImpl implements IAltgrupController {
	
	@Autowired
	private IAltgrupService altgrupService;
	
	@GetMapping("/getAllAltgrup")
	public List<Altgrup> getAllAltgrup(){
		
		return altgrupService.getAllAltgrup();
	}

	@GetMapping("/getAltgrupById/{id}")
	@Override
	public Altgrup getAltgrupByIdAltgrup(@PathVariable(name = "id") Integer id) {
		
		return altgrupService.getAltgrupByIdAltgrup(id);
			
	}
	
	@GetMapping("/getAltgrupByAltgrupKodu")
	@Override
	public List<Altgrup> getAltgrupByAltgrupKodu(@RequestParam String altgrup_kodu) {
		
		return altgrupService.getAltgrupByAltgrupKodu(altgrup_kodu);
	}
	
	@GetMapping("/getAltgrupByAltgrupDealer")
	@Override
	public List<Altgrup> getAltgrupByAltgrupDealer(@RequestParam String altgrup_dealer) {
		
		return altgrupService.getAltgrupByAltgrupDealer(altgrup_dealer);
	}
	

	@GetMapping("/getAltgrupByAltgrupAdi")
	@Override
	public List<Altgrup> getAltgrupByAltgrupAdi(@RequestParam String altgrup_adi) {
		
		return altgrupService.getAltgrupByAltgrupAdi(altgrup_adi);
	}


    

	@GetMapping("/getAltgrupByAllAltgrupAnagrupId/{id}")
	@Override
	public List<Altgrup> getAltgrupByAllAltgrupAnagrupId(@PathVariable(name="id") Integer anagrupId) {
		
		return altgrupService.getAltgrupByAllAltgrupAnagrupId(anagrupId);
	}
	
	
	@GetMapping("/getAltgrupByAltgrupAnagrupId/")
	@Override
	public List<Altgrup> getAltgrupByAltgrupAnagrupId(@RequestParam String altgrupKodu ,Integer anagrupId ) {
	    return altgrupService.getAltgrupByAltgrupAnagrupId(altgrupKodu, anagrupId);
	}


	@PostMapping("/addAndUpdateAltgrup")
 	public Altgrup addAltgrup(@RequestBody Altgrup altgrup) {
		return altgrupService.addAltgrup(altgrup);
	}
	
	@PostMapping("/addAllAltgrup")
    public List<Altgrup> addAltgrupList(@RequestBody List<Altgrup> altgrupList) {
        return altgrupService.addAltgrupList(altgrupList);
    }

	
    @DeleteMapping("/delete/{id}")
    public void deleteAltgrup(@PathVariable(name = "id") Integer id) {
    	altgrupService.deleteAltgrup(id);
    }

	
	

	
	
	
	
}