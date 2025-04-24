package com.kaya.erp.kayaerp.controller.gorusme;

import java.util.List;

import com.kaya.erp.kayaerp.entity.dto.DtoGorusmeFilter;
import com.kaya.erp.kayaerp.entity.model.Gorusme;

public interface IGorusmeController  {

	
	public List<Gorusme> getAllGorusme();
	public Gorusme getGorusmeByIdGorusme(Integer gid);
	public  List<Gorusme> getGorusmeByGorusmeUsername(String gusername);
	public Gorusme addGorusme (Gorusme gorusme);
	public List <Gorusme> addGorusmeList (List <Gorusme> gorusmeList);
	public void deleteGorusme (Integer gid);
	List<Gorusme> getGorusmeByFilterDto(DtoGorusmeFilter filter);
	
	
}
