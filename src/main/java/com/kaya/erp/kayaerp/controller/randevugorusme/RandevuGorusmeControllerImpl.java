package com.kaya.erp.kayaerp.controller.randevugorusme;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaya.erp.kayaerp.entity.model.RandevuGorusme;
import com.kaya.erp.kayaerp.service.randevugorusme.IRandevuGorusmeService;
import com.kaya.erp.kayaerp.entity.dto.DtoRandevuGorusmeDoluVeBos;
import com.kaya.erp.kayaerp.entity.dto.DtoRandevuGorusmeRequest;



@RestController
@RequestMapping(value="/rest/api/randevugorusme", produces = "application/json;charset=UTF-8")
public class RandevuGorusmeControllerImpl implements IRandevuGorusmeController {
	
	@Autowired
	private IRandevuGorusmeService randevugorusmeService;

	@GetMapping("/byUsername/{rbaslatanuser}")
	    public List<RandevuGorusme> getRandevuByBaslatanUser(@PathVariable String rbaslatanuser) {
	        return randevugorusmeService.getRandevuByBaslatanUser(rbaslatanuser);  
	    }
//
//	@PostMapping("/addAndUpdateGorusme")
//	public RandevuGorusme addRandevu(@RequestBody DtoRandevuGorusmeRequest dto) {
//	    return randevugorusmeService.addRandevu(dto);
//	}

	
	@PostMapping("/addAndUpdateGorusme")
	public RandevuGorusme addRandevu(@RequestBody RandevuGorusme randevuGorusme) {
		
		return randevugorusmeService.addRandevu(randevuGorusme);
	}
	
	
	@PostMapping("/getDoluSaatlerByDate")
	public List<LocalTime> getDoluSaatlerByDate(@RequestParam String kullaniciAdi, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate tarih) {
	    return randevugorusmeService.getDoluSaatlerByDate(kullaniciAdi, tarih);
	}

	@PostMapping("/getMusaitSaatlerByDate")
	public List<LocalTime> getMusaitSaatlerByDate(@RequestParam String kullaniciAdi, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate tarih) {
	    return randevugorusmeService.getMusaitSaatlerByDate(kullaniciAdi, tarih);
	}


	@PostMapping("/getRandevuDatesByDtoRandevuGorusmeDoluVeBos")
	@Override
	public List<DtoRandevuGorusmeDoluVeBos> getRandevuDatesByDtoRandevuGorusmeDoluVeBos(String rbaslatan, String dealer,
			String tarih) {
		// TODO Auto-generated method stub
		return randevugorusmeService.getRandevuDatesByDtoRandevuGorusmeDoluVeBos(rbaslatan, dealer, tarih);
	}


	





//	
//	@PostMapping("/getBugunkuDoluSaatler")
//	public List<LocalTime> getBugunkuDoluSaatler(@RequestParam String kullaniciAdi) {
//	    return randevugorusmeService.getBugunkuDoluSaatler(kullaniciAdi);
//	}
//
//
//
//	@PostMapping("/getBugunkuMusaitSaatler")
//	public List<LocalTime> getBugunkuMusaitSaatler(@RequestParam String kullaniciAdi) {
//		
//		return randevugorusmeService.getBugunkuMusaitSaatler(kullaniciAdi);
//	}

}