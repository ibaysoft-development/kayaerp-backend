package com.kaya.erp.kayaerp.controller.musterikarti;

import java.util.Date;
import java.util.List;


import com.kaya.erp.kayaerp.entity.model.MusteriKarti;

public interface IMusteriKartiController {
	
	public List <MusteriKarti> getMusteriKartiByTCNO(String TCNO);
	public MusteriKarti addMusteriKarti(MusteriKarti musteriKarti);
	public void deleteMusteriKarti(Long MUSID);
	
	
}