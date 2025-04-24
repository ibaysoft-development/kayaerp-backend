package com.kaya.erp.kayaerp.controller.bayi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.erp.kayaerp.entity.model.Bayi;
import com.kaya.erp.kayaerp.service.bayi.IBayiService;


@RestController
@RequestMapping(value="/rest/api/bayi", produces = "application/json;charset=UTF-8")
public class BayiControllerImpl implements IBayiController {

	@Autowired
	private IBayiService bayiService;
	
	@GetMapping("/getAllBayi")
	public List<Bayi> getAllBayi() {
		
		return bayiService.getAllBayi();
	}

	
	@GetMapping("/getBayiById/{id}")
	@Override
	public Bayi getBayiByIdBayi(@PathVariable(name = "id") Integer id) {
		
		return bayiService.getBayiByIdBayi(id);
	}

	@GetMapping("/getBayiByBayiKod")
	@Override
	public Bayi getBayiByBayiKodu(@RequestParam String bayi_kodu) {
		// TODO Auto-generated method stub
		return bayiService.getBayiBybayi_kodu(bayi_kodu);
	}

	
	@PostMapping("/addAndUpdateBayi")
	@Override
	public Bayi addBayi(@RequestBody Bayi Bayi) {
		
		return bayiService.addBayi(Bayi);
	}
	
	@PostMapping("/addAllBayi")
	public List<Bayi> addBayiList (@RequestBody List<Bayi> bayiList){
		return bayiService.addBayiList(bayiList);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteBayi(@PathVariable(name= "id") Integer id) {
		bayiService.deleteBayi(id);
	}
	
}
