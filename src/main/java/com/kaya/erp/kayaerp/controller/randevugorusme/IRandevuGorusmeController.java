package com.kaya.erp.kayaerp.controller.randevugorusme;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.kaya.erp.kayaerp.entity.dto.DtoRandevuGorusmeDoluVeBos;
import com.kaya.erp.kayaerp.entity.dto.DtoRandevuGorusmeRequest;


import com.kaya.erp.kayaerp.entity.model.RandevuGorusme;

public interface IRandevuGorusmeController {
	
	public List <RandevuGorusme> getRandevuByBaslatanUser(String rbaslatanuser);
	public RandevuGorusme addRandevu (RandevuGorusme  randevuGorusme);
	public List<LocalTime> getDoluSaatlerByDate(String kullaniciAdi, LocalDate tarih);
	public List<LocalTime> getMusaitSaatlerByDate(String kullaniciAdi, LocalDate tarih);
	public List<DtoRandevuGorusmeDoluVeBos> getRandevuDatesByDtoRandevuGorusmeDoluVeBos(String rbaslatan,String dealer,String tarih);
	
	//public RandevuGorusme addRandevu(DtoRandevuGorusmeRequest dto);

}