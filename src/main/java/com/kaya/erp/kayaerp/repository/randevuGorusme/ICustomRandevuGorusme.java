package com.kaya.erp.kayaerp.repository.randevuGorusme;

import java.util.Date;
import java.util.List;

import com.kaya.erp.kayaerp.entity.dto.DtoRandevuGorusmeDoluVeBos;
import com.kaya.erp.kayaerp.entity.model.RandevuGorusme;

public interface ICustomRandevuGorusme {

	public List<RandevuGorusme> getRandevuByBaslatanUser(String rbaslatanuser);
	
	public List<RandevuGorusme> findByRtarihBetweenAndRbaslatanuser(Date start, Date end, String rbaslatanuser);
	
	//public List<DtoRandevuGorusmeDoluVeBos> getRandevuDatesByDtoRandevuGorusmeDoluVeBos(String rbaslatan,String dealer,String tarih);

	//public List<RandevuGorusme> findByRtarihBetween(Date start, Date end);



	
}