package com.kaya.erp.kayaerp.service.musterikarti;

import java.util.Date;
import java.util.List;


import com.kaya.erp.kayaerp.entity.model.MusteriKarti;

public interface IMusteriKartiService {
	
	public List <MusteriKarti> getMusteriKartiByTCNO(String TCNO);
	public MusteriKarti addMusteriKarti(MusteriKarti musteriKarti);
	public void deleteMusteriKarti(Long MUSID);
	
}