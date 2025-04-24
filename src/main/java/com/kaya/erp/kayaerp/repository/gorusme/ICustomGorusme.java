package com.kaya.erp.kayaerp.repository.gorusme;

import java.util.List;

import com.kaya.erp.kayaerp.entity.dto.DtoGorusmeFilter;
import com.kaya.erp.kayaerp.entity.model.Gorusme;


public interface ICustomGorusme {
	
	public List <Gorusme> getGorusmeByGorusmeUsername( String gusername);
	  List<Gorusme> getGorusmeByFilter(DtoGorusmeFilter filter);
	
}