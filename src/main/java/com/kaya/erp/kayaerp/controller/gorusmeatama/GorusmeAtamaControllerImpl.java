package com.kaya.erp.kayaerp.controller.gorusmeatama;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.erp.kayaerp.entity.model.GorusmeAtama;
import com.kaya.erp.kayaerp.service.gorusmeatama.IGorusmeAtamaService;

@RestController
@RequestMapping(value="/rest/api/gorusme", produces = "application/json;charset=UTF-8")
public class GorusmeAtamaControllerImpl implements IGorusmeAtamaController {

	@Autowired
	IGorusmeAtamaService gorusmeAtamaService;
	
	@Override
	@GetMapping("/getGorusmeAtamaById/{id}")
	public GorusmeAtama getGorusmeAtamaById(@PathVariable(name = "id") Integer id) {
		// TODO Auto-generated method stub
		return gorusmeAtamaService.getGorusmeAtamaById(id);
	}

	@Override
	@GetMapping("/getGorusmeAtamaByGorusmeId")
	public GorusmeAtama getGorusmeAtamaByGid(@RequestParam Integer gid) {
		// TODO Auto-generated method stub
		return gorusmeAtamaService.getGorusmeAtamaByGid(gid);
	}
	
	

}
