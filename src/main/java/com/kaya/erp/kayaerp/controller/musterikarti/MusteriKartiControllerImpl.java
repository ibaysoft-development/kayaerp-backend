package com.kaya.erp.kayaerp.controller.musterikarti;

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
import com.kaya.erp.kayaerp.entity.model.MusteriKarti;
import com.kaya.erp.kayaerp.service.musterikarti.IMusteriKartiService;


@RestController
@RequestMapping(value = "/rest/api/musterikarti", produces = "application/json;charset=UTF-8")
public class MusteriKartiControllerImpl implements IMusteriKartiController {
	@Autowired
	private IMusteriKartiService musterikartiService;
	
	@GetMapping("/getMusteriKartiByMusteriKartiTcno")
	@Override
	public List <MusteriKarti> getMusteriKartiByTCNO(String TCNO) {

		return musterikartiService.getMusteriKartiByTCNO(TCNO);
	}
	
	@PostMapping("/addAndUpdateMusteriKarti")
 	public MusteriKarti addMusteriKarti(@RequestBody MusteriKarti musteriKarti) {
		return musterikartiService.addMusteriKarti(musteriKarti);
	}

	@DeleteMapping("/delete/{MUSID}")
	public void deleteMusteriKarti(@PathVariable(name = "MUSID") Long MUSID) {
		musterikartiService.deleteMusteriKarti(MUSID);
		
	}
   
}
