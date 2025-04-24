package com.kaya.erp.kayaerp.repository.musteriKarti;

import java.util.Date;
import java.util.List;


import com.kaya.erp.kayaerp.entity.model.MusteriKarti;

public interface ICustomMusteriKarti {
	
	public List <MusteriKarti> getMusteriKartiByTCNO(String TCNO);
	

	
	
}