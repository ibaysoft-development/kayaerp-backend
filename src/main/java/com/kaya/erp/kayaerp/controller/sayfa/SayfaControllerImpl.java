package com.kaya.erp.kayaerp.controller.sayfa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.erp.kayaerp.entity.dto.DtoPageByPermittedRole;
import com.kaya.erp.kayaerp.entity.model.Sayfa;
import com.kaya.erp.kayaerp.service.sayfa.ISayfaService;


@RestController
@RequestMapping(value ="/rest/api/page" ,produces = "application/json;charset=UTF-8")
public class SayfaControllerImpl implements ISayfaController{

	@Autowired
	private ISayfaService sayfaService;
	
	@GetMapping(path = "/getPagesPermittedUser")
	@Override
	public List<Sayfa> getPagesPermittedUser(int user_id) {
		// TODO Auto-generated method stub
		return sayfaService.getPagesPermittedUser(user_id);
	}

	@GetMapping(path = "/getAllPages")
	@Override
	public List<Sayfa> getAllPages() {
		// TODO Auto-generated method stub
		return sayfaService.getAllPages();
	}

	@GetMapping(path = "/getPagesByPermittedRole")
	@Override
	public List<Sayfa> getPagesByPermittedRole(int role_id) {
		// TODO Auto-generated method stub
		return sayfaService.getPagesByPermittedRole(role_id);
	}

	@GetMapping(path = "/getPagesByDtoPermittedRole")
	@Override
	public List<DtoPageByPermittedRole> getDtoPagesByPermittedRole(int role_id) {
		// TODO Auto-generated method stub
		return sayfaService.getDtoPagesByPermittedRole(role_id);
	}

	
	@PostMapping("/saveAndDeletePagesByDtoPermittedRole")
	@Override
	public List<DtoPageByPermittedRole> saveAndDeletePagesByDtoPermittedRole(@RequestBody List<DtoPageByPermittedRole> dtoPages,@RequestParam
			int role_id) {
		
		return sayfaService.saveAndDeletePagesByDtoPermittedRole(dtoPages, role_id);
	}

}
