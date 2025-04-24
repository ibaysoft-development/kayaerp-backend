package com.kaya.erp.kayaerp.controller.gorusme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaya.erp.kayaerp.entity.dto.DtoGorusmeFilter;
import com.kaya.erp.kayaerp.entity.model.Gorusme;
import com.kaya.erp.kayaerp.service.gorusme.IGorusmeService;


@RestController
@RequestMapping(value="/rest/api/gorusme", produces = "application/json;charset=UTF-8")
public class GorusmeControllerImpl implements IGorusmeController {

	@Autowired
	private IGorusmeService gorusmeService;
	
	@GetMapping("/getAllGorusme")
	public List<Gorusme> getAllGorusme() {
		
		return gorusmeService.getAllGorusme();
	}

	
	@GetMapping("/getGorusmeById/{gid}")
	@Override
	public Gorusme getGorusmeByIdGorusme(@PathVariable(name = "gid") Integer gid) {
		
		return gorusmeService.getGorusmeByIdGorusme(gid);
	}

    @GetMapping("/byUsername/{gusername}")
    public List<Gorusme> getGorusmeByGorusmeUsername(@PathVariable String gusername) {
        return gorusmeService.getGorusmeByGorusmeUsername(gusername);  
    }

    @PostMapping("/addAndUpdateGorusme")
 	public Gorusme addGorusme(@RequestBody Gorusme gorusme) {
		return gorusmeService.addGorusme(gorusme);
	}
	
	@PostMapping("/addAllGorusme")
    public List<Gorusme> addGorusmeList(@RequestBody List<Gorusme> gorusmeList) {
        return gorusmeService.addGorusmeList(gorusmeList);
    }

	
    @DeleteMapping("/delete/{gid}")
    public void deleteGorusme(@PathVariable(name = "gid") Integer gid) {
    	gorusmeService.deleteGorusme(gid);
    }


    @PostMapping("/getGorusmeByFilterDto")
	@Override
	public List<Gorusme> getGorusmeByFilterDto(DtoGorusmeFilter filter) {
		  return gorusmeService.getGorusmeByFilterDto(filter);
	}
	
	
	
}



   
