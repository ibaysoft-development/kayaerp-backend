package com.kaya.erp.kayaerp.controller.bayi;

import java.util.List;

import com.kaya.erp.kayaerp.entity.model.Bayi;

public interface IBayiController  {

	
	public List<Bayi> getAllBayi();
	public Bayi getBayiByIdBayi(Integer id);
	public Bayi getBayiByBayiKodu(String bayi_kod);
	public Bayi addBayi(Bayi Bayi);
	public List <Bayi> addBayiList (List <Bayi> bayiList);
	public void deleteBayi(Integer id);
	
}
