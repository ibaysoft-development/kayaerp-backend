package com.kaya.erp.kayaerp.service.randevugorusme;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


import com.kaya.erp.kayaerp.entity.model.RandevuGorusme;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaya.erp.kayaerp.entity.dto.DtoRandevuGorusmeDoluVeBos;
import com.kaya.erp.kayaerp.entity.dto.DtoRandevuGorusmeRequest;

public interface IRandevuGorusmeService {
	
	public List<RandevuGorusme> getRandevuByBaslatanUser(String rbaslatanuser);
	public RandevuGorusme addRandevu (RandevuGorusme  randevuGorusme);
	//public List<LocalTime> getBugunkuDoluSaatler();
	public List<LocalTime> getMusaitSaatlerByDate(String kullaniciAdi, LocalDate tarih);
	public List<LocalTime> getDoluSaatlerByDate(String kullaniciAdi, LocalDate tarih);
	public List<DtoRandevuGorusmeDoluVeBos> getRandevuDatesByDtoRandevuGorusmeDoluVeBos(String rbaslatan,String dealer,String tarih);
	
    // Randevu oluştur
	//public RandevuGorusme addRandevu(DtoRandevuGorusmeRequest dto);
	
	// Belirli bir gün ve kullanıcıya göre dolu saatleri getir
	//public List<LocalTime> getDoluSaatlerByDate(DtoRandevuGorusmeRequest dto);

    // Belirli bir gün ve kullanıcıya göre müsait saatleri getir
	//public List<LocalTime> getMusaitSaatlerByDate(DtoRandevuGorusmeRequest dto);
}