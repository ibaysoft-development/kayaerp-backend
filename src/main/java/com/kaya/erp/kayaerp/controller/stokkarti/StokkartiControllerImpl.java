package com.kaya.erp.kayaerp.controller.stokkarti;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.kaya.erp.kayaerp.entity.model.StokKarti;
import com.kaya.erp.kayaerp.service.stokkarti.IStokKartiService;

@RestController
@RequestMapping(value="/rest/api/stok_karti", produces = "application/json;charset=UTF-8")
public class StokkartiControllerImpl implements IStokkartiController {
	@Autowired
	private IStokKartiService stokkartiService;
	
	@GetMapping("/getAllStokKarti")
	public List<StokKarti> getAllStokKarti() {
		
		return stokkartiService.getAllStokKarti();
	}

	
	@GetMapping("/getStokKartiByIdStokKarti/{sid}")
	@Override
	public StokKarti getStokKartiByIdStokKarti(@PathVariable(name = "sid") Integer sid) {
		
		return stokkartiService.getStokKartiByIdStokKarti(sid);
	} 
	
	@GetMapping("/getStokKartiByStokKartiAdi")
	
	public List<StokKarti> getStokKartiBysadi(@RequestParam String sadi) {
		
		return stokkartiService.getStokKartiBysadi(sadi);
	}
}

//@RestController
//@RequestMapping(value="/rest/api/stok", produces = "application/json;charset=UTF-8")
//public class StokControllerImpl implements IStokController {

//	@Autowired
//	private IStokService stokService;
	
//	@GetMapping("/getAllStok")
//	public List<Stok> getAllStok() {
		
//		return stokService.getAllStok();
//	}
	
//	@GetMapping("/getStokById/{id}")
//	@Override
//	public Stok getStokByIdStok(@PathVariable(name = "id") Integer id) {
		
//		return stokService.getStokByIdStok(id);
//	}

//	@GetMapping("/getStokStokName")
//	@Override
//	public Stok getStokByStokName(@RequestParam String stok_name) {
		// TODO Auto-generated method stub
//		return stokService.getStokByStokName(stok_name);
//	}
//
//	
//}


