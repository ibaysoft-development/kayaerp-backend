package com.kaya.erp.kayaerp.controller.servisarac;

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

import com.kaya.erp.kayaerp.entity.dto.DtoServisAracFilter;
import com.kaya.erp.kayaerp.entity.model.ServisArac;
import com.kaya.erp.kayaerp.service.servisarac.IServisAracService;


@RestController
@RequestMapping(value = "/rest/api/servisarac", produces = "application/json;charset=UTF-8")
public class ServisAracControllerImpl implements IServisAracController {
	@Autowired
	private IServisAracService servisaracService;

	@GetMapping("/getAllServisArac")
	public List<ServisArac> getAllServisArac() {

		return servisaracService.getAllServisArac();
	}

	@GetMapping("/getServisAracById/{ARACID}")
	@Override
	public ServisArac getServisAracByIdServisArac(@PathVariable(name = "ARACID") Long ARACID) {

		return servisaracService.getServisAracByIdServisArac(ARACID);
	}

	@GetMapping("/getServisAracByServisAracMarka")
	@Override
	public List<ServisArac> getServisAracByMARKA(String MARKA) {

		return servisaracService.getServisAracByMARKA(MARKA);
	}

	@GetMapping("/getServisAracByServisAracModel")
	@Override
	public List<ServisArac> getServisAracByMODEL(String MODEL) {

		return servisaracService.getServisAracByMODEL(MODEL);
	}

	@GetMapping("/getServisAracByServisAracPlaka")
	@Override
	public List<ServisArac> getServisAracByPLAKA(String PLAKA) {

		return servisaracService.getServisAracByPLAKA(PLAKA);
	}

	@GetMapping("/getServisAracByServisAracSasi")
	@Override
	public ServisArac getServisAracBySASI(String SASI) {

		return servisaracService.getServisAracBySASI(SASI);
	}


	@GetMapping("/getServisAracByServisAracEklenmeTarihi")
	@Override
	public List<ServisArac> getServisAracByEKLENMETARIHI(@RequestParam("bastar") String bastar,
			@RequestParam("bittar") String bittar) {

		return servisaracService.getServisAracByEKLENMETARIHI(bastar, bittar);
	}

	@PostMapping("/addAndUpdateServisArac")
 	public ServisArac addServisArac(@RequestBody ServisArac servisArac) {
		return servisaracService.addServisArac(servisArac);
	}
	
	@PostMapping("/addAllServisArac")
    public List<ServisArac> addServisAracList(@RequestBody List<ServisArac> servisAracList) {
        return servisaracService.addServisAracList(servisAracList);
    }

	
    @DeleteMapping("/delete/{ARACID}")
    public void deleteServisArac(@PathVariable(name = "ARACID") Long ARACID) {
        servisaracService.deleteServisArac(ARACID);
    }

    @PostMapping("/getServisAracByDtoServiceAracFilter")
	@Override
	public List<ServisArac> getServisAracByDtoServiceAracFilter(DtoServisAracFilter filter) {
		// TODO Auto-generated method stub
		return servisaracService.getServisAracByDtoServiceAracFilter(filter);
	}

}